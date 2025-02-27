package models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User extends BaseEntity{
    @Column(name="username", unique=true, nullable=false)
    private String username;
    
    @Column(name="email", unique=true, nullable=false)
    private String email;
    
    @Column(name="password", unique=false, nullable=false)
    private String password;
    
    @Column(name="contact", unique=true, nullable=false)
    private String contact;
    
    @Column(name="fullName", unique=false, nullable=false)
    private String full_name;
    
    @Column(name="user_type", unique=false, nullable=false)
    private String userType;
    
    
    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

      
}
