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
public class Dashboard {
    Scanner sc = new Scanner(System.in);
    void showDashboard(){
        System.out.println("******************");
        System.out.println("User Dashboard");
        System.out.println("******************");
        System.out.println("Choose the Operation");
        System.out.println("1. Create Wallet");
        System.out.println("2. Check Balance");
        System.out.println("3. Show lottery Schemes");
        System.out.println("4. Exit");
        int option = sc.nextInt();
        
    }
    
}
