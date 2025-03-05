package com.example;

import dao.WalletDAO;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Service.java.WalletService;
import models.Wallet;
import models.User;
import dao.UserDAO;

/**
 *
 * @author nischal
 */
public class WalletServiceTest {

    public WalletDAO mockWalletDao;
    public WalletService mockWalletService;
    public UserDAO mockUserDao;

    @BeforeEach
    void setup() {
        mockWalletDao = mock(WalletDAO.class);
        mockUserDao = mock(UserDAO.class);
        mockWalletService = new WalletService(mockWalletDao, mockUserDao);
    }

    @Test
    void testWalletBalance() {
        // Arrange
        Long userId = 1L;
        Wallet mockWallet = new Wallet();
        mockWallet.setBalance(100.0);

        // Ensure the mockWalletDao returns the mocked wallet
        when(mockWalletDao.getWalletByUserId(userId)).thenReturn(mockWallet);

        // Act
        double balance = mockWalletService.getBalanceByUserId(userId);

        // Assert
        assertEquals(100.0, balance);
    }

    @Test
    void testLoadBalance() {
        // Arrange
        Long userId = 1L;
        double balanceToAdd = 50.0;
        Wallet wallet = new Wallet();
        wallet.setBalance(100.0);
        User user = new User();
        user.setId(userId);
        when(mockWalletDao.getWalletByUserId(userId)).thenReturn(wallet);
        when(mockUserDao.findById(userId)).thenReturn(user);
        when(mockWalletDao.update(wallet)).thenReturn(true);

        // Act
        boolean result = mockWalletService.loadBalance(balanceToAdd, userId);

        assertTrue(result);
        assertEquals(150, wallet.getBalance());
    }

    @Test
    void testTransferBalance() {
        // Arrange
        Long senderId = 1L;
        String receiverContact = "9801194990";
        double transferAmount = 100.0;

        Wallet senderWallet = new Wallet();
        senderWallet.setBalance(500);

        Wallet receiverWallet = new Wallet();
        receiverWallet.setBalance(200);

        when(mockWalletDao.getWalletByUserId(senderId)).thenReturn(senderWallet);
        when(mockWalletDao.getWalletByContact(receiverContact)).thenReturn(receiverWallet);

        when(mockWalletDao.update(senderWallet)).thenReturn(true);
        when(mockWalletDao.update(receiverWallet)).thenReturn(true);

        boolean result = mockWalletService.balanceTransfer(senderId, receiverContact, transferAmount);

        assertTrue(result,"The Balance should be Transfered");
        assertEquals(400,senderWallet.getBalance());
        assertEquals(300,receiverWallet.getBalance());
    }
    
    @Test 
    void testDeductBalance(){
        Long userId = 1L;
        double deductAmount = 100;
        
        Wallet wallet = new Wallet();
        wallet.setBalance(500);
        
        when(mockWalletDao.getWalletByUserId(userId)).thenReturn(wallet);
        when(mockWalletDao.update(wallet)).thenReturn(true);
        
        boolean result = mockWalletService.deductBalance(userId, deductAmount);
        
        assertTrue(result, "The balance should be deducted");
        assertEquals(400,wallet.getBalance());
        
    }

}
