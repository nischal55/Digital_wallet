package models;

import jakarta.persistence.*;

@Entity
@Table(name="wallet")
public class Wallet extends BaseEntity{
    @Column(name="userId",unique=true, nullable = false)
    private Long userId;
    
    @Column(name="balance",unique = false, nullable = false)
    private double balance;
    
    //getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
}
