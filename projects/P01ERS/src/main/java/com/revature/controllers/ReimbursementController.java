package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ReimbursementService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursementController {
	private static ReimbursementService rs = new ReimbursementService();
	private static AuthService as = new AuthService();

	public static void add(Context ctx) {
		int reimbId = rs.add(ctx.bodyAsClass(Reimbursement.class));
		if (reimbId == -1) {
			ctx.status(HttpCode.BAD_REQUEST);
		} else {
			ctx.status(HttpCode.CREATED);
		}
	}

	public static void get(Context ctx) {

		String token = ctx.header("Authorization");
		if (as.checkPermission(token, 4)) {

			List<Reimbursement> reim = null;
			if (ctx.queryParam("author-id") == null)
				reim = rs.getReimbursements();
			else {
				int authorId = Integer.parseInt(ctx.queryParam("author-id"));
				if (authorId > 0)
					reim = rs.getReimbursementsByEmployeeId(authorId);
			}
			if (reim == null)
				ctx.status(HttpCode.BAD_REQUEST);
			else
				ctx.json(reim);
			ctx.status(HttpCode.CREATED);
		} else if (as.checkPermission(token, 3)) {

			String[] info = token.split(":");
			int empId = Integer.parseInt(info[0]);
			List<Reimbursement> reim = rs.getReimbursementsByEmployeeId(empId);
			if (reim == null)
				ctx.status(HttpCode.BAD_REQUEST);
			else
				ctx.json(reim);
			ctx.status(HttpCode.CREATED);
		} else {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
	}

	public static void update(Context ctx) {
		String token = ctx.header("Authorization");
		if (!as.checkPermission(token, 4)) {
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
		int id = Integer.parseInt(ctx.pathParam("id"));
		String str = ctx.body();
		System.out.println(str);

		int statusId = Integer.parseInt(str);
		Reimbursement r = rs.getById(id);
		r.setStatus_Id(statusId);
		String[] info = token.split(":");
		int manager_Id = Integer.parseInt(info[0]);
		r.setResolver(manager_Id);
		if (rs.updateReim(r) > 0)
			ctx.status(HttpCode.OK);
		else
			ctx.status(400);
	}

	public static void getPending(Context ctx) {
		System.out.println("you at getPending");
		String token = ctx.header("Authorization");

		if (as.checkPermission(token, 4)) {
			List<Reimbursement> reim = null;
			if (ctx.queryParam("author-id") == null)
				reim = rs.viewPendingReimb(0);
			else {
				int authorId = Integer.parseInt(ctx.queryParam("author-id"));
				if (authorId > 0)
					reim = rs.viewPendingReimb(authorId);
			}
			if (reim == null)
				ctx.status(HttpCode.BAD_REQUEST);
			else
				ctx.json(reim);
			ctx.status(HttpCode.CREATED);
		} else if (as.checkPermission(token, 3)) {
			String[] info = token.split(":");
			int userId = Integer.parseInt(info[0]);
			List<Reimbursement> reim = rs.viewPendingReimb(userId);
			if (reim == null)
				ctx.status(HttpCode.BAD_REQUEST);
			else
				ctx.json(reim);
			ctx.status(HttpCode.CREATED);
		} else {
			System.out.println("you at get pending controller");
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}
	}

	public static void getPendingId(Context ctx) {
		System.out.println("you at last pending id");
		String token = ctx.header("Authorization");
		if (as.checkPermission(token, 4)) {
			
			String[] info = token.split(":");
			int userId = Integer.parseInt(info[0]);
			List<Reimbursement> reim = rs.getReimbursementsByEmployeeId(userId);
			if (reim == null)
				ctx.status(HttpCode.BAD_REQUEST);
			else
				ctx.json(reim);
			ctx.status(HttpCode.CREATED);
		} else {
			System.out.println("you at get pending controller");
			ctx.status(HttpCode.UNAUTHORIZED);
			return;
		}

	}
}
