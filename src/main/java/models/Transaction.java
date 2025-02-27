package models;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {
    
    @Column(name="walletId", unique = false, nullable = false)
    private Long walletId;
    
    @Column(name="transactionType",unique = false, nullable=false)
    private String transactionType;
    
    @Column(name="transactionType",unique = false, nullable=false)
    private double amount;
    
    @Column(name="status",unique = false, nullable=false)
    private boolean status;
    
    @Column(name="timeStamp",unique = false, nullable=false)
    private String timeStamp;

    
    //getters and setters
    
    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
    
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }



}
