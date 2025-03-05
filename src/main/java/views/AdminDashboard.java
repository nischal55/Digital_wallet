/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.LotteryController;
import controllers.TransactionController;
import controllers.UserController;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import models.User;
import models.Transaction;
import models.Lottery;
import controllers.LotteryTicketController;
import controllers.WalletController;

/**
 *
 * @author nischal
 */
public class AdminDashboard {

    public Long userId;
    Scanner sc = new Scanner(System.in);
    UserController uc = new UserController();
    TransactionController tc = new TransactionController();
    LotteryController lc = new LotteryController();
    LotteryTicketController lt = new LotteryTicketController();
    WalletController wc = new WalletController();

    void showDashboard() {
        while (true) {
            System.out.println("******************");
            System.out.println("Admin Dashboard");
            System.out.println("******************");
            System.out.println("Choose the Operation");
            System.out.println("1. Check Users Report");
            System.out.println("2. Check Transaction Report");
            System.out.println("3. Show lottery Schemes");
            System.out.println("4. Add lottery Schemes");
            System.out.println("5. Show lottery Applicants");
            System.out.println("6. Generate lottery Result");
            System.out.println("7. Logout");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    List<User> users = uc.getAllUsers();
                    System.out.println("*********************");
                    System.out.println("List of Users");
                    System.out.println("*********************");

                    System.out.println("*********************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-15s %-10s %-25s%n", "UserId", "Full Name", "Username", "Contact", "Email", "User Type");
                    System.out.println("*********************************************************************************************************");

                    for (User user : users) {
                        System.out.printf("%-10d %-20s %-15s %-15s %-10s %-25s%n",
                                user.getId(),
                                user.getFullName(),
                                user.getUsername(),
                                user.getContact(),
                                user.getEmail(),
                                user.getUserType());
                    }
                    break;
                case 2:
                    List<Transaction> transactions = tc.getAllTransaction();
                    System.out.println("*********************");
                    System.out.println("Transaction Report");
                    System.out.println("*********************");

                    System.out.println("*********************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-15s %-25s %-10s%n", "TransactionID", "Transaction Type", "Amount", "Status", "WalletId", "Time Stamp");
                    System.out.println("*********************************************************************************************************");
                    for (Transaction transaction : transactions) {
                        System.out.printf("%-10d %-20s %-15s %-15s %-25s %-10s%n",
                                transaction.getId(),
                                transaction.getTransactionType(),
                                transaction.getAmount(),
                                transaction.getStatus(),
                                transaction.getWallet().getId(),
                                transaction.getTimeStamp());
                    }
                    break;
                case 3:
                    List<Lottery> lottery = lc.getAllLottery();
                    System.out.println("*********************");
                    System.out.println("List of Users");
                    System.out.println("*********************");

                    System.out.println("**************************************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-15s %-25s %-25s %-25s%n", "lottery_id", "Lottery Title", "Prize Amount", "Draw Date", "Status", "CreatedAt", "Ticket Price");
                    System.out.println("**************************************************************************************************************************");

                    for (Lottery lottery_scheme : lottery) {
                        System.out.printf("%-10d %-20s %-15s %-15s %-25s %-25s %-25s%n",
                                lottery_scheme.getId(),
                                lottery_scheme.getLotteryName(),
                                lottery_scheme.getPrizeAmount(),
                                lottery_scheme.getDrawDate(),
                                lottery_scheme.getStatus(),
                                lottery_scheme.getCreatedAt(),
                                lottery_scheme.getTicketPrice());
                    }
                    break;
                case 4:
                    System.out.println("*********************");
                    System.out.println("Add Lottery Scheme");
                    System.out.println("*********************");
                    System.out.println("Enter Prize Amount:");
                    double prize_amount = sc.nextDouble();

                    sc.nextLine();

                    System.out.println("Enter the lottery Name:");
                    String lotteryName = sc.nextLine().trim();

                    System.out.println("Enter the draw date Format YYYY-MM-DD");
                    String inputDate = sc.nextLine().trim();
                    System.out.println(inputDate);
                    LocalDate draw_date = LocalDate.parse(inputDate);

                    System.out.println("Enter Ticket Price");
                    double ticket_price = sc.nextDouble();

                    sc.nextLine();

                    if (lc.saveLottery(lotteryName, prize_amount, draw_date, ticket_price)) {
                        System.out.println("SuccessFully Lottery Added");
                        break;
                    }

                    break;
                case 5:

                    System.out.println("**************************************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-25s%n", "S.N", "Username", "Lottery Title", "Ticket Number");
                    System.out.println("**************************************************************************************************************************");

                    List<Object[]> lotteryTickets = lt.getAllTickets();
                    int count_ticket = 1;
                    for (Object[] lotteryTicket : lotteryTickets) {
                        System.out.printf("%-10d %-20s %-15s %-10s%n",
                                count_ticket,
                                lotteryTicket[1],
                                lotteryTicket[2],
                                lotteryTicket[0]);
                    }
                    break;
                case 6:
                    List<Lottery> lottery_list = lc.getAllLottery();
                    System.out.println("*********************");
                    System.out.println("Choose Lottery Scheme");
                    System.out.println("*********************");

                    System.out.println("**************************************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-15s %-25s %-25s %-25s%n", "S.N", "Lottery Title", "Prize Amount", "Draw Date", "Status", "CreatedAt", "Ticket Price");
                    System.out.println("**************************************************************************************************************************");
                    int count = 1;
                    for (Lottery lottery_scheme : lottery_list) {
                        if (lottery_scheme.getStatus().equalsIgnoreCase("Opened")) {
                            System.out.printf("%-10d %-20s %-15s %-15s %-25s %-25s %-25s%n",
                                    count,
                                    lottery_scheme.getLotteryName(),
                                    lottery_scheme.getPrizeAmount(),
                                    lottery_scheme.getDrawDate(),
                                    lottery_scheme.getStatus(),
                                    lottery_scheme.getCreatedAt(),
                                    lottery_scheme.getTicketPrice());
                            count++;
                        }

                    }

                    System.out.println("Enter the Lottery No. you want to generate result for:");
                    int lottery_number = sc.nextInt();

                    Long lottery_id = lottery_list.get(lottery_number - 1).getId();

                    int result = lt.findLotteryResult(lottery_id);

                    System.out.println("Winner Ticket Number:" + result);
                    Long winner_user_id = lt.findUserIdByTicketNumber(result);

                    System.out.println("Winner UserId: " + winner_user_id);

                    User user = uc.getUserById(winner_user_id);

                    System.out.println("Winner Name: " + user.getFullName());
                    System.out.println("Winner Contact: " + user.getContact());
                    System.out.println("Winner Email: " + user.getEmail());

                    Lottery lottery_scheme = lt.findLotteryByTicket(lottery_number);
                    double winning_prize = lottery_scheme.getPrizeAmount();

                    System.out.println("Are you sure to load prize to the winner:");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int confirmation = sc.nextInt();

                    if (confirmation == 1) {
                        if (wc.loadBalance(winning_prize, winner_user_id)) {
                            Long walletId = wc.getWalletIdByUserId(winner_user_id);
                            tc.addTransaction(winning_prize, "Completed", "Winning Prize Transfer", walletId);
                            lc.changeTicketStatus(lottery_scheme);
                            System.out.println("Transfered Balance to winner");
                            break;
                        }
                    } else {
                        break;
                    }

                case 7:
                    System.exit(0);
                    break;
            }
        }

    }
}
