package controllers;

import dao.UserDAO;
import models.Wallet;
import dao.WalletDAO;
import dao.impl.UserDaoImpl;
import dao.impl.WalletDaoImpl;
import models.User;

public class WalletController {

    WalletDAO wd = new WalletDaoImpl();
    UserDAO ud = new UserDaoImpl();

    public boolean createWallet(Long userId) {
        boolean status = false;
        Wallet wallet = new Wallet();
        wallet.setBalance(0);
        User user = ud.findById(userId);

        wallet.setUser(user);

        if (wd.save(wallet)) {
            status = true;
        }

        return status;
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

    public Long getWalletIdByUserId(Long id) {
        Long walletId = wd.getWalletByUserId(id).getId();
        return walletId;
    }

    public boolean balanceTransfer(Long userId, String contact, double transfer_amount) {
        boolean status = false;
        System.out.println("contact" + contact);
        System.out.println("Balance:" + transfer_amount);
        if (wd.transferBalance(userId, contact, transfer_amount)) {
            status = true;
        }

        return status;
    }

    public boolean deduct_balance(Long userId, double deduct_balance) {
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
