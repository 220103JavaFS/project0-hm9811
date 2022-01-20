package com.revature.controllers;


import com.revature.models.UserDetailModels;
import com.revature.services.UserDetailService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class UserDetailController implements Controller {
    private UserDetailService userDetailService = new UserDetailService();

    Handler getDetails = (ctx) ->{
        //if(ctx.req.getSession(false) != null) {// getSession(false) will only return a session object if the client
            //setn a cookie along with the request that matches an open session.
            ctx.json(userDetailService.findAll());
            ctx.status(200);
        //}else {
        //    ctx.status(401);
        //}
    };

    Handler getDetail = (ctx) -> {
        //if(ctx.req.getSession(false) != null) {// getSession(false) will only return a session object if the client
            String userName = ctx.pathParam("userName");
            UserDetailModels user = userDetailService.findByName(userName);
            ctx.json(user);
            ctx.status(200);
        //}else{
        //    ctx.status(401);
        //}
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/detail", getDetails);
        app.get("/detail/{userName}", getDetail);
    }
}
