/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.WalletDAO;
import jakarta.persistence.*;
import jakarta.persistence.Persistence;
import models.Wallet;

public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDAO {

    public WalletDaoImpl() {
        super(Wallet.class);
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Wallet getWalletByUserId(Long id) {
        Wallet wallet = null;
       
        try {
            TypedQuery<Wallet> query = em.createQuery("SELECT u FROM Wallet u WHERE u.user.id = :userId", Wallet.class);
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
        String jpql = "SELECT w FROM Wallet w JOIN w.user u WHERE u.contact = :contact";
        TypedQuery<Wallet> query = em.createQuery(jpql, Wallet.class);
        query.setParameter("contact", contact);
        Wallet wallet_receiver = query.getSingleResult();
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
