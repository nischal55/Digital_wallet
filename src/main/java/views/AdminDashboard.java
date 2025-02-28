/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;

/**
 *
 * @author nischal
 */
public class AdminDashboard {

    Scanner sc = new Scanner(System.in);

    void showDashboard() {
        System.out.println("******************");
        System.out.println("Admin Dashboard");
        System.out.println("******************");
        System.out.println("Choose the Operation");
        System.out.println("1. Create Wallet");
        System.out.println("2. Check Balance");
        System.out.println("3. Show lottery Schemes");
        System.out.println("4. Logout");
        int option = sc.nextInt();
        
        switch(option){
            case 1:
                System.out.println("Balacne");
                break;
            case 2:
                System.out.println("Balacne");
                break;
            case 3:
                System.out.println("Balacne");
                break;
            case 4:
               break;
        }
    }
}
