/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.WalletDAO;
import jakarta.persistence.*;
import jakarta.persistence.Persistence;
import models.Wallet;

public class WalletDaoImpl extends BaseDaoImpl<Wallet, Long> implements WalletDAO {

    public WalletDaoImpl() {
        super(Wallet.class);
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Wallet getWalletByUserId(Long id) {
        Wallet wallet = null;
        try {
            TypedQuery<Wallet> query = em.createQuery("SELECT u FROM Wallet u WHERE u.userId = :userId", Wallet.class);
            query.setParameter("userId", id);
            wallet = query.getSingleResult();
            return wallet;

        } catch (Exception e) {

            return wallet;
        }
    }

    @Override
    public boolean transferBalance(Long userId, String contact, double transfer_amount) {
        boolean status = false;
        String sql = "SELECT w.* FROM wallets w JOIN users u ON w.userId = u.id WHERE u.contact = ?";
        Query query = em.createNativeQuery(sql, Wallet.class);
        query.setParameter(1, contact);
        Wallet wallet_receiver = (Wallet) query.getSingleResult();
        double receiver_new_balance = wallet_receiver.getBalance() + transfer_amount;
        wallet_receiver.setBalance(receiver_new_balance);

        Wallet wallet_sender = getWalletByUserId(userId);
        double sender_new_balance = wallet_sender.getBalance() - transfer_amount;
        wallet_sender.setBalance(sender_new_balance);

        if (update(wallet_receiver)) {
            if (update(wallet_sender)) {
                status = true;
            }
        }

        return status;
    }
}
