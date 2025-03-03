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
   
    public boolean balanceTransfer(Long userId, String contact, double transfer_amount){
        boolean status = false;
        System.out.println("contact"+contact);
        System.out.println("Balance:"+transfer_amount);
        if(wd.transferBalance(userId, contact, transfer_amount)){
            status = true;
        }
        
        
        return status;
    }
    
    public boolean deduct_balance(Long userId,double deduct_balance){
        boolean status = false;
        Wallet wallet = wd.getWalletByUserId(userId);
        double balance = wallet.getBalance()-deduct_balance;
        wallet.setBalance(balance);
        
        if(wd.update(wallet)){
            status= true;
        }
        
        return status;
    }
}
