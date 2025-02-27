package data;

import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserData {
    private List<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    // Get all users from the list
    public List<User> getAllUsers() {
        return users;
    }

    // Get a user by userId (Primary Key)
    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;  
    }

    // Remove a user by userId
    public boolean removeUserById(int userId) {
        return users.removeIf(user -> user.getUserId() == userId);
    }

    // Display all users
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getUsername());
        }
    }
}
