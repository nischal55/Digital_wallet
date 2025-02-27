package models;


public class Wallet {
    private int walletId;
    private User userId;
    private double balance;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
