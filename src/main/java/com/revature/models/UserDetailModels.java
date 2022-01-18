package com.revature.models;

import java.util.Objects;

public class UserDetailModels {
    private String userName;
    private String userStr;
    private String userCity;
    private String userRegion;
    private String userZip;
    private String userCountry;

    public UserDetailModels() {
    }

    public UserDetailModels(String userName, String userStr, String userCity, String userRegion, String userZip, String userCountry) {
        this.userName = userName;
        this.userStr = userStr;
        this.userCity = userCity;
        this.userRegion = userRegion;
        this.userZip = userZip;
        this.userCountry = userCountry;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailModels that = (UserDetailModels) o;
        return Objects.equals(userName, that.userName) && Objects.equals(userStr, that.userStr) && Objects.equals(userCity, that.userCity) && Objects.equals(userRegion, that.userRegion) && Objects.equals(userZip, that.userZip) && Objects.equals(userCountry, that.userCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userStr, userCity, userRegion, userZip, userCountry);
    }

    @Override
    public String toString() {
        return "UserDetailModels{" +
                "userName='" + userName + '\'' +
                ", userStr='" + userStr + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userRegion='" + userRegion + '\'' +
                ", userZip='" + userZip + '\'' +
                ", userCountry='" + userCountry + '\'' +
                '}';
    }
}
