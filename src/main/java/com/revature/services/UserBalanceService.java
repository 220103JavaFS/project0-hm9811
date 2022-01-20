package com.revature.services;

import com.revature.DAO.UserBalanceDAO;
import com.revature.DAO.UserBalanceDAOImpl;
import com.revature.models.UserBalanceModels;

public class UserBalanceService {
    private UserBalanceDAO userBalanceDAO = new UserBalanceDAOImpl();
    public UserBalanceModels findUserBalance(int id){
        return userBalanceDAO.findUserBalance(id);
    }
    public boolean deposit(UserBalanceModels userBalance, boolean deposit){
        return userBalanceDAO.updateBalance(userBalance, true);
    }
    public boolean withdraw(UserBalanceModels userBalance, boolean deposit){
        return userBalanceDAO.updateBalance(userBalance, false);
    }
}
