/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.sendingmessages.Message;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
 public class MessageTest {

    @Test
    void testRecipientValidation() {
        Message msg = new Message();
        msg.setRecipient("+27712345678");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    void testInvalidRecipient() {
        Message msg = new Message();
        msg.setRecipient("0712345678");  // missing +
        assertTrue(msg.checkRecipientCell().contains("incorrectly formatted"));
    }

    @Test
    void testMessageLength() throws IOException {
        Message msg = new Message();
        msg.setRecipient("+27712345678");
        msg.setMessage("This is a short message.");
        assertEquals("Message successfully sent.", msg.sendMessage());
    }

    @Test
    void testMessageTooLong() throws IOException {
        Message msg = new Message();
        msg.setRecipient("+27712345678");
        
        String longMessage = "A".repeat(251);
        msg.setMessage(longMessage);
        
        String result = msg.sendMessage();
        assertTrue(result.contains("exceeds 250 characters"));
    }

    @Test
    void testMessageHash() throws IOException {
        Message msg = new Message();
        msg.setRecipient("+27712345678");
        msg.setMessage("Hi Mike, can you join us for dinner tonight?");
        
        msg.sendMessage();  // This creates the hash
        String hash = msg.createMessageHash();  // or check after sendMessage
        
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
    }

    @Test
    void testTotalMessagesCounter() {
        int before = Message.returnTotalMessagesSent();
        Message msg1 = new Message();
        Message msg2 = new Message();
        assertEquals(before + 2, Message.returnTotalMessagesSent());
    }
}