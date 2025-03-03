package models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name="wallet_id", nullable=false)
    private Wallet wallet;
    
    @Column(name="transaction_type",unique = false, nullable=false)
    private String transactionType;
    
    @Column(name="amount",unique = false, nullable=false)
    private double amount;
    
    @Column(name="status",unique = false, nullable=false)
    private String status;

    @Column(name="time_stamp",unique = false, nullable=false)
    private LocalDateTime timeStamp;
    
    
    public Transaction(){
        this.timeStamp = LocalDateTime.now();
    }
    
    //getters and setters

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
  

    



}
