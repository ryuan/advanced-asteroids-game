package edu.uchicago.gerber._03objects.P8_16;
import java.util.Scanner;

/**
 * P8_16: Crafts an email and integrates it to a mailbox class.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Generate new Message object after taking user input for passing in required parameters
         */

        System.out.print("Type the name of the recipient: ");
        String recipient = in.nextLine();
        System.out.print("Type the name of the sender: ");
        String sender = in.nextLine();

        Message email = new Message(recipient, sender);

        System.out.println("What message do you want to include in your email?");
        email.append(in.nextLine());

        /*
        Create new Mailbox object, then add the Message, return it to check Mailbox works, then delete Message
         */

        Mailbox inbox = new Mailbox();
        inbox.addMessage(email);
        System.out.println(inbox.getMessage(0).toString());
        inbox.removeMessage(0);
    }
}
