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
import controllers.LotteryTicketController;
import models.LotteryTicket;

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
    LotteryTicketController lt = new LotteryTicketController();

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
            System.out.println("5. Show Purchased Tickets");
            System.out.println("6. Show Transaction Report");
            System.out.println("7. Exit");
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
                    System.out.printf("%-10s %-20s %-15s %-15s %-25s %-25s %-25s%n", "S.N", "Lottery Title", "Prize Amount", "Draw Date", "Status", "CreatedAt", "Ticket Price");
                    System.out.println("**************************************************************************************************************************");
                    int count = 1;
                    for (Lottery lottery_scheme : lottery) {
                        System.out.printf("%-10d %-20s %-15s %-15s %-25s %-25s %-25s%n",
                                count,
                                lottery_scheme.getLottery_name(),
                                lottery_scheme.getPrize_amount(),
                                lottery_scheme.getDraw_date(),
                                lottery_scheme.getStatus(),
                                lottery_scheme.getCreatedAt(),
                                lottery_scheme.getTicket_price());
                        count++;
                    }

                    System.out.println("Choose the Lottery no. you want to buy:");
                    int lottery_number = sc.nextInt();

                    Long lottery_id = lottery.get(lottery_number).getId() - 1;
                    double lottery_price = lottery.get(lottery_number).getTicket_price();

                    Long wallet_id = wc.getWalletIdByUserId(userId);

                    lt.lottery_id = lottery_id;
                    lt.userId = userId;

                    tc.amount = lottery_price;
                    tc.status = "Completed";
                    tc.transactionType = "Buy Lottery Ticket";
                    tc.walletId = wallet_id;

                    if (lt.buyLotteryTicket(lt)) {
                        tc.addTransaction(tc);
                        System.out.println("Successfully ticket Purchased");

                    }

                    break;

                case 5:
                    List<LotteryTicket> lotteryTickets = lt.getTicketsByUserId(userId);
                    System.out.println("********************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %n", "S.N", "Lottery Title", "CreatedAt");
                    System.out.println("********************************************************************************");
                    int count_ticket = 1;
                    for (LotteryTicket ticket : lotteryTickets) {
                        System.out.printf("%-10d %-20s %-15s%n",
                                count_ticket,
                                ticket.getLotteryName(),
                                ticket.getCreatedAt());
                        count_ticket++;
                    }

                    break;

                case 6:
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

}
