package edu.uchicago.gerber._03objects.P8_16;
import java.util.ArrayList;

public class Mailbox {
    /*
    Declare array list for storing objects of Message class
     */
    private ArrayList<Message> inbox;

    /*
    Constructor for initiating default array list instance variable
     */
    public Mailbox() {
        this.inbox = new ArrayList<>();
    }

    /**
     * Adds email of Message class to Mailbox array list
     * @param m Message class object
     */
    public void addMessage(Message m) {
        inbox.add(m);
    }

    /**
     * Given index of email Message in Mailbox, retrive and return it
     * @param i index of Message location in Mailbox array list
     * @return  Message at index i
     */
    public Message getMessage(int i) {
        return inbox.get(i);
    }

    /**
     * Delete Message object stored in the array list at input index
     * @param i index of Message location in Mailbox array list
     */
    public void removeMessage(int i) {
        inbox.remove(i);
    }
}
