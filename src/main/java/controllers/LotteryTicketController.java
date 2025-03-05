/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import Service.java.LotteryTicketService;
import dao.LotteryDAO;
import dao.impl.LotteryTicketDaoImpl;
import dao.LotteryTicketDAO;
import dao.UserDAO;
import dao.impl.LotteryDaoImpl;
import dao.impl.UserDaoImpl;
import java.time.LocalDate;
import java.util.List;
import models.Lottery;

/**
 *
 * @author nischal
 */
public class LotteryTicketController {
    LotteryTicketDAO ld = new LotteryTicketDaoImpl();
    
    LotteryDAO lotteryDao = new LotteryDaoImpl();
    UserDAO ud = new UserDaoImpl();
    LotteryTicketService service = new LotteryTicketService(ld,lotteryDao,ud);
    
    
    
    public LocalDate createdAt;
    
    public LotteryTicketController(){
        this.createdAt = LocalDate.now();
    }
    
    public boolean buyLotteryTicket(Long userId, Long lotteryId){
        return service.buyLotteryTicket(userId, lotteryId, createdAt);
    }
    
    public List<Object[]> getTicketsByUserId(Long userId){
        List<Object[]> lotteryTickets = ld.getTicketByUserId(userId);
        
        return lotteryTickets;
    }
    
    public List<Object[]> getAllTickets(){
        List<Object[]> tickets = ld.getAllTickets();
        return tickets;
    }
    
    public int findLotteryResult(Long lotteryId){
        int result = service.findLotteryResult(lotteryId);
        return result;
    }
    
    public Long findUserIdByTicketNumber(int ticketNumber){
        Long userId = ld.findUserIdByTicketNumber(ticketNumber);
        return userId;
    }
    
    public Lottery findLotteryByTicket(int ticketNumber){
        Lottery lottery = ld.findLotteryByTicket(ticketNumber);
        return lottery;
    }
    
    
   
}
