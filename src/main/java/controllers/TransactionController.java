/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.TransactionDAO;
import dao.WalletDAO;
import dao.impl.TransactionDaoImpl;
import dao.impl.WalletDaoImpl;
import java.util.List;
import models.Transaction;
import models.Wallet;
/**
 *
 * @author nischal
 */
public class TransactionController {
    public String transactionType;
    public double amount;
    public String status;
    public Long walletId;
    public String timeStamp;
    
    TransactionDAO td = new TransactionDaoImpl();
    WalletDAO wd = new WalletDaoImpl();
    
    public void addTransaction(TransactionController tc){
        Transaction transc = new Transaction();
        transc.setTransactionType(tc.transactionType);
        transc.setAmount(tc.amount);
        transc.setStatus(tc.status);
        Wallet wallet = wd.findById(tc.walletId);
        transc.setWallet(wallet);
        
        if(td.save(transc)){
            System.out.println("Transaction saved Successfully");
        }else{
            System.out.println("Transaction Failed to be added");
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
