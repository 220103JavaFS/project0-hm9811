package com.revature.DAO;

import com.revature.models.UserDetailModels;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDetailDAOImpl implements UserDetailDAO{
    @Override
    public List<UserDetailModels> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM userDetail;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<UserDetailModels> list = new ArrayList<>();

            while(result.next()){
                UserDetailModels userDetail = new UserDetailModels();
                userDetail.setUserName(result.getString("home_name"));
                userDetail.setUserStr(result.getString("home_str"));
                userDetail.setUserCity(result.getString("home_city"));
                userDetail.setUserRegion(result.getString("home_region"));
                userDetail.setUserZip(result.getString("home_zip"));
                userDetail.setUserCountry(result.getString("home_country"));
                list.add(userDetail);
            }

            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<UserDetailModels>();
    }

    @Override
    public UserDetailModels findByName(String name) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM homes WHERE home_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            UserDetailModels userDetail = new UserDetailModels();
            while(result.next()){
                userDetail.setUserName(result.getString("home_name"));
                userDetail.setUserStr(result.getString("home_str"));
                userDetail.setUserCity(result.getString("home_city"));
                userDetail.setUserRegion(result.getString("home_region"));
                userDetail.setUserZip(result.getString("home_zip"));
                userDetail.setUserCountry(result.getString("home_country"));
            }
            return userDetail;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new UserDetailModels();
    }

    @Override
    public boolean updateUserDetail(UserDetailModels userDetail) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE userDetail SET user_name = ?, user_str = ?, user_city = ?, user_region = ?, user_zip = ?, user_country = ? WHERE user_name = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, userDetail.getUserName());
            statement.setString(++count, userDetail.getUserStr());
            statement.setString(++count, userDetail.getUserCity());
            statement.setString(++count, userDetail.getUserRegion());
            statement.setString(++count, userDetail.getUserZip());
            statement.setString(++count, userDetail.getUserCountry());
            statement.setString(++count, userDetail.getUserName());

            statement.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUserDetail(UserDetailModels userDetail) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO userDetail (user_name, user_str, user_city , user_region, user_zip, user_country) VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, userDetail.getUserName());
            statement.setString(++count, userDetail.getUserStr());
            statement.setString(++count, userDetail.getUserCity());
            statement.setString(++count, userDetail.getUserRegion());
            statement.setString(++count, userDetail.getUserZip());
            statement.setString(++count, userDetail.getUserCountry());

            statement.execute();

            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
