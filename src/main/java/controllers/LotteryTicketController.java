/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import models.LotteryTicket;
import dao.impl.LotteryTicketDaoImpl;
import dao.LotteryTicketDAO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nischal
 */
public class LotteryTicketController {
    public Long userId;
    public int ticket_no;
    public Long lottery_id;
    LotteryTicketDAO ld = new LotteryTicketDaoImpl();
    public LocalDate createdAt;
    
    public LotteryTicketController(){
        this.createdAt = LocalDate.now();
    }
    
    public boolean buyLotteryTicket(LotteryTicketController lc){
        boolean status = false;
        
        int latest_ticket_no = ld.getLatestLotteryTicket()+1;
        LotteryTicket lt = new LotteryTicket();
        lt.setLottery_id(lc.lottery_id);
        lt.setTicket_number(latest_ticket_no);
        lt.setCreatedAt(createdAt);
        lt.setUser_id(lc.userId);
        if(ld.save(lt)){
            status = true;
        }
        
        
        return status;
    }
    
    public List<LotteryTicket> getTicketsByUserId(Long userId){
        List<LotteryTicket> lotteryTickets = ld.getTicketByUserId(userId);
        
        return lotteryTickets;
    }
    
    
}
