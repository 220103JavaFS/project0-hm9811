package com.revature.DAO;

import com.revature.models.UserBalanceModels;
import com.revature.models.UserModels;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBalanceDAOImpl implements UserBalanceDAO{
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public UserBalanceModels findUserBalance(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM userBalance WHERE user_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            UserBalanceModels userBalance = new UserBalanceModels();
            while(result.next()){
                userBalance.setBlanaceId(result.getInt("balance_id"));
                int userId = result.getInt("user_id");
                UserModels user = userDAO.findUser(userId);
                userBalance.setUser(user);
                userBalance.setBalance(result.getFloat("user_balance"));
            }
            return userBalance;

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return new UserBalanceModels();
    }

    @Override
    public boolean updateBalance(UserBalanceModels userBalance, boolean deposit) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE userBalance SET user_balance = user_balance " + (deposit ? "+" : "-") + " ? WHERE balance_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setFloat(1, userBalance.getBalance());
            statement.setInt(2, userBalance.getBalanceId());
            statement.execute();
            return !(userBalance.getBalance() <= 0);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
