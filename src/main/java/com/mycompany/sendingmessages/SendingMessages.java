/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sendingmessages;

import java.util.Scanner;

/**
 * Part 2- Sending Messages
 * @author Student
 */
public class SendingMessages {

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
            input.close();
        }
        
    }
        
        // Login Method
        public static boolean login(Scanner input){
            System.out.println("Enter your username:");
            String username = input.nextLine();
            
            System.out.println("Enter your password:");
            String password = input.nextLine();
            
            // Registered details
            String correctUsername = "De_e";
            String correctPassword = "Pass123!";
            
            return username.equals(correctUsername) && password.equals(correctPassword);
    }

}
