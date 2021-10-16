package edu.uchicago.gerber._03objects.P8_16;

public class Message {
    private final String recipient;
    private final String sender;
    private String message;

    public Message(String recipient, String sender) {
        this.recipient = recipient;
        this.sender = sender;
        this.message = "";
    }

    public void append(String text) {
        this.message = message + text;
    }

    public String toString() {
        return "From: " + sender + "\nTo: " + recipient + "\n" + message;
    }
}
