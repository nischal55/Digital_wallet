/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.java;

import dao.LotteryDAO;
import dao.LotteryTicketDAO;
import dao.UserDAO;
import dao.impl.LotteryDaoImpl;
import dao.impl.LotteryTicketDaoImpl;
import dao.impl.UserDaoImpl;
import java.time.LocalDate;
import models.Lottery;
import models.LotteryTicket;
import models.User;

/**
 *
 * @author nischal
 */
public class LotteryTicketService {
    
    LotteryTicketDAO ld = new LotteryTicketDaoImpl();
    LotteryDAO lotteryDao = new LotteryDaoImpl();
    UserDAO ud = new UserDaoImpl();
    
    
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
    
}
