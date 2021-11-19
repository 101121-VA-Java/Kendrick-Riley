package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import io.javalin.Javalin;
import com.revature.controllers.EmployeeController;

public class Routes {
	public void run() {
		Javalin app = Javalin.create((config) -> {
			config.enableCorsForAllOrigins();

		}).start();

		app.routes(() -> {
			path("reimbursement", () -> {
				post(EmployeeController::addReimbursementRequest);
			});
			path("auth", () ->{
				post(AuthController::login);
			});
		});

	}

}
