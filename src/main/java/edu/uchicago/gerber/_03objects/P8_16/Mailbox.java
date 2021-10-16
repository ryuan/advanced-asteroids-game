package edu.uchicago.gerber._03objects.P8_16;
import java.util.ArrayList;

public class Mailbox {
    private ArrayList<Message> inbox;

    public Mailbox() {
        this.inbox = new ArrayList<>();
    }

    public void addMessage(Message m) {
        inbox.add(m);
    }

    public Message getMessage(int i) {
        return inbox.get(i);
    }

    public void removeMessage(int i) {
        inbox.remove(i);
    }
}
