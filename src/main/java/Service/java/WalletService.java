/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.java;

import dao.UserDAO;
import dao.WalletDAO;
import dao.impl.UserDaoImpl;
import dao.impl.WalletDaoImpl;
import models.User;
import models.Wallet;

/**
 *
 * @author nischal
 */
public class WalletService {
    WalletDAO wd = new WalletDaoImpl();
    UserDAO ud = new UserDaoImpl();
    
    public double getBalanceByUserId(Long id) {
        double balance = wd.getWalletByUserId(id).getBalance();
        return balance;
    }
    
    public boolean loadBalance(double balance, Long userId) {

        boolean status = false;
        double old_balance = getBalanceByUserId(userId);
        Wallet wallet = wd.getWalletByUserId(userId);
        wallet.setBalance(old_balance + balance);
        User user = ud.findById(userId);

        wallet.setUser(user);

        if (wd.update(wallet)) {
            status = true;
        }

        return status;
    }
    
    public boolean balanceTransfer(Long userId, String contact, double transferAmount) {
        boolean status = false;
        System.out.println("contact" + contact);
        System.out.println("Balance:" + transferAmount);
        if (wd.transferBalance(userId, contact, transferAmount)) {
            status = true;
        }

        return status;
    }
    
    public boolean deductBalance(Long userId, double deduct_balance) {
        boolean status = false;
        Wallet wallet = wd.getWalletByUserId(userId);
        double balance = wallet.getBalance() - deduct_balance;
        wallet.setBalance(balance);

        if (wd.update(wallet)) {
            status = true;
        }

        return status;
    }
    
    
    
}
