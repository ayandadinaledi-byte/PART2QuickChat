/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.part2quickchat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {

    Message m = new Message();

    @Test
    public void testMessageLengthSuccess() {
        assertEquals("Message ready to send.", m.checkMessageLength("Hi there"));
    }

    @Test
    public void testMessageLengthFailure() {
        String longMsg = "a".repeat(260);
        String result = m.checkMessageLength(longMsg);
        assertTrue(result.contains("exceeds 250"));
    }

    @Test
    public void testRecipientSuccess() {
        assertEquals("Cell phone number successfully captured.", m.checkRecipientCell("+27718693002"));
    }

    @Test
    public void testRecipientFailure() {
        String result = m.checkRecipientCell("08575975889");
        assertTrue(result.contains("incorrectly formatted"));
    }

    @Test
    public void testMessageHash() {
        String hash = m.createMessageHash("0012345678", 0, "Hi there");
        assertEquals("00:0:HITHERE", hash);
    }

    @Test
    public void testMessageIDLength() {
        String id = m.generateMessageID();
        assertTrue(id.length() <= 10);
    }
    
    @Test
    public void testMessageIDGenerated() {
        String id = m.generateMessageID();
        assertNotNull(id);
        assertTrue(m.checkMessageID(id));
    }
    
}
