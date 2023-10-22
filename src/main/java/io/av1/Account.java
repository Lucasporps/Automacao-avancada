package io.av1;

public class Account {
    private String idAccount;
    private double balance;

    public Account(String idAcount, double balance) {
        this.idAccount = idAcount;
        this.balance = balance;
    }

    public String getIdAccount() {
        return this.idAccount;
    }

    public void Deposit(double value) {
        this.balance += value;
    }

    public boolean Withdraw(double value) {
        if (value >= this.balance) {
            this.balance -= value;
            return true;
        } else {
            return false;
        }
    }
}
