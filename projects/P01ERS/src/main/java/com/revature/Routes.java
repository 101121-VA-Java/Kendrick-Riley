package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import io.javalin.Javalin;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.*;
import static io.javalin.apibuilder.ApiBuilder.put;

public class Routes {
	public void run() {
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();

		}).start();

		app.before(ctx -> {
			ctx.header("Access-Control-Allow-Headers", "Authorization");
			ctx.header("Access-Control-Expose-Headers", "Authorization");
		});

		app.routes(() -> {
			path("reimbursement", () -> {
				post(ReimbursementController::add);
				get(ReimbursementController::get);
				path("pending", () -> {
					get(ReimbursementController::getPending);
				});
				path("{id}", () -> {
					get(ReimbursementController::getPendingId);
					put(ReimbursementController::update);
				});

			});
			path("auth", () -> {
				post(AuthController::login);
			});
			path("users", () -> {
				get(UserController::getByUsername);
				post(UserController::registerUser);
				path("getAll", () -> {
					get(UserController::getUsers);
				});
				path("{id}", () -> {
					get(UserController::getUserById);
					put(UserController::updateUser);
				});
			});
		});

	}
}
