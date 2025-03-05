/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.java;

import dao.TransactionDAO;
import dao.WalletDAO;
import models.Transaction;
import models.Wallet;

/**
 *
 * @author nischal
 */
public class TransactionService {

    private TransactionDAO td;
    private WalletDAO wd;
    
    public TransactionService(WalletDAO wd, TransactionDAO td){
        this.td=td;
        this.wd=wd;
    }
    
    public boolean addTransaction(double amount,String status, String transactionType,Long walletId){
        Transaction transc = new Transaction();
        transc.setTransactionType(transactionType);
        transc.setAmount(amount);
        transc.setStatus(status);
        Wallet wallet = wd.findById(walletId);
        transc.setWallet(wallet);
        
        if(td.save(transc)){
            return true;
        }else{
            return false;
        }
    }
}
