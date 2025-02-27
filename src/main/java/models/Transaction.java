package models;


public class Transaction {
    private int transactionId;
    private Wallet walletId;
    private String transactionType;
    private double amount;
    private boolean status;
    private String timeStamp;

    public int getTransactionId() {
        return transactionId;
    }

    public Wallet getWalletId() {
        return walletId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setWalletId(Wallet walletId) {
        this.walletId = walletId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    
}
