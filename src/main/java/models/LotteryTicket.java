package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lotteryTickets")
public class LotteryTicket extends BaseEntity{
    
    @Column(name="lottery_id",unique = false, nullable=false)
    private Long lottery_id;
    
    @Column(name="userId",unique = false, nullable=false)
    private Long user_id;
    
    @Column(name="ticket_number",unique = false, nullable=false)
    private int ticket_number;
    
    @Column(name="createdAt",unique = false, nullable=false)
    private LocalDate createdAt;
    
    
    private String lottery_name;

    public Long getLottery_id() {
        return lottery_id;
    }

    public void setLottery_id(Long lottery_id) {
        this.lottery_id = lottery_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getLotteryName(){
        return lottery_name;
    }

    
   
}
