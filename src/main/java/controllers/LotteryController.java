/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.LotteryDAO;
import dao.impl.LotteryDaoImpl;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import models.Lottery;
import models.LotteryTicket;

/**
 *
 * @author nischal
 */
public class LotteryController {
    public LocalDate createdAt;
    LotteryDAO ld = new LotteryDaoImpl();
    
    public LotteryController(){
        this.createdAt = LocalDate.now();
    }
    
    public boolean saveLottery(String lotteryName,double prize_amount,LocalDate drawDate,double ticketPrice){
        Lottery lottery = new Lottery();
        boolean status = false;
        lottery.setLotteryName(lotteryName);
        lottery.setPrizeAmount(prize_amount);
        lottery.setDrawDate(drawDate);
        lottery.setStatus("Opened");
        lottery.setCreatedAt(createdAt);
        lottery.setTicketPrice(ticketPrice);
        
        if(ld.save(lottery)){
            status= true;
        }
        
        return status;
    }
    
    
    public List<Lottery> getAllLottery(){
        List<Lottery> lottery = ld.findAll();
        
        return lottery;
    }
    
     public void changeTicketStatus(Lottery lc){
        lc.setStatus("Closed");
        
        if(ld.update(lc)){
            System.out.println("Ticket status changed to closed");
        }
    }
}
