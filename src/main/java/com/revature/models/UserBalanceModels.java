package com.revature.models;

import java.util.Objects;

public class UserBalanceModels {
    private int blanaceId;
    private UserModels user;
    private int balance;

    public UserBalanceModels() {
    }

    public UserBalanceModels(int blanaceId, UserModels user, int balance) {
        this.blanaceId = blanaceId;
        this.user = user;
        this.balance = balance;
    }

    public int getBlanaceId() {
        return blanaceId;
    }

    public void setBlanaceId(int blanaceId) {
        this.blanaceId = blanaceId;
    }

    public UserModels getUser() {
        return user;
    }

    public void setUser(UserModels user) {
        this.user = user;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBalanceModels that = (UserBalanceModels) o;
        return blanaceId == that.blanaceId && balance == that.balance && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blanaceId, user, balance);
    }

    @Override
    public String toString() {
        return "UserBalanceModels{" +
                "blanaceId=" + blanaceId +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }
}
