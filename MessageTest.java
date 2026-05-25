/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class MessageTest {
    public void testMessageLengthSuccess() {
        Message msg = new Message(0,"+27718693002","Hi Mike can you join us for dinner tonight");
        assertEquals(Ready to send.",msg.checkMessageLength());
    }
    public void testMessageLengthFailure() {
        String longMessage = "a".repeat(260);
        Message msg = new Message(0,"+27718693002",longMessage);
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.",msg.checkMessageLength());
    }
    public void testRecipientSuccess() {
        Message msg = new Message(0,"+27718693002","Hello");
        assertEquals("Cell phone number successfully captured.",
        msg.checkRecipientCell());
    }
    public void testRecipientFailure() {
        Message msg = new Message(0,"08575975889","Hello");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",msg.checkRecipientCell());
    }
    public void testMessageHash() {
        Message msg = new Message(0,"+27718693002","Hi Mike can you join us for dinner tonight");
        String hash = msg.createMessageHash();
        assertTrue(hash.contains(":0:HITONIGHT"));
    }
    public void testMessageID() {
     Message msg = new Message(0,"+27718693002","Hello");
     assertTrue(msg.checkMessageID());
    }
}
