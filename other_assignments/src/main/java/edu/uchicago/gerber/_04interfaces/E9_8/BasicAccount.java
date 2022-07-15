package edu.uchicago.gerber._04interfaces.E9_8;

/**
 * Basic accounts do not allow withdrawals beyond what is in the balance.
 */
public class BasicAccount extends BankAccount {
    /*
    Constructs a basic account with a zero balance
     */
    public BasicAccount() {
    }

    /*
    Check if the Basic Account balance is sufficient to make withdrawal
     */
    public void withdraw(double amount) {
        if (super.getBalance() - amount < 0 ) {
            System.out.printf("You don't have enough money in your account to withdraw $%.2f", amount);
        }
        else {
            super.withdraw(amount);
        }
    }
}
