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
    
    private WalletDAO wd;
    private UserDAO ud;
    
    public WalletService(WalletDAO wd, UserDAO ud) {
        this.wd = wd;
        this.ud = ud;
    }
     
    
    
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
        Wallet wallet_receiver = wd.getWalletByContact(contact);
        double receiver_new_balance = wallet_receiver.getBalance() + transferAmount;
        wallet_receiver.setBalance(receiver_new_balance);

        Wallet wallet_sender = wd.getWalletByUserId(userId);
        double sender_new_balance = wallet_sender.getBalance() - transferAmount;
        wallet_sender.setBalance(sender_new_balance);

        if (wd.update(wallet_receiver)) {
            if (wd.update(wallet_sender)) {
                status = true;
            }
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
