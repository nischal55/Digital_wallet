package controllers;

import Service.java.WalletService;
import dao.UserDAO;
import models.Wallet;
import dao.WalletDAO;
import dao.impl.UserDaoImpl;
import dao.impl.WalletDaoImpl;
import models.User;

public class WalletController {

    WalletDAO wd = new WalletDaoImpl();
    UserDAO ud = new UserDaoImpl();
    WalletService service = new WalletService(wd, ud);

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
        return service.getBalanceByUserId(id);
    }

    public boolean loadBalance(double balance, Long userId) {
        return service.loadBalance(balance, userId);
    }

    public Long getWalletIdByUserId(Long id) {
        Long walletId = wd.getWalletByUserId(id).getId();
        return walletId;
    }

    public boolean balanceTransfer(Long userId, String contact, double transferAmount) {
        return service.balanceTransfer(userId, contact, transferAmount);
    }

    public boolean deductBalance(Long userId, double deductBalance) {
        return service.deductBalance(userId, deductBalance);
    }

    public boolean getWalletByContact(String contact) {
        boolean status = false;

        try {

            Wallet wallet = wd.getWalletByContact(contact);

            if (wallet != null && wallet.getId() > 0) {
                status = true;
            }

        }catch(Exception e){
            status = false;
        }

        return status;
    }
}
