package com.revature.controllers;

import com.revature.models.UserBalanceModels;
import com.revature.services.UserBalanceService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserBalanceController implements Controller {
    private UserBalanceService userBalanceService = new UserBalanceService();

    Handler getBalance = (ctx) -> {
        if(ctx.req.getSession(false) != null){
        String idString = ctx.pathParam("id");
        int id = Integer.parseInt(idString);
        ctx.json(userBalanceService.findUserBalance(id));
        ctx.status(200);
        }else{
            ctx.status(401);
        }
    };

    Handler deposit = (ctx) -> {
        if(ctx.req.getSession(false) != null) {
            UserBalanceModels userBalance = ctx.bodyAsClass(UserBalanceModels.class);
            if (userBalanceService.deposit(userBalance, true)) {
                ctx.status(202);
            } else {
                ctx.status(400);
            }
        }else{
            ctx.status(401);
        }
    };
    Handler withdraw = (ctx) -> {
        if(ctx.req.getSession(false) != null) {
            UserBalanceModels userBalance = ctx.bodyAsClass(UserBalanceModels.class);
            if (userBalanceService.withdraw(userBalance, false)) {
                ctx.status(202);
            } else {
                ctx.status(400);
            }
        }else{
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("balance/{id}", getBalance);
        app.put("balance/deposit", deposit);
        app.put("balance/withdraw", withdraw);

    }
}
