package com.revature.controllers;

import com.revature.models.LoginDTO;
import com.revature.models.UserModels;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class UserController implements Controller{
    private UserService userService = new UserService();

    Handler getAllUser = (ctx) -> {
        if(ctx.req.getSession(false) == null){
            ctx.json(userService.findAllUser());
            ctx.status(200);
        }else{
            ctx.status(401);
        }
    };

    Handler getUser = (ctx) -> {
        if(ctx.req.getSession(false) == null){
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);
            UserModels user = userService.findUser(id);
            ctx.json(user);
            ctx.status(200);
        }else{
            ctx.status(401);
        }
    };
    private Handler login = (ctx) -> {
        LoginDTO user = ctx.bodyAsClass(LoginDTO.class); // A DTO (Data transfer object) is a tempory object used just to communicate information.

        user = userService.login(user.username, user.password);
        if(user != null){
            ctx.req.getSession();
            ctx.status(200);
        }else {
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }
    };

    private Handler logout = ctx -> {
        if (ctx.req.getSession(false) != null) {
            ctx.req.getSession().invalidate();
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/user", getAllUser);
        app.get("/user/{id}", getUser);
        app.post("/login", this.login);
        app.post("/logout", this.logout);
    }
}
