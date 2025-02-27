/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import dao.UserDAO;
import dao.impl.UserDaoImpl;
import models.User;

/**
 *
 * @author nischal
 */
public class UserController{
    public String email;
    public String contact;
    public String fullName;
    public String userType;
    public String username;
    public String password;
    private static UserDAO userDAO = new UserDaoImpl();
    
    public boolean register_user(UserController uc){
        User user = new User();
        user.setUsername(uc.username);
        user.setEmail(uc.email);
        user.setContact(uc.contact);
        user.setFull_name(uc.fullName);
        user.setUserType(uc.userType);
        user.setPassword(uc.password);
        boolean status = false;
        
        //saving user through DAO
        if(userDAO.saveUser(user)){
            status=true;
        }
        
        return status;
    }
    
    public boolean login_user(UserController uc){
       boolean status = false;
       if(userDAO.authenticateUser(uc.username, uc.password)){
           status = true;
       }
       return status;
    }
}
