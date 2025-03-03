/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import models.Transaction;
import java.util.List;

/**
 *
 * @author nischal
 */
public interface TransactionDAO {
    boolean save(Transaction transaction);
    Transaction findById(Long id);
    List<Transaction> findAll();
    boolean update(Transaction transaction);
    boolean deleteById(Long id); 
    List<Transaction> getTransactionByWalletId(Long walletId);
    
}
