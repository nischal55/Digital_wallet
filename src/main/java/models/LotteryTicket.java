package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lottery_ticket")
public class LotteryTicket extends BaseEntity{
    
    @Column(name="lottery_id",unique = false, nullable=false)
    private Long lotteryId;
    
    @Column(name="userId",unique = false, nullable=false)
    private Long userId;
    
    @Column(name="ticket_number",unique = true, nullable=false)
    private int ticketNumber;
    
    @Column(name="createdAt",unique = false, nullable=false)
    private LocalDate createdAt;

    public Long getLotteryId() {
        return lotteryId;
    }

    public void setLotteryId(Long lotteryId) {
        this.lotteryId = lotteryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
