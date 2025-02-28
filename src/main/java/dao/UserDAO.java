/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.User;

public interface UserDAO {
    boolean saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    boolean updateUser(User user);
    boolean deleteUser(Long id); 
    User getUserByUsername(String username);
    boolean authenticateUser(String username,String password);
    String getUserType(String username);
}
