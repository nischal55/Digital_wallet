package models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction extends BaseEntity{
    
    @Column(name="walletId", unique = false, nullable = false)
    private Long walletId;
    
    @Column(name="transactionType",unique = false, nullable=false)
    private String transactionType;
    
    @Column(name="amount",unique = false, nullable=false)
    private double amount;
    
    @Column(name="status",unique = false, nullable=false)
    private String status;

    @Column(name="timeStamp",unique = false, nullable=false)
    private LocalDateTime timeStamp;
    
    
    public Transaction(){
        this.timeStamp = LocalDateTime.now();
    }
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp(){
        return timeStamp;
    }
    

    



}
