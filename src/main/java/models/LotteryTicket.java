package models;


public class LotteryTicket extends BaseEntity{
    private Long lottery_id;
    private User user_id;
    private int ticket_number;
    private String createdAt;

    public Long getLottery_id() {
        return lottery_id;
    }

    public void setLottery_id(Long lottery_id) {
        this.lottery_id = lottery_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
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
