/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.UserController;
import java.util.Scanner;

/**
 *
 * @author nischal
 */
public class Auth {

    UserController uc = new UserController();
    Scanner sc = new Scanner(System.in);

    public boolean login_view() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        boolean status = false;
        
        if(username==null){
            status = false;
        }
        if(password==null){
            status=false;
        }

        uc.username = username;
        uc.password = password;

        if (uc.login_user(uc)) {
            status = true;
        }
        return status;
    }

    public boolean register_view() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter full name:");
        String full_name = sc.nextLine();
        System.out.println("Enter Contact Number:");
        String contact = sc.nextLine();
        String userType = "customer";
        System.out.println("Enter password:");
        String password = sc.nextLine();
        boolean status = false;

        uc.username = username;
        uc.email = email;
        uc.contact = contact;
        uc.fullName = full_name;
        uc.userType = userType;
        uc.password = password;
        if (uc.register_user(uc)) {
            status = true;
        }
        return status;
    }

}
