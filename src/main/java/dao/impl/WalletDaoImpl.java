/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.WalletDAO;
import jakarta.persistence.*;
import jakarta.persistence.Persistence;
import models.Wallet;

public class WalletDaoImpl extends BaseDaoImpl<Wallet, Long> implements WalletDAO{
    
    public WalletDaoImpl(){
        super(Wallet.class);
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

   
    @Override
    public Wallet getWalletByUserId(Long id) {
        Wallet wallet=null;
        try {
            TypedQuery<Wallet> query = em.createQuery("SELECT u FROM Wallet u WHERE u.userId = :userId", Wallet.class);
            query.setParameter("userId", id);
            wallet = query.getSingleResult(); 
            return wallet;
            
        }catch(Exception e){
            
        return wallet;
        }
    }
}
