package com.revature.DAO;

import com.revature.models.LoginDTO;
import com.revature.models.UserModels;

import java.util.List;

public interface UserDAO {
    List<UserModels> findAll();
    UserModels findUser(int id);
    boolean updateUser(UserModels user);
    boolean Login(String username, String password);
}
