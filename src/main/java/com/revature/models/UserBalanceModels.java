package com.revature.models;

import java.util.Objects;

public class UserBalanceModels {
    private int balanceId;
    private UserModels user;
    private float balance;

    public UserBalanceModels() {
    }

    public UserBalanceModels(int blanaceId, UserModels user, int balance) {
        this.balanceId = blanaceId;
        this.user = user;
        this.balance = balance;
    }

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    public UserModels getUser() {
        return user;
    }

    public void setUser(UserModels user) {
        this.user = user;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBalanceModels that = (UserBalanceModels) o;
        return balanceId == that.balanceId && balance == that.balance && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceId, user, balance);
    }

    @Override
    public String toString() {
        return "UserBalanceModels{" +
                "blanaceId=" + balanceId +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }
}
