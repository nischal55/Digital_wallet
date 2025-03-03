package models;

import jakarta.persistence.*;

@Entity
@Table(name="wallet")
public class Wallet extends BaseEntity{
    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name="balance",unique = false, nullable = false)
    private double balance;
    
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
  
}
