/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;
import dao.UserDAO;
import jakarta.persistence.*;
import java.util.List;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nischal
 */
public class UserDaoImpl implements UserDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();

    @Override
    public boolean saveUser(User user) {
        boolean status = false;
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.persist(user);
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
            transaction.commit();
            status=true;
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUserById(int id) {
       return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u from USER u", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.merge(user);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
       EntityTransaction transaction = em.getTransaction();
       try{
           transaction.begin();
           User user = em.find(User.class,id);
           if(user!=null){
               em.remove(user);
           }
           transaction.commit();
       }catch(Exception e){
           transaction.rollback();
           e.printStackTrace();
       }
    }
    
    @Override
    public User getUserByUsername(String username){
        return em.find(User.class, username);
    }
    
    @Override
    public boolean authenticateUser(String username, String password){
        boolean status = false;
         try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username",username);
            User user = query.getSingleResult();

            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                status = true;
            }
        } catch (NoResultException e) {
            status = false;
        }
        
        return status;
    }

    
}
