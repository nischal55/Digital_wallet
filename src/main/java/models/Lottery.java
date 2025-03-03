package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lottery")
public class Lottery extends BaseEntity{
    
    @Column(name="lottery_name",unique = false, nullable=false)
    private String lotteryName;
    
    @Column(name="ticket_price",unique = false, nullable=false)
    private double ticketPrice;
    
    @Column(name="prize_amount",unique = false, nullable=false)
    private double prizeAmount;
    
    @Column(name="draw_date",unique = false, nullable=false)
    private LocalDate drawDate;
    
    @Column(name="status",unique = false, nullable=false)
    private String status;
    
    @Column(name="createdAt",unique = false, nullable=true)
    private LocalDate createdAt;

    public String getLotteryName() {
        return lotteryName;
    }

    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    
}
