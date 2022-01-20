package com.revature.services;

import com.revature.DAO.UserDetailDAO;
import com.revature.DAO.UserDetailDAOImpl;
import com.revature.models.UserDetailModels;

import java.util.List;

public class UserDetailService {
    private UserDetailDAO userDetailDAO = new UserDetailDAOImpl();

    public List<UserDetailModels> findAll(){
        return userDetailDAO.findAll();
    }
    public UserDetailModels findByName(String name){
        return userDetailDAO.findByName(name);
    }
    public boolean updateUserDetail(UserDetailModels userDetail){
        return userDetailDAO.updateUserDetail(userDetail);
    }
    public boolean addUserDetail(UserDetailModels userDetail){
        return userDetailDAO.addUserDetail(userDetail);
    }
    public boolean updateDetail(UserDetailModels detail){
        return userDetailDAO.updateUserDetail(detail);
    }
    public boolean addDetail(UserDetailModels detail){
        return userDetailDAO.addUserDetail(detail);
    }
}
