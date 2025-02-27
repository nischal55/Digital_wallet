package models;

import jakarta.persistence.*;

@Entity
@Table(name="lotteryTickets")
public class LotteryTicket extends BaseEntity{
    
    @Column(name="lotteryId",unique = false, nullable=false)
    private Long lottery_id;
    
    @Column(name="userId",unique = false, nullable=false)
    private Long user_id;
    
    @Column(name="ticket_number",unique = false, nullable=false)
    private int ticket_number;
    
    @Column(name="createdAt",unique = false, nullable=false)
    private String createdAt;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    
   
}
