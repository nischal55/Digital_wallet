/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;


import dao.LotteryDAO;
import models.Lottery;
/**
 *
 * @author nischal
 */
public class LotteryDaoImpl extends BaseDaoImpl<Lottery, Long> implements LotteryDAO{
    
    public LotteryDaoImpl(){
        super(Lottery.class);
    }
    
}
