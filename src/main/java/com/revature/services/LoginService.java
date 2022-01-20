package com.revature.services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.LoginDTO;

public class LoginService {
    private UserDAO userDAO = new UserDAOImpl();
    public LoginDTO login(String username, String password){
        return userDAO.Login(username, password);
    }
}
