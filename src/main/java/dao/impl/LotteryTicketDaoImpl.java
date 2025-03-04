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
    public List<Object[]> getTicketByUserId(Long userId) {
        List<Object[]> tickets = null;
        try {
            String jpql = "SELECT w.ticketNumber, w.lottery.lotteryName, w.lottery.drawDate, w.lottery.id, w.lottery.id, w.user.id, w.createdAt "
                    + "FROM LotteryTicket w JOIN w.lottery  WHERE w.user.id = :userId";

            Query query = em.createQuery(jpql);
            query.setParameter("userId", userId);
            tickets = query.getResultList();
            return tickets;

        } catch (Exception e) {

            return tickets;
        }
    }

    @Override
    public List<Object[]> getAllTickets() {
        List<Object[]> tickets = null;
        try {
            String jpql = "SELECT w.ticketNumber, w.user.username, w.lottery.lotteryName, w.lottery.id, w.user.id FROM LotteryTicket w JOIN w.lottery JOIN w.user";

            Query query = em.createQuery(jpql);
            tickets = query.getResultList(); 
            return tickets;
        } catch (Exception e) {

            return tickets;
        }
    }

}
