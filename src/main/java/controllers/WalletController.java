package controllers;

import models.Wallet;
import dao.WalletDAO;
import dao.impl.WalletDaoImpl;

public class WalletController {
    public double balance = 0;
    public Long userId;
    WalletDAO wd = new WalletDaoImpl();
    
    public boolean createWallet(WalletController wc){
        boolean status = false;
        Wallet wallet = new Wallet();
        wallet.setBalance(wc.balance);
        wallet.setUserId(wc.userId);
        
        if(wd.save(wallet)){
            status=true;
        }
        
        return status;
    }
    
    
    public double getBalanceByUserId(Long id){
        double balance = wd.getWalletByUserId(id).getBalance();
        return balance;
    }
    
    
    public boolean loadBalance(WalletController wc){
        
        boolean status = false;
        double old_balance = wc.getBalanceByUserId(userId);
        Wallet wallet = wd.getWalletByUserId(userId);
        wallet.setBalance(old_balance+wc.balance);
        wallet.setUserId(wc.userId);
       
        
        if(wd.update(wallet)){
            status = true;
        }
        
        return status;
    }
    
    public Long getWalletIdByUserId(Long id){
        Long walletId = wd.getWalletByUserId(id).getId();
        return walletId;
    }
   
    
}
