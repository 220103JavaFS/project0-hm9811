package com.revature.models;

import java.util.Objects;

public class UserModels {
    private int id;
    private String userAccount;
    private String userEmail;
    private String userPassword;
    private UserDetailModels userNames;
    private RoleModels roles;

    public UserModels() {
    }

    public UserModels(int id, String userAccount, String userEmail, String userPassword, UserDetailModels userNames, RoleModels roles) {
        this.id = id;
        this.userAccount = userAccount;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNames = userNames;
        this.roles = roles;
    }

    public UserModels(String userAccount, String userEmail, String userPassword, UserDetailModels userNames, RoleModels roles) {
        this.userAccount = userAccount;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNames = userNames;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserDetailModels getUserNames() {
        return userNames;
    }

    public void setUserNames(UserDetailModels userNames) {
        this.userNames = userNames;
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
        return id == that.id && Objects.equals(userAccount, that.userAccount) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userPassword, that.userPassword) && Objects.equals(userNames, that.userNames) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccount, userEmail, userPassword, userNames, roles);
    }

    @Override
    public String toString() {
        return "UserModels{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNames=" + userNames +
                ", roles=" + roles +
                '}';
    }
}
