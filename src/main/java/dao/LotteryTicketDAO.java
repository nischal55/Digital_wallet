/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.LotteryTicket;
import models.Lottery;

/**
 *
 * @author nischal
 */
public interface LotteryTicketDAO {
    boolean save(LotteryTicket lotteryTicket);
    boolean update(LotteryTicket lotteryTicket);
    boolean deleteById(Long id);  
    LotteryTicket findById(Long id);
    List<LotteryTicket> findAll();
    int getLatestLotteryTicket();
    List<Object[]> getTicketByUserId(Long id);
    List<Object[]> getAllTickets();
    int findLotteryResult(Long lotteryId);
    Long findUserIdByTicketNumber(int ticketNumber);
    Lottery findLotteryByTicket(int ticketNumber);
    
}
