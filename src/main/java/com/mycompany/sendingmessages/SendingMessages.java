/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sendingmessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Part 2- Sending Messages
 * @author Student
 */
public class SendingMessages {
    
    private static List <Message> sentMessages = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Welcome to QuickChat.");
            
            // Step 1: The user should only be able to send messages if they have logged in successfully
            boolean isLoggedIn;
            isLoggedIn = login(input);
            
            if(!isLoggedIn){
                System.out.println("Login failed. Exiting.");
                input.close();
                return;
            }
            System.out.println("Login successful! You can now send messages.");
            
            //==================MAIN MENU====================
            while (true){
                displayMenu();
                int choice = getValidInt(input);
                
               if (choice ==1){
                    System.out.println("\n[Send Messages feature will be implemented next]");
               }
               else if(choice ==2){
                   System.out.println("\nComing soon.");
               }
               else if(choice ==3){
                   System.out.println("\nThank you for using QuickChat. Goodbye!");
                   break;
               }else{
                   System.out.println("Invalid option. Please try again.");
               }
            }
            input.close();
        }
    }
        // LOGIN METHOD
        private static boolean login (Scanner input){
            System.out.println("Enter your username:");
            String username = input.nextLine();
            
            System.out.println("Enter your password:");
            String password = input.nextLine();
            
            return !username.trim().isEmpty() && !password.trim().isEmpty();
            }
        // Display numeric menu
        private static void displayMenu(){
                System.out.println("\n====QuickChat Main Menu====");
                System.out.println("Option 1). Send Messages"); //3a
                System.out.println("Option 2). Show recently sent messages");//3b
                System.out.println("Option 3) Quit");
                System.out.println("Enter your choice:");
        }
        
        private static int getValidInt(Scanner input){
            while(!input.hasNextInt()){
                System.out.println("Invalid input. Enter a number:");
                input.next();
            }
            int num = input.nextInt();
            input.nextLine(); // Consume newLine
            return num;
        }
            
}
