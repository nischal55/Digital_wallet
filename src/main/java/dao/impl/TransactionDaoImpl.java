/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.TransactionDAO;
import models.Transaction;

/**
 *
 * @author nischal
 */
public class TransactionDaoImpl extends BaseDaoImpl<Transaction, Long> implements TransactionDAO{

    public TransactionDaoImpl(){
        super(Transaction.class);
    }
    
}
