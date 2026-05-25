/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sendingmessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

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
            sendMessages(input);
        }catch (Exception e){
            System.out.println("An error has occured:" + e.getMessage());   
        }
    }
    
    //=================Part 1===============================
    private static boolean login (Scanner input){
        System.out.println("\n===Login to QuickChat===");
        
        System.out.println("Enter your username:");
        String username = input.nextLine();
        
        System.out.println("Enter your password:");
        String password = input.nextLine();
        
       if(username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty()){
           System.out.println("Login successful.");
           return true;  
       }else{
           System.out.println("Login failed. Incorrect password or username.");
           return false;
       }
    }
    public static void sendMessage(Scanner input) throws IOException{
        // Step 5
        System.out.println("How many messages would you like to send?");
        int numMessages = input.nextInt();
        input.nextLine(); // Consume NewLine
        
        for (int i= 1; i <= numMessages; i++){
            System.out.println("\n===Processing Message" + i + "===");
            
            Message msg= new Message();
            
            // Step 6
            System.out.println("Enter recipient cell number:");
            String recipient = input.nextLine();
            msg.setRecipient(recipient);
            
            System.out.println("Enter your message (Max 250 characters):");
            String text = input.nextLine();
            msg.setMessage(text);
            
            System.out.println("\n====QuickChat Main Menu====");
            System.out.println("Option 1). Send Messages"); //3a
            System.out.println("Option 2). Show recently sent messages");//3b
            System.out.println("Option 3) Quit");
            System.out.println("Enter your choice:");
            
            int action = input.nextInt();
            input.nextLine(); // Consume NextLine
            
            switch (action){
                case 1:
                    String result = msg.sendMessage();
                    System.out.println(result);
                    if(result.equals("Message successfully sent.")){
                        msg.printMessageDetails();
                        sentMessages.add(msg);
                    }
                    break;
                    
                case 2:
                    System.out.println("Press 0 to delete the message.");
                    System.out.println("Message disregarded.");
                    break;
                    
                case 3:
                    System.out.println(msg.storeMessage());
                    msg.printMessageDetails();
                    sentMessages.add(msg);
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        // Step 6 continued
        System.out.println("\nTotal Messages sent:" + Message.returnTotalMessagesSent());
        System.out.println("Thank you for using QuickChat. Goodbye!");
    }

    private static void sendMessages(Scanner input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}

//=======REFERENCING LIST:==============
//OpenAI, 2026. ChatGPT AI language model. Available at: https://openai.com/chatgpt [Accessed 25 May 2026].
//Mozilla, 2026. MDN Web Docs. Available at: https://developer.mozilla.org [Accessed 25 May 2026].
//Stack Overflow, 2026. Programming discussions and solutions. Available at: https://stackoverflow.com [Accessed 25 May 2026].
//W3Schools, 2026. Online web development tutorials. Available at: https://www.w3schools.com [Accessed 25 May 2026].
//GitHub, 2026. Software development platform and code repository. Available at: https://github.com [Accessed 25 May 2026].
