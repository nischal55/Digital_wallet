/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.java;

import dao.LotteryDAO;
import dao.LotteryTicketDAO;
import dao.UserDAO;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import models.Lottery;
import models.LotteryTicket;
import models.User;

/**
 *
 * @author nischal
 */
public class LotteryTicketService {
    
    private LotteryTicketDAO ld;
    private LotteryDAO lotteryDao;
    private UserDAO ud;
    
    public LotteryTicketService(LotteryTicketDAO ld, LotteryDAO lotteryDAO,UserDAO ud){
        this.ld = ld;
        this.lotteryDao = lotteryDAO;
        this.ud = ud;
    }
    
    
     public boolean buyLotteryTicket(Long userId, Long lotteryId, LocalDate createdAt){
        boolean status = false;
        
        int latest_ticket_no = ld.getLatestLotteryTicket()+1;
        LotteryTicket lt = new LotteryTicket();
        
        Lottery lottery = lotteryDao.findById(lotteryId);
        lt.setLottery(lottery);
        lt.setTicketNumber(latest_ticket_no);
        lt.setCreatedAt(createdAt);
        
        User user = ud.findById(userId);
        lt.setUser(user);
        
        if(ld.save(lt)){
            status = true;
        }
        
        
        return status;
    }
     
    public int findLotteryResult(Long lotteryId) {
        List<Integer> tickets = ld.findLotteryTicketsByLotteryId(lotteryId);

        int result = 0;
        try {
            
            Random rand = new Random();

            int randomIndex = rand.nextInt(tickets.size());

            int randomNumber = tickets.get(randomIndex);
            result = randomNumber;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
