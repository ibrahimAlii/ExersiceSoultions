package IntroductionToJavaProgramming.chapter11_InheritanceAndPolyMorphism.account;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    // Data fields
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions;

    // Constructors
    /** Creates a default account */
    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    /** Creates an account with the specified id and initial balance */
    public Account(String name, int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        dateCreated = new Date();
        transactions = new ArrayList<>();
    }

    // Mutator methods
    /** Set id */
    public void setId(int newId) {
        id = newId;
    }

    /** Set balance */
    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    /** Set annualInterestRate */
    public void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    /** Set name */
    public void setName(String name){
        this.name = name;
    }

    // Accessor methods
    /** Return id */
    public int getId() {
        return id;
    }

    /** Return balance */
    public double getBalance() {
        return balance;
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Return dateCreated */
    public String getDateCreated() {
        return dateCreated.toString();
    }

    /** Return monthly interest rate */
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    /** Return name */
    public String getName() {
        return name;
    }

    /** Return Transactions*/
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    // Methods
    /** Return monthly interest */
    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    /** Decrease balance by amount */
    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, "Withdraw from account"));
    }

    /** Increase balance by amount */
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('W', amount, balance, "Deposit from account"));
    }
}
