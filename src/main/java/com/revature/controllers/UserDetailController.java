package com.revature.controllers;


import com.revature.models.UserDetailModels;
import com.revature.services.UserDetailService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.List;

public class UserDetailController implements Controller {
    private UserDetailService userDetailService = new UserDetailService();

    Handler getDetails = (ctx) ->{
        if(ctx.req.getSession(false) != null) {
            ctx.json(userDetailService.findAll());
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    Handler getDetail = (ctx) -> {
        if(ctx.req.getSession(false) != null) {
            String userName = ctx.pathParam("userName");
            UserDetailModels user = userDetailService.findByName(userName);
            ctx.json(user);
            ctx.status(200);
        }else{
            ctx.status(401);
        }
    };

    Handler updateDetail = (ctx) ->{
      if(ctx.req.getSession(false) != null){
          UserDetailModels detail = ctx.bodyAsClass(UserDetailModels.class);
          if(userDetailService.updateDetail(detail)){
              ctx.status(202);
          }else{
              ctx.status(400);
          }
      }
      else{
          ctx.status(401);
      }
    };

    Handler addDetail = (ctx) -> {
      if(ctx.req.getSession(false) != null){
          UserDetailModels detail = ctx.bodyAsClass(UserDetailModels.class);
          if(userDetailService.addDetail(detail)){
              ctx.status(202);
          }else {
              ctx.status(400);
          }
      }
      else{
          ctx.status(401);
      }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.get("/detail", getDetails);
        app.get("/detail/{userName}", getDetail);
        app.put("/detail", updateDetail);
        app.post("/detail", addDetail);
    }
}
