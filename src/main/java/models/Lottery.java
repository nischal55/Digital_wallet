package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lottery")
public class Lottery extends BaseEntity{
    
    @Column(name="lottery_name",unique = false, nullable=false)
    private String lottery_name;
    
    @Column(name="ticket_price",unique = false, nullable=false)
    private double ticket_price;
    
    @Column(name="prize_amount",unique = false, nullable=false)
    private double prize_amount;
    
    @Column(name="draw_date",unique = false, nullable=false)
    private LocalDate draw_date;
    
    @Column(name="status",unique = false, nullable=false)
    private String status;
    
    @Column(name="createdAt",unique = false, nullable=false)
    private String createdAt;

    public String getLottery_name() {
        return lottery_name;
    }

    public void setLottery_name(String lottery_name) {
        this.lottery_name = lottery_name;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public double getPrize_amount() {
        return prize_amount;
    }

    public void setPrize_amount(double prize_amount) {
        this.prize_amount = prize_amount;
    }

    public LocalDate getDraw_date() {
        return draw_date;
    }

    public void setDraw_date(LocalDate draw_date) {
        this.draw_date = draw_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    
}
