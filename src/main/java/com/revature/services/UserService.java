package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.UserModels;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public List<UserModels> findAllUser(){
        return userDAO.findAll();
    }

    public UserModels findUser(int id){
        return userDAO.findUser(id);
    }

    public boolean updateUser(UserModels user){
        return userDAO.updateUser(user);
    }

}
