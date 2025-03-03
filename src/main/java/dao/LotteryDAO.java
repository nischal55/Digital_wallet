/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Lottery;

/**
 *
 * @author nischal
 */
public interface LotteryDAO {
    boolean save(Lottery lottery);
    boolean update(Lottery lottery);
    boolean deleteById(Long id);  
    Lottery findById(Long id);
    List<Lottery> findAll();
}
