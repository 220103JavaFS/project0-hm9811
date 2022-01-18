package com.revature.DAO;

import com.revature.models.RoleModels;
import com.revature.models.UserDetailModels;
import com.revature.models.UserModels;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

     private UserDetailDAO userDetailDAO = new UserDetailDAOImpl();
    @Override
    public List<UserModels> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<UserModels> list = new ArrayList<>();

            while(result.next()){
                UserModels user = new UserModels();
                user.setId(result.getInt("user_id"));
                String userName = result.getString("user_name");
                if(userName != null){
                    UserDetailModels userDetail = userDetailDAO.findByName(userName);
                    user.setUserNames(userDetail);
                }
                user.setUserAccount(result.getString("user_acc"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserPassword(result.getString("user_password"));
                RoleModels role = new RoleModels(result.getInt("role_id"), result.getString("role_name"));
                user.setRoles(role);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<UserModels>();
    }

    @Override
    public UserModels findUser(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE user_id " + id + ";";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            UserModels user = new UserModels();
            while(result.next()){
                user.setId(result.getInt("user_id"));
                String userName = result.getString("user_name");
                if(userName != null){
                    UserDetailModels userDetail = userDetailDAO.findByName(userName);
                    user.setUserNames(userDetail);
                }
                user.setUserAccount(result.getString("user_acc"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserPassword(result.getString("user_password"));
                RoleModels role = new RoleModels(result.getInt("role_id"), result.getString("role_name"));
                user.setRoles(role);
            }
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return new UserModels();
    }

    @Override
    public boolean addUser(UserModels user) {
        return false;
    }

    @Override
    public boolean updateUser(UserModels user) {
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
