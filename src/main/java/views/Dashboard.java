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
import controllers.UserController;
import models.Transaction;
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
    UserController uc = new UserController();
 

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
            System.out.println("7. Update User Information");
            System.out.println("8. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    //Check Use Balance
                    System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                    break;

                case 2:
                    //Load Wallet Balance
                    System.out.println("Enter Amount to Load:");
                    double balance = sc.nextDouble();
                    if (balance < 1) {
                        System.out.println("******************");
                        System.out.println("Load Positive Balance");
                        System.out.println("******************");
                        break;
                    }

                    if (wc.loadBalance(balance,userId)) {
                        Long walletId = wc.getWalletIdByUserId(userId);
                        tc.addTransaction(balance,"Completed","load_balance",walletId);
                        System.out.println("******************");
                        System.out.println("Balance: " + wc.getBalanceByUserId(userId));
                        System.out.println("Successfully Loaded Balance");
                        System.out.println("******************");
                    }

                    break;
                case 3:
                    //Transfer Balance to Another User
                    Long wa_id = wc.getWalletIdByUserId(userId);
                    System.out.println("******************");
                    System.out.println("Enter the Balance you want to transfer:");
                    double transfer_amount = sc.nextDouble();
                    
                    if(wc.getBalanceByUserId(userId)<transfer_amount){
                        System.out.println("You donot have Enough Balance");
                        break;
                    }

                    sc.nextLine();
                    System.out.println("Enter the contact number you want to transfer balance to:");
                    String contact_no = sc.nextLine();
                    
                    if(!wc.getWalletByContact(contact_no)){
                        System.out.println("Invalid Contact No");
                        break;
                    }
                    

                    if (wc.balanceTransfer(userId, contact_no, transfer_amount)) {

                        tc.addTransaction(transfer_amount,"Completed","Balance_transf",wa_id);

                        System.out.println("Successfully Transfered balance");
                        break;
                    }else{
                        System.out.println("Invalid User Contact no");
                        break;
                    }
                    

                case 4:
                    //Buy Lottery Tickets
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
                                lottery_scheme.getLotteryName(),
                                lottery_scheme.getPrizeAmount(),
                                lottery_scheme.getDrawDate(),
                                lottery_scheme.getStatus(),
                                lottery_scheme.getCreatedAt(),
                                lottery_scheme.getTicketPrice());
                        count++;
                    }

                    System.out.println("Choose the Lottery no. you want to buy:");
                    int lottery_number = sc.nextInt();

                    Long lottery_id = lottery.get(lottery_number-1).getId();
                    double lottery_price = lottery.get(lottery_number-1).getTicketPrice();
                    
                     if(wc.getBalanceByUserId(userId)<lottery_price){
                        System.out.println("You donot have Enough Balance");
                        break;
                    }

                    Long wallet_id = wc.getWalletIdByUserId(userId);
                    
                    if (lt.buyLotteryTicket(userId,lottery_id)) {
                        tc.addTransaction(lottery_price,"Completed","Buy Lottery Ticket",wallet_id);
                        if (wc.deductBalance(userId, lottery_price)) {
                            System.out.println("Successfully ticket Purchased");
                        } else {
                            System.out.println("Balance Not Deducted");
                        }

                    }

                    break;

                case 5:
                    //Show the purchased Lottery Tickets
                    List<Object[]> lotteryTickets = lt.getTicketsByUserId(userId);
                    System.out.println("********************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %n", "S.N", "Lottery Title", "Draw Date");
                    System.out.println("********************************************************************************");
                    int count_ticket = 1;
                    for (Object[] ticket : lotteryTickets) {
                        System.out.printf("%-10d %-20s %-15s%n",
                                count_ticket,
                                ticket[1].toString(),
                                ticket[2]);
                        count_ticket++;
                    }

                    break;

                case 6:
                    //show the transaction report
                    Long w_id = wc.getWalletIdByUserId(userId);
                    List<Transaction> transactions = tc.getTransactionByWalletId(w_id);

                    System.out.println("*********************");
                    System.out.println("Transaction Report");
                    System.out.println("*********************");

                    System.out.println("*********************************************************************************************************");
                    System.out.printf("%-10s %-20s %-15s %-25s %-10s%n", "TransactionID", "Transaction Type", "Amount", "Status", "Time Stamp");
                    System.out.println("*********************************************************************************************************");
                    for (Transaction transaction : transactions) {
                        System.out.printf("%-10d %-20s %-15s %-25s %-10s%n",
                                transaction.getId(),
                                transaction.getTransactionType(),
                                transaction.getAmount(),
                                transaction.getStatus(),
                                transaction.getTimeStamp());
                    }

                    break;
                case 7:
                    //Update User Information
                    sc.nextLine();
                    System.out.println("Enter Contact No:");
                    String contact = sc.nextLine();
                    System.out.println("Enter your email:");
                    String email = sc.nextLine();
                    System.out.println("Enter Full Name:");
                    String fullName = sc.nextLine();
                    System.out.println("Enter Username:");
                    String username = sc.nextLine();
                    
                    if(contact.isEmpty()){
                        System.out.println("Please Enter  contact field is empty");
                        break;
                    }
                    if(email.isEmpty()){
                        System.out.println("Please Enter  email field is empty");
                        break;
                    }
                    if(fullName.isEmpty()){
                        System.out.println("Please Enter  full name field is empty");
                        break;
                    }
                    if(username.isEmpty()){
                        System.out.println("Please Enter  usernmae field is empty");
                        break;
                    }
                    
                    if(uc.updateUser(contact, email, fullName, username, userId)){
                        System.out.println("User has been updated Successfully");
                        break;
                    }
                    
                case 8:
                    System.exit(0);
            }
        }
    }

}
