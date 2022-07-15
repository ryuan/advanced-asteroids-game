package edu.uchicago.gerber._03objects.P8_16;

public class Message {
    /*
    Initiate instance variables
     */
    private final String recipient;
    private final String sender;
    private String message;

    /**
     * Constructor for initiating instance variables with passed-in parameter values
     * @param recipient String of intended recipient of Message
     * @param sender    String of sender of Message
     */
    public Message(String recipient, String sender) {
        this.recipient = recipient;
        this.sender = sender;
        this.message = "";
    }

    /**
     * Edits the embedded body message within the email
     * @param text  test to append to email Message object
     */
    public void append(String text) {
        this.message = message + text;
    }

    /**
     * Getter for actual email content
     * @return  concatenated email String with stored Message instance variables
     */
    public String toString() {
        return "From: " + sender + "\nTo: " + recipient + "\n" + message;
    }
}
