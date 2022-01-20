package com.revature.DAO;

import com.revature.models.LoginDTO;
import com.revature.models.RoleModels;
import com.revature.models.UserDetailModels;
import com.revature.models.UserModels;
import com.revature.utils.ConnectionUtil;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

     private UserDetailDAO userDetailDAO = new UserDetailDAOImpl();
    @Override
    public List<UserModels> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM (SELECT * FROM users LEFT JOIN roles ON roles.role_id = users.role_id ) AS role_id;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<UserModels> list = new ArrayList<>();

            while(result.next()){
                UserModels user = new UserModels();
                user.setId(result.getInt("user_id"));
                user.setUserAccount(result.getString("user_acc"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserPassword(result.getString("user_password"));
                String userName = result.getString("user_name");
                if(userName != null){
                    UserDetailModels userDetail = userDetailDAO.findByName(userName);
                    user.setUserNames(userDetail);
                }
                RoleModels role = new RoleModels(result.getInt("role_id"),
                        result.getString("role_name"));
                user.setRoles(role);
                list.add(user);
            }

            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<UserModels>();
    }

    @Override
    public UserModels findUser(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM (SELECT * FROM users LEFT JOIN roles ON roles.role_id = users.role_id )" +
                    " AS role_id WHERE user_id = " + id + ";";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            UserModels user = new UserModels();

            while(result.next()){
                user.setId(result.getInt("user_id"));
                user.setUserAccount(result.getString("user_acc"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserPassword(result.getString("user_password"));
                String userName = result.getString("user_name");
                if(userName != null){
                    UserDetailModels userDetail = userDetailDAO.findByName(userName);
                    user.setUserNames(userDetail);
                }
                RoleModels role = new RoleModels(result.getInt("role_id"),
                        result.getString("role_name"));
                user.setRoles(role);
            }
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return new UserModels();
    }

    @Override
    public boolean updateUser(UserModels user) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE users SET user_email = ?, user_password = ? WHERE user_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, user.getUserEmail());
            statement.setString(++count, user.getUserPassword());
            statement.setInt(++count, user.getId());

            statement.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Login(String username, String password) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM users WHERE user_acc = '" + username +"' and user_password = '" + password + "';";
            Statement statement = conn.createStatement();

            //sql = "SELECT * from mytable WHERE username='" + username + "' and password='"password"';";

            ResultSet result = statement.executeQuery(sql);
            if(result.next())
            {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
