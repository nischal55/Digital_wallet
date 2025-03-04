/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.UserDAO;
import jakarta.persistence.*;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nischal
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private final EntityManager em = emf.createEntityManager();

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public boolean saveUser(User user) {
        boolean status = false;
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
            transaction.commit();
            status = true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUserByUsername(String username) {
        return em.find(User.class, username);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        boolean status = false;
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username", username);
            User user = query.getSingleResult();

            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                status = true;
            }
        } catch (NoResultException e) {
            status = false;
        }

        return status;
    }

    @Override

    public String getUserType(String username) {
        String userType = null; // Default to null
        try {
            TypedQuery<String> query = em.createQuery("SELECT u.userType FROM User u WHERE u.username = :username", String.class);
            query.setParameter("username", username);
            userType = query.getSingleResult();  // Returns the userType as String
        } catch (NoResultException e) {
            System.out.println("No user found with the given username.");
        } catch (NonUniqueResultException e) {
            System.out.println("Multiple users found with the same username.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return userType;
    }
    
    @Override
    public Long getUserId(String username){
        Long userId = null;
         try {
            TypedQuery<Long> query = em.createQuery("SELECT u.id FROM User u WHERE u.username = :username", Long.class);
            query.setParameter("username", username);
            userId = query.getSingleResult(); 
        } catch (NoResultException e) {
            System.out.println("No user found with the given username.");
        } catch (NonUniqueResultException e) {
            System.out.println("Multiple users found with the same username.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return userId;
    }

}
