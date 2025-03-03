/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.TransactionController;
import controllers.WalletController;
import java.util.List;
import java.util.Scanner;
import models.Lottery;
import controllers.LotteryController;

/**
 *
 * @author nischal
 */
public class Dashboard {

    public Long userId;
    Scanner sc = new Scanner(System.in);
    WalletController wc = new WalletController();
    TransactionController tc = new TransactionController();
    LotteryController lc = new LotteryController();

    void showDashboard() {
        while (true) {
            System.out.println("User id: " + userId);
            System.out.println("******************");
            System.out.println("User Dashboard");
            System.out.println("******************");
            System.out.println("Choose the Operation");
            System.out.println("1. Check Balance");
            System.out.println("2. Load Balance");
            System.out.println("3. Transfer Balance");
            System.out.println("4. Buy lottery Schemes");
            System.out.println("5. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                    break;

                case 2:
                    System.out.println("Enter Amount to Load:");
                    double balance = sc.nextDouble();
                    if (balance < 1) {
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
                        tc.transactionType = "load_balance";
                        tc.walletId = walletId;
                        tc.addTransaction(tc);
                        System.out.println("******************");
                        System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                        System.out.println("Successfully Loaded Balance");
                        System.out.println("******************");
                    }

                    break;
                case 3:
                    System.out.println("******************");
                    System.out.println("Enter the Balance you want to transfer:");
                    double transfer_amount = sc.nextDouble();

                    sc.nextLine();
                    System.out.println("Enter the contact number you want to transfer balance to:");
                    String contact_no = sc.nextLine();

                    if (wc.balanceTransfer(userId, contact_no, transfer_amount)) {
                        System.out.println("Successfully Transfered balance");
                        break;
                    }
                    break;

                case 4:
                    List<Lottery> lottery = lc.getAllLottery();
                    System.out.println("*********************");
                    System.out.println("List of Users");
                    System.out.println("*********************");

                    System.out.println("**************************************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-15s %-25s %-25s %-25s%n", "lottery_No", "Lottery Title", "Prize Amount", "Draw Date", "Status", "CreatedAt", "Ticket Price");
                    System.out.println("**************************************************************************************************************************");

                    for (Lottery lottery_scheme : lottery) {
                        System.out.printf("%-10d %-20s %-15s %-15s %-25s %-25s %-25s%n",
                                lottery_scheme.getId(),
                                lottery_scheme.getLottery_name(),
                                lottery_scheme.getPrize_amount(),
                                lottery_scheme.getDraw_date(),
                                lottery_scheme.getStatus(),
                                lottery_scheme.getCreatedAt(),
                                lottery_scheme.getTicket_price());
                    }

                    System.out.println("Enter the Lottery Number You Want to Buy:");
                    int lottery_number = sc.nextInt();
                    
                    

                    break;

                case 5:
                    System.exit(0);
            }
        }
    }

}
