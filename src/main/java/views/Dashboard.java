/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.WalletController;
import java.util.Scanner;

/**
 *
 * @author nischal
 */
public class Dashboard {

    public Long userId;
    Scanner sc = new Scanner(System.in);
    WalletController wc = new WalletController();

    void showDashboard() {
        while (true) {
            System.out.println("******************");
            System.out.println("User Dashboard");
            System.out.println("******************");
            System.out.println("Choose the Operation");
            System.out.println("1. Check Balance");
            System.out.println("2. Load Balance");
            System.out.println("3. Transfer Balance");
            System.out.println("4. Show lottery Schemes");
            System.out.println("5. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    wc.userId = userId;
                    System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                    break;
                case 3:
                    break;
            }
        }
    }

}
