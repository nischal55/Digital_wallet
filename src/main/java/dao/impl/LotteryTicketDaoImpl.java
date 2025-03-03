/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.LotteryTicketDAO;
import jakarta.persistence.*;
import models.LotteryTicket;
import java.util.List;

/**
 *
 * @author nischal
 */
public class LotteryTicketDaoImpl extends BaseDaoImpl<LotteryTicket, Long> implements LotteryTicketDAO {

    public LotteryTicketDaoImpl() {
        super(LotteryTicket.class);
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

    @Override
    public int getLatestLotteryTicket() {
        int ticketNumber = 0;
        try {
            TypedQuery<Integer> query = em.createQuery(
                    "SELECT w.ticket_number FROM LotteryTicket w  ORDER BY w.id DESC ",
                    Integer.class
            );
            query.setMaxResults(1);  
            ticketNumber = query.getSingleResult();

        } catch (Exception e) {

            return ticketNumber;
        }
        
        return ticketNumber;
    }
    
    @Override
    public List<Object[]> getTicketByUserId(Long userId){
        List<Object[]> tickets = null;
        try {
            String sql = "SELECT w.ticket_number,u.lottery_name,u.draw_date,w.lottery_id,u.id, w.userId, w.createdAt FROM lottery_ticket w JOIN lottery u ON w.lottery_id = u.id WHERE w.userId = ?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, userId);
            tickets = query.getResultList();
            return tickets;

        } catch (Exception e) {

            return tickets;
        }
    }
    
    @Override
    public List<Object[]> getAllTickets(){
        List<Object[]> tickets = null;
        try {
            String sql = "SELECT w.ticket_number,users.username,u.lottery_name,w.lottery_id,u.id, w.userId,users.id FROM lottery_ticket w JOIN lottery u ON w.lottery_id = u.id  join users on w.userId = users.id";
            Query query = em.createNativeQuery(sql);
            tickets = query.getResultList();
            return tickets;

        } catch (Exception e) {

            return tickets;
        }
    }

}
