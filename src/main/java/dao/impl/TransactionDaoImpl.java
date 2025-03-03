/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.TransactionDAO;
import jakarta.persistence.*;
import models.Transaction;
import java.util.List;

/**
 *
 * @author nischal
 */
public class TransactionDaoImpl extends BaseDaoImpl<Transaction, Long> implements TransactionDAO{

    public TransactionDaoImpl(){
        super(Transaction.class);
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();
    
    
    @Override
    public List<Transaction> getTransactionByWalletId(Long walletId){
        List<Transaction> transactions = null;
         TypedQuery<Transaction> query = em.createQuery("SELECT u FROM Transaction u WHERE u.walletId = :walletId", Transaction.class);
            query.setParameter("walletId",walletId);
            transactions = query.getResultList();
            return transactions;
    }
        
}
