package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lottery_ticket")
public class LotteryTicket extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name="lottery_id", nullable=false)
    private Lottery lottery;
    
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
    @Column(name="ticket_number",unique = true, nullable=false)
    private int ticketNumber;
    
    @Column(name="created_at",unique = false, nullable=false)
    private LocalDate createdAt;

    public Lottery getLottery() {
        return lottery;
    }

    public void setLottery(Lottery lottery) {
        this.lottery = lottery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }



    
   
}
