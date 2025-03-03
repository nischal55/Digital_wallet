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

/**
 *
 * @author nischal
 */
public class LotteryController {
    public String lotterName;
    public double prize_amount;
    public LocalDate drawDate;
    public String status;
    public LocalDate createdAt;
    public double ticketPrice;
    LotteryDAO ld = new LotteryDaoImpl();
    
    public LotteryController(){
        this.createdAt = LocalDate.now();
    }
    
    public boolean saveLottery(LotteryController lc){
        Lottery lottery = new Lottery();
        boolean status = false;
        lottery.setLotteryName(lc.lotterName);
        lottery.setPrizeAmount(lc.prize_amount);
        lottery.setDrawDate(lc.drawDate);
        lottery.setStatus("Opened");
        lottery.setCreatedAt(createdAt);
        lottery.setTicketPrice(lc.ticketPrice);
        
        if(ld.save(lottery)){
            status= true;
        }
        
        return status;
    }
    
    
    public List<Lottery> getAllLottery(){
        List<Lottery> lottery = ld.findAll();
        
        return lottery;
    }
    
}
