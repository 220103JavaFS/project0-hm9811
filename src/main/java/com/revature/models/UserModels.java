package com.revature.models;

import java.util.Objects;

public class UserModels {
    private int id;
    private UserDetailModels userNames;
    private String userAccount;
    private String userEmail;
    private String userPassword;
    private RoleModels roles;

    public UserModels() {
    }

    public UserModels(int id, UserDetailModels userName, String userAccount, String userEmail, String userPassword, RoleModels roles) {
        this.id = id;
        this.userNames = userName;
        this.userAccount = userAccount;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDetailModels getUserNames() {
        return userNames;
    }

    public void setUserNames(UserDetailModels userNames) {
        this.userNames = userNames;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public RoleModels getRoles() {
        return roles;
    }

    public void setRoles(RoleModels roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModels that = (UserModels) o;
        return id == that.id && roles == that.roles && Objects.equals(userNames, that.userNames) && Objects.equals(userAccount, that.userAccount) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userPassword, that.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userNames, userAccount, userEmail, userPassword, roles);
    }

    @Override
    public String toString() {
        return "UserModels{" +
                "id=" + id +
                ", userName='" + userNames + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleId=" + roles +
                '}';
    }
}
