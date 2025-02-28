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

        uc.username = username;
        uc.password = password;

        if (uc.login_user(uc)) {
            userId = uc.getUserId(uc);
            userType = uc.userType(uc);
            if (userType.equalsIgnoreCase("customer")) {
                Dashboard db = new Dashboard();
                db.userId = userId;
                db.showDashboard();
            } else {
                System.out.println("Invalid Credential");
            }
        }
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
            userId = uc.getUserId(uc);
            wc.userId = userId;
            if (wc.createWallet(wc)) {
                status = true;
            }

        }
        return status;
    }

}
