/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;
import dao.UserDAO;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nischal
 */
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("digital_wallet");
    private EntityManager em = emf.createEntityManager();
    
    
    public UserDaoImpl(){
        super(User.class);
    }

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
    public User getUserById(Long id) {
       return findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return findAll();
    }

    @Override
    public boolean updateUser(User user) {
       return update(user);
    }

    @Override
    public boolean deleteUser(Long id) {
      return deleteById(id);
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

    @Override
    public String getUserType(String username){
        String userType;
        try{
           TypedQuery<User> query = em.createQuery("SELECT u.userType FROM User u WHERE u.username = :username", User.class);
            query.setParameter("username",username);
            User user = query.getSingleResult();
            userType = user.getUserType();
        }catch(Exception e){
            userType = null;
        }    
        return userType;
    }
    
}
