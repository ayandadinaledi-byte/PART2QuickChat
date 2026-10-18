/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2quickchat;
import java.util.Random;

/**
 *
 * @author Student
 */
public class Message {
  public String generateMessageID(){
        Random rand=new Random();
        long id=1000000000L+(long)(rand.nextDouble()*9000000000L);
        return String.valueOf(id);
    }
    public boolean checkMessageID(String id){return id.length()<=10;}
    public String checkRecipientCell(String cell){
        if(cell!=null && cell.startsWith("+") && cell.length()>=10 && cell.length()<=13){
            String digits=cell.substring(1);
            if(digits.matches("\\d+")){return "Cell phone number successfully captured.";}
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
    public String checkMessageLength(String message){
        if(message.length()<=250){return "Message ready to send.";}
        else{int excess=message.length()-250;return "Message exceeds 250 characters by "+excess+", please reduce the size.";}
    }
    public String createMessageHash(String messageID,int messageNumber,String message){
        String firstTwo=messageID.substring(0,2);
        String[] words=message.trim().split("\\s+");
        String firstWord=words[0].replaceAll("[^a-zA-Z]","");
        String lastWord=words[words.length-1].replaceAll("[^a-zA-Z]","");
        return firstTwo+":"+messageNumber+":"+(firstWord+lastWord).toUpperCase();
    }
    public String SentMessage(int option){
        if(option==1)return "Message successfully sent.";
        if(option==2||option==0)return "Press 0 to delete the message.";
        if(option==3)return "Message successfully stored.";
        return "Invalid option.";
        }
    }
