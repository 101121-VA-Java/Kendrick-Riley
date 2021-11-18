package com.revature;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import io.javalin.Javalin;



public class Diver {

	public static void main(String[] args) {
		Routes r = new Routes();
		r.run();

	}

}
