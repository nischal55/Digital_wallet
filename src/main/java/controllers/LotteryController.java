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
    public String createdAt;
    public double ticketPrice;
    LotteryDAO ld = new LotteryDaoImpl();
    
    public LotteryController(){
        this.createdAt = LocalDateTime.now().toString();
    }
    
    public boolean saveLottery(LotteryController lc){
        Lottery lottery = new Lottery();
        boolean status = false;
        lottery.setLottery_name(lc.lotterName);
        lottery.setPrize_amount(lc.prize_amount);
        lottery.setDraw_date(lc.drawDate);
        lottery.setStatus("Opened");
        lottery.setCreatedAt(createdAt);
        lottery.setTicket_price(lc.ticketPrice);
        
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
