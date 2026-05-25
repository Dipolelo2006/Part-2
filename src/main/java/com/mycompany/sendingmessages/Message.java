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
    private String message;
    
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    public String sendMessage(){
        return"Message sent successfully";
    }
    
    public String printMessageDetails(){
        return "Recipient:" + recipient + 
                "\nMessage:" + message;
    }
    
    public static int returnTotalMessagesSent(){
        return 0;
    }
    
}
