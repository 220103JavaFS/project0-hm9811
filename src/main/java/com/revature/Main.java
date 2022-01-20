package com.revature;
import com.revature.controllers.*;
import io.javalin.Javalin;

import java.util.*;

public class Main{
    private static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create();

        configure(new UserDetailController(), new UserController(), new UserBalanceController(), new LoginController());
        app.start();
    }
    private static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}