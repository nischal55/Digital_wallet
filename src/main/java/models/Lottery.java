package models;

public class Lottery {
    private int lottery_id;
    private String lottery_name;
    private double ticket_price;
    private double prize_amount;
    private String draw_date;
    private String status;
    private String createdAt;

    public int getLottery_id() {
        return lottery_id;
    }

    public String getLottery_name() {
        return lottery_name;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public double getPrize_amount() {
        return prize_amount;
    }

    public String getDraw_date() {
        return draw_date;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setLottery_id(int lottery_id) {
        this.lottery_id = lottery_id;
    }

    public void setLottery_name(String lottery_name) {
        this.lottery_name = lottery_name;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public void setPrize_amount(double prize_amount) {
        this.prize_amount = prize_amount;
    }

    public void setDraw_date(String draw_date) {
        this.draw_date = draw_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
