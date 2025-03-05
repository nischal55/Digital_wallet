package com.example;

import dao.WalletDAO;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dao.TransactionDAO;
import models.Transaction;
import models.Wallet;
import Service.java.TransactionService;


/**
 *
 * @author nischal
 */
public class TransactionServiceTest {
    
    public WalletDAO mockWalletDao;
    public TransactionDAO mockTransactionDao;
    public TransactionService mockTransactionService;
    
    @BeforeEach
    void setup(){
        mockWalletDao = mock(WalletDAO.class);
        mockTransactionDao = mock(TransactionDAO.class);
        mockTransactionService = new TransactionService(mockWalletDao, mockTransactionDao);
    }
    
    @Test
    void addTransaction(){
        double amount = 100;
        String status = "Completed";
        String transactionType = "load_balance";
        Long walletId = 1L;
        
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        
        
        when(mockWalletDao.findById(walletId)).thenReturn(wallet);
        
        when(mockTransactionDao.save(any(Transaction.class))).thenReturn(true);
        boolean result = mockTransactionService.addTransaction(amount, status, transactionType, walletId);
        
        assertTrue(result,"Transaction should be added");
        
    }
    
}
