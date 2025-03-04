/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.LotteryTicketDAO;
import jakarta.persistence.*;
import models.LotteryTicket;
import java.util.List;
import java.util.Random;
import models.Lottery;

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
                    "SELECT w.ticketNumber FROM LotteryTicket w  ORDER BY w.id DESC ",
                    Integer.class
            );
            query.setMaxResults(1);
            ticketNumber = query.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            return tickets;
        }
    }

    @Override
    public int findLotteryResult(Long lotteryId) {

        String jpql = "SELECT w.ticketNumber from LotteryTicket w where w.lottery.id = : lotteryId";
        Query query = em.createQuery(jpql);
        query.setParameter("lotteryId", lotteryId);
        List<Integer> tickets = query.getResultList();

        int result = 0;
        try {
            
            Random rand = new Random();

            int randomIndex = rand.nextInt(tickets.size());

            int randomNumber = tickets.get(randomIndex);
            result = randomNumber;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long findUserIdByTicketNumber(int ticketNumber) {
        Long userId = null;
        TypedQuery<Long> query = em.createQuery(
                    "SELECT w.user.id FROM LotteryTicket w where ticketNumber=:ticketNumber",
                    Long.class
            );
        query.setParameter("ticketNumber", ticketNumber);
        userId = query.getSingleResult();
        
        return userId;
    }
    
    @Override
     public Lottery findLotteryByTicket(int ticketNumber){
         Lottery lottery = null;
         TypedQuery<Lottery> query = em.createQuery(
                    "SELECT w.lottery FROM LotteryTicket w where ticketNumber=:ticketNumber",
                    Lottery.class
            );
         query.setParameter("ticketNumber", ticketNumber);
        lottery = query.getSingleResult();
        return lottery;
     }
   
}
