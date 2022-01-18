package com.revature.DAO;

import com.revature.models.UserDetailModels;

import java.util.List;

public interface UserDetailDAO {
    public List<UserDetailModels> findAll();
    public UserDetailModels findByName(String name);
    public boolean updateUserDetail(UserDetailModels userDetail);
    public boolean addUserDetail(UserDetailModels userDetail);
}
