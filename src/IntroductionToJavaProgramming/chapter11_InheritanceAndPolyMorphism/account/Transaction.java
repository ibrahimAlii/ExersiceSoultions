package IntroductionToJavaProgramming.chapter11_InheritanceAndPolyMorphism.account;

import java.util.Date;

public class Transaction {

    //Data fields
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    /**
     * @param type        for the transaction Type such as 'W' for withdrawal, 'D' for deposit.
     * @param amount      The amount of the transaction.
     * @param balance     The new balance after this transaction
     * @param description The description of this transaction.
     *
     */
    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        date = new Date();
    }


    /**
     *Getter and setters
     */
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
