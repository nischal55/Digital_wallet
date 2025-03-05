package views;

import controllers.UserController;
import java.util.Scanner;
import controllers.WalletController;

public class Auth {

    public String userType;
    public Long userId;
    UserController uc = new UserController();
    WalletController wc = new WalletController();
    Scanner sc = new Scanner(System.in);

    public void login_view() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        boolean status = false;

        if (username == null) {
            status = false;
        }
        if (password == null) {
            status = false;
        }

        if (uc.login_user(username,password)) {
            userId = uc.getUserId(username);
            userType = uc.userType(username);
            if (userType.equalsIgnoreCase("customer")) {
                Dashboard db = new Dashboard();
                db.userId = userId;
                db.showDashboard();
            } else if(userType.equalsIgnoreCase("admin")){
                AdminDashboard ad = new AdminDashboard();
                ad.userId = userId;
                ad.showDashboard();
               
            }else{
                System.out.println("Invalid Credentials");
            }
        }else{
            System.out.println("Invalid Credentials");
        }
    }

    public boolean register_view() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter full name:");
        String fullName = sc.nextLine();
        System.out.println("Enter Contact Number:");
        String contact = sc.nextLine();
        String userType = "customer";
        System.out.println("Enter password:");
        String password = sc.nextLine();
        boolean status = false;

        if (uc.register_user(username,email,contact,fullName,userType,password)) {
            userId = uc.getUserId(username);
            if (wc.createWallet(userId)) {
                status = true;
            }

        }
        return status;
    }

}
