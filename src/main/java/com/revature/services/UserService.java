package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.LoginDTO;
import com.revature.models.UserModels;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private UserModels user = new UserModels();

    public List<UserModels> findAllUser(){
        return userDAO.findAll();
    }

    public UserModels findUser(int id){
        return userDAO.findUser(id);
    }

    public LoginDTO login(String username, String password){
        return userDAO.Login(username, password);
    }
}
