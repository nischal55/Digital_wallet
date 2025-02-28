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
        double balance = wd.getWalletByUserId(userId).getBalance();
        return balance;
    }
    
   
    
}
