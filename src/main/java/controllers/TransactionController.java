/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Service.java.TransactionService;
import dao.TransactionDAO;
import dao.WalletDAO;
import dao.impl.TransactionDaoImpl;
import dao.impl.WalletDaoImpl;
import java.util.List;
import models.Transaction;
/**
 *
 * @author nischal
 */
public class TransactionController {
    
    TransactionDAO td = new TransactionDaoImpl();
    WalletDAO wd = new WalletDaoImpl();
    
    TransactionService service = new TransactionService(wd,td);
    
    public void addTransaction(double amount,String status, String transactionType,Long walletId){
        if(service.addTransaction(amount, status, transactionType, walletId)){
            System.out.println("Transaction added Successfully");
        }else{
            System.out.println("Failed to add transaction");
        }
    }
    
    public List<Transaction> getAllTransaction(){
        List<Transaction> transactions = td.findAll();
        return transactions;
    }
    
     public List<Transaction> getTransactionByWalletId(Long wallet_id){
        List<Transaction> transactions = td.getTransactionByWalletId(wallet_id);
        return transactions;
    }
}
