package views;

import java.util.Scanner;
import controllers.UserController;



public class Index {
    public static void main(String args[]){
        while(true){            
        System.out.println("**************************");
        System.out.println("Welcome To Digital Wallet");
        System.out.println("**************************");
        System.out.println("Choose Operation");
        System.out.println("1. User Login");
        System.out.println("2. User Register");
        System.out.println("3. Exit");

        
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        
        Auth as = new Auth();
        switch(option){
            case 1:
               if(as.login_view()){
                   System.out.println("Logged In");
                   Dashboard db =new Dashboard();
                   db.showDashboard();
               }else{
                   System.out.println("Invalid Credential");
               }
               break;
            case 2:
               if(as.register_view()){
                   System.out.println("Successfully Inserted");
               }
               break;
            case 3:
                System.out.println("Thank for Using our Digital Wallet");
                System.exit(1);
                break;
        }
        }
 
    }
    
}
