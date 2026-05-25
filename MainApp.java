/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class MainApp {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    public MainApp(int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        generateMessageID();
    }
    //Generates 10 digit ID number
    private void generateMessageID() {
    Random random = new Random();
        StringBuilder id = new StringBuilder();
         for (int i = 0; i < 10; i++) {
            id.append(random.nextInt(10));
        }
         messageID = id.toString();}
    //checks id message ID length
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }
    //It validates the recipients ID number
    public String checkRecipientCell() {
    if (recipient.startsWith("+27")
                && recipient.length() <= 13) {
    return "Cell phone number successfully captured.";
        }
    return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    //Validates the length of the message
    public String checkMessageLength() {
    if (messageText.length() <= 250) {
        return "Message ready to send.";
        }
    int over = messageText.length() - 250;
    return "Message exceeds 250 characters by "
                + over
                + "; please reduce the size.";
    }

    //Creates the message hash
    public String createMessageHash() {

        String idPart = messageID.substring(0, 2);
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
         messageHash = idPart
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;

        return messageHash.toUpperCase();
    }
    // Handles message action

    public String sentMessage() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
            return "Message successfully sent.";
            case 2:
            return "Press 0 to delete the message.";
            case 3:
            storeMessage();
            return "Message successfully stored.";
            default:
            return "Invalid option.";
        }
    }
    // Stores message in JSON file
    public void storeMessage() {
       JSONObject obj = new JSONObject();
       obj.put("messageID", messageID);
       obj.put("recipient", recipient);
       obj.put("message", messageText);

        try (FileWriter writer =new FileWriter("messages.json", true)) {
            writer.write(obj.toString());
            writer.write("\n");
        } catch (IOException e) {
       System.out.println("Error writing file."); } }
    public int returnTotalMessages() {
        return messageNumber;
    }public String getMessageID() {
        return messageID;
    }
}
        
    
    

