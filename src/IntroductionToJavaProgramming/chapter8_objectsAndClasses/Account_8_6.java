package IntroductionToJavaProgramming.chapter8_objectsAndClasses;


import java.util.Date;

/*
 ******************************
 *          Account           *
 * ---------------------------*
 * -id : int
 * -balance : double
 * -annualInterestRate : double
 * -dateCreated : Date
 * +Account()
 * +Account(id : int, balance : double)
 * +setId(id : int)
 * +setBalance(balance : double)
 * +setAnnual(annual : double)
 * +setDate(date : Date)
 * +getId() : int
 * +getBalance() : double
 * +getAnnual() : double
 * +getDate() : Date
 * +getMonthlyInterestRate() : double
 * +getMonthlyInterest() : double
 * +withdraw(amount : double)
 * +deposit(amount : double)
 */
public class Account_8_6 {


    // Data fields
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    // Constructors
    /** Creates a default account */
    Account_8_6() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    /** Creates an account with the specified id and initial balance */
    Account_8_6(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
        dateCreated = new Date();
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

    // Methods
    /** Return monthly interest */
    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }

    /** Decrease balance by amount */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /** Increase balance by amount */
    public void deposit(double amount) {
        balance += amount;
    }
}


