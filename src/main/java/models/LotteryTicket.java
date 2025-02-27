package models;


public class LotteryTicket {
    private int ticket_id;
    private Lottery lottery_id;
    private User user_id;
    private int ticket_number;
    private String createdAt;

    public int getTicket_id() {
        return ticket_id;
    }

    public Lottery getLottery_id() {
        return lottery_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setLottery_id(Lottery lottery_id) {
        this.lottery_id = lottery_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

   
}
