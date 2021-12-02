package com.revature.controllers;

import java.util.List;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.daos.UserDao;
import com.revature.models.Role;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UserController {
	public UserDao ud;
	private static UserService us = new UserService();
	private static AuthService as = new AuthService();

	public static void getUsers(Context ctx) {
		System.out.println("here");
		String token = ctx.header("Authorization");
		
		if (!as.checkPermission(token, 4)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		List<User> users = us.getUsers();
		ctx.json(users);
		ctx.status(HttpCode.OK);
	
	}

	public static void registerUser(Context ctx) {
		int userId = us.addUser(ctx.bodyAsClass(User.class)); // should return new user id // successful, or null
																// otherwise
		if (userId == -1) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}

	}

	public static void getByUsername(Context ctx) {
		String username = ctx.body();
		User u = us.getByUsername(username);
		if (u != null) {
			ctx.json(u);
			ctx.status(HttpCode.OK);
		} else {
			System.out.println("get user by username Wrong 1 line 49 controller");
			ctx.json("Error");
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	public static void getUserById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		System.out.println(id);
		User u = us.getUserById(id);
		if (u != null) {
			ctx.json(u);
			ctx.status(HttpCode.OK);
		} else {
			System.out.println("get user by Id contr1");
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	public static void updateUser(Context ctx) {
		System.out.println(ctx.body());
		User updated = ctx.bodyAsClass(User.class);
//		System.out.println(updated);
		System.out.println(updated.getId());
		User upUser = us.getUserById(updated.getId());
//		updated.setManager(upUser.getManager());
		if(us.updateUser(updated) <= 0){
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.OK);
			System.out.println("Test222");
		}
	
	}

}
