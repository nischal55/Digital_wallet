/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.TransactionDAO;
import dao.impl.TransactionDaoImpl;
import models.Transaction;
/**
 *
 * @author nischal
 */
public class TransactionController {
    public String transactionType;
    public double amount;
    public boolean status;
    public Long walletId;
    public String timeStamp;
    
    TransactionDAO td = new TransactionDaoImpl();
    
    public void addTransaction(TransactionController tc){
        Transaction transaction = new Transaction();
        transaction.setTransactionType(tc.transactionType);
        transaction.setAmount(tc.amount);
        transaction.setStatus(tc.status);
        transaction.setWalletId(tc.walletId);
        
        if(td.save(transaction)){
            System.out.println("Transaction saved Successfully");
        }
    }
}
