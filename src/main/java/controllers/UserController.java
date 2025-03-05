package controllers;

import dao.UserDAO;
import dao.impl.UserDaoImpl;
import java.util.List;
import models.User;

/**
 *
 * @author nischal
 */
public class UserController{
    private static UserDAO userDAO = new UserDaoImpl();
    
    public boolean register_user(String username,String email,String contact, String fullName,String userType,String password){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setContact(contact);
        user.setFullName(fullName);
        user.setUserType(userType);
        user.setPassword(password);
        boolean status = false;
        
        //saving user through DAO
        if(userDAO.saveUser(user)){
            status=true;
        }
        
        return status;
    }
    
    public boolean login_user(String username, String password){
       boolean status = false;
       if(userDAO.authenticateUser(username, password)){
           status = true;
           
       }
       return status;
    }
    
    public String userType(String username){
        String userType = userDAO.getUserType(username);
        return userType;
    }
    
    public Long getUserId(String username){
        Long userId = userDAO.getUserId(username);
        return userId;
    }
    
    public List<User> getAllUsers(){
        List<User> users = userDAO.findAll();
        return users;
    }
    
    public User getUserById(Long userId){
        User user = userDAO.findById(userId);
        return user;
    }
    
    public boolean updateUser(String contact,String email,String fullName,String username, Long userId ){
        boolean status = false;
        User user = getUserById(userId);
        user.setContact(contact);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setUsername(username);
        
        if(userDAO.update(user)){
            status = true;
        }
        
        return status;
    }
}
