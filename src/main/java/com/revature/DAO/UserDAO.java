package com.revature.DAO;

import com.revature.models.UserModels;

import java.util.List;

public interface UserDAO {
    List<UserModels> findAll();
    UserModels findUser(int id);
    boolean addUser(UserModels user);
    boolean updateUser(UserModels user);
    boolean deleteUser(int id);
}
