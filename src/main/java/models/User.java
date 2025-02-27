package models;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String contact;
    private String full_name;

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
   
    
}
