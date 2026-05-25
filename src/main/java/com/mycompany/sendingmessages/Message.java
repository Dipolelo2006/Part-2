/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sendingmessages;

/**
 *
 * @author Student
 */
public class Message {
    private String recipient;
    private String messageID;
    private String messageHash;
    private String messageText;
    private static int numMessagesSent = 0;
    
    //Constructor
    public Message(){
        this.messageID = generateMessageID();
    }
    private String generateMessageID(){
        numMessagesSent++;
        return String.format("MSG%07d", numMessagesSent);
    } 
    
    //Setters
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }
    
    public void setMessage(String message){
        this.messageText = messageText;
    }
   
    public boolean checkMessageID(){
        return messageID != null && messageID.length() <= 10;
    }
    
    public String checkRecipientCell(){
        if(recipient == null || recipient.length()>10 || !recipient.startsWith("+27")){
          return"Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again." ; 
        }
        return"Cell phone number successfully captured.";
    }
    
    public String createMessageHash(){
        if(messageText == null || messageText.trim().isEmpty()){
            return"00:0:EMPTY";
        }
        String[] words =messageText.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words.length>1? words[words.length - 1].toUpperCase(): firstWord;
        
        messageHash = messageID.substring(0, 2) + ":" +firstWord + lastWord;
        return messageHash;
    }
    
    public String sendMessage(){
        String recipientCheck = checkRecipientCell();
        if(!recipientCheck.contains("Successfully!")){
            return recipientCheck;
        }
       if(messageText == null || messageText.length()>250){
           int excess = messageText != null ? messageText.length()-250:0;
           return "Message exceeds 250 characters by" + excess + "characters, please reduce the size.";
       }
       createMessageHash();
       return "Message successfully stored.";
    }
    
    public String printMessageDetails(){
        System.out.println("Message ID:" + messageID);
        System.out.println("Message Hash:" + (messageHash != null ? messageHash: "N/A"));
        System.out.println("Recipient:" + recipient);
        System.out.println("\nMessage:" + messageText);
        return null;
    }
    public static int returnTotalMessagesSent(){
        return numMessagesSent;
    }
    
}
