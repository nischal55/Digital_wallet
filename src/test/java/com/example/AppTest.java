package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import controllers.WalletController;
import controllers.LotteryTicketController;

public class AppTest {
    
    private WalletController wc;
    private LotteryTicketController lt;
    
    @BeforeEach
    void setUp() {
         wc = new WalletController();
         lt = new LotteryTicketController();
    }

    //Test for testing the load balance
    @Test
    public void load_balance() {
      wc.balance = 10000;
      wc.userId = 4l;
      
      boolean result = wc.loadBalance(wc);
      assertTrue(result, "Balance should be loaded successfully");
      
    }
    
    //Test for testing balance transfer
    @Test
    public void balance_transfer(){
        Long userId = 4l;
        String contact = "9841220813";
        double amount = 100;
        
        boolean result = wc.balanceTransfer(userId, contact, amount);
        assertTrue(result,"Balance Transfered successfully");
        
    }
    
    
    //Testing case for buying Tickets
    @Test
    public void buyLotteryTicket(){
        lt.lottery_id = 4l;
        lt.userId = 4l;
        
        boolean result = lt.buyLotteryTicket(lt);
        assertTrue(result,"Ticket should be Purchased");
    }
   
    
    //Testing for finding Result of Lottery
    @Test
    public void findLotteryResult(){
        Long lotteryId = 4l;
        
        int result = lt.findLotteryResult(lotteryId);
        
        assertTrue(result>0,"Lottery Result should be Generated");
    }
    
}
