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
            System.out.println("6. Logout");
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
                                user.getFull_name(),
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
                                transaction.getWalletId(),
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
                                lottery_scheme.getLottery_name(),
                                lottery_scheme.getPrize_amount(),
                                lottery_scheme.getDraw_date(),
                                lottery_scheme.getStatus(),
                                lottery_scheme.getCreatedAt(),
                                lottery_scheme.getTicket_price());
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


                    lc.lotterName = lotteryName;
                    lc.prize_amount = prize_amount;
                    lc.drawDate = draw_date;
                    lc.ticketPrice = ticket_price;

                    if (lc.saveLottery(lc)) {
                        System.out.println("SuccessFully Lottery Added");
                        break;
                    }

                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }

    }
}
