package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Service.java.LotteryTicketService;
import dao.LotteryDAO;
import dao.LotteryTicketDAO;
import dao.UserDAO;
import java.time.LocalDate;
import models.User;
import models.Lottery;
import models.LotteryTicket;

/**
 *
 * @author nischal
 */
public class LotteryTicketTest {

    public LotteryTicketDAO mockLotteryTicketDao;
    public LotteryDAO mockLotteryDao;
    public UserDAO mockUserDao;
    public LotteryTicketService mockLotteryTicketService;

    @BeforeEach
    void setup() {
        mockLotteryTicketDao = mock(LotteryTicketDAO.class);
        mockLotteryDao = mock(LotteryDAO.class);
        mockUserDao = mock(UserDAO.class);

        mockLotteryTicketService = new LotteryTicketService(mockLotteryTicketDao, mockLotteryDao, mockUserDao);

    }
    
    @Test
    public void testBuyTicket(){
        Long userId = 1L;
        Long lotteryId = 1L;
        LocalDate createdAt = LocalDate.now();
        
        Lottery lottery = new Lottery();
        lottery.setId(lotteryId);
        User user = new User();
        user.setId(userId);
        
        when(mockLotteryDao.findById(lotteryId)).thenReturn(lottery);
        when(mockUserDao.findById(userId)).thenReturn(user);
        when(mockLotteryTicketDao.save(any(LotteryTicket.class))).thenReturn(true);
        
        boolean result = mockLotteryTicketService.buyLotteryTicket(userId, lotteryId, createdAt);
        
        assertTrue(result, "Ticket should be Purchased");
  
    }
}
