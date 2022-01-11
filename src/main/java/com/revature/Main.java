package com.revature;
import com.revature.controllers.Controller;
import io.javalin.Javalin;

import java.util.*;

public class Main{
    private static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create();

        app.get("/hello", ((ctx) ->{
            String url = ctx.url();
            System.out.println(url);
            ctx.html("<h1> Hello Javalin</h1>");
            ctx.status(200);
        }));
        app.start();
    }
    public static void configure(Controller... controllers){

        for(Controller c: controllers){
            c.addRoutes(app);
        }

    }
}