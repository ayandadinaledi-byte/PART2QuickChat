/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2quickchat;
import javax.swing.JOptionPane;
/**
 *
 * @author Student
 */
public class PART2QuickChat {
    public static void main(String[] args) {
        Message msg = new Message();
        
        // Test your methods
        String recipient = JOptionPane.showInputDialog("Enter recipient number with + (e.g. +27718693002):");
        String result = msg.checkRecipientCell(recipient);
        JOptionPane.showMessageDialog(null, result);
        
        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 chars):");
        String lengthCheck = msg.checkMessageLength(messageText);
        JOptionPane.showMessageDialog(null, lengthCheck);
        
        if (lengthCheck.equals("Message ready to send.")) {
            String id = msg.generateMessageID();
            String hash = msg.createMessageHash(id, 0, messageText);
            JOptionPane.showMessageDialog(null, 
                "ID: " + id + "\nHash: " + hash + "\n" + msg.SentMessage(1));
}
    }
} 
