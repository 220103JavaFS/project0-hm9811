package com.revature.DAO;

import com.revature.models.UserBalanceModels;

public interface UserBalanceDAO {
    UserBalanceModels findUserBalance(int id);
    boolean updateBalance(UserBalanceModels userBalance, boolean deposit);
}
