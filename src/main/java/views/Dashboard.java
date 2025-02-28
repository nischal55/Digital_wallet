/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.TransactionController;
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
    TransactionController tc = new TransactionController();

    void showDashboard() {
        while (true) {
            System.out.println("User id: "+userId);
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
                    System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                    break;

                case 2:
                    System.out.println("Enter Amount to Load:");
                    double balance = sc.nextDouble();
                    if(balance<1){
                        System.out.println("******************");
                        System.out.println("Load Positive Balance");
                        System.out.println("******************");
                        break;
                    }
                    wc.balance = balance;
                    wc.userId = userId;
                    if (wc.loadBalance(wc)) {
                        Long walletId = wc.getWalletIdByUserId(userId);
                        tc.amount = balance;
                        tc.status = "Completed";
                        tc.transactionType="load_balance";
                        tc.walletId = walletId;
                        tc.addTransaction(tc);
                        System.out.println("******************");
                        System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                        System.out.println("Successfully Loaded Balance");
                        System.out.println("******************");
                    }

                    break;
                case 3:
                     Long walletId = wc.getWalletIdByUserId(userId);
                     System.out.println("walletID" + walletId);
                    break;

                case 4:
                    System.out.println("case2");
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

}
