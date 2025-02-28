/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.User;

public interface UserDAO {
    boolean saveUser(User user);
    User findById(Long id);
    List<User> findAll();
    boolean update(User user);
    boolean deleteById(Long id); 
    User getUserByUsername(String username);
    boolean authenticateUser(String username,String password);
    String getUserType(String username);
    Long getUserId(String username);
}
