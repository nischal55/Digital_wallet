package models;

public class Admin {
    private int admin_id;
    private String username;
    private String full_name;
    private String contact;
    private String email;
    private String password;

    public int getAdmin_id() {
        return admin_id;
    }

    public String getUsername() {
        return username;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
