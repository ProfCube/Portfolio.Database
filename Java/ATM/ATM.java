/**
 *  BankAccount ATM Lab
 *  @author : Carlos Badillo
 */
public class ATM
{
    private String name;
    private int number;
    private double balance;

    // Default constructor
/*    public ATM() {
        this.name = "";
        this.number = 101;
        this.balance = 500;
    }*/

    // Constructor with parameters
    public ATM(String name, int number, double balance){
        this.name = name;
        this.number = number;
        this.balance = balance;
    }


    // Getter methods
    public String getName() {
        return name;
    }
    public double getNumber(){
        return number;
    }
    public double getBalance(){
        return  balance;
    }

/*
    // Setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }


    public String toString(){
        return "Account Name: " + name + "\nAccount Number: " + number + "\nBalance: $" + balance;
    }
*/
    // Deposit Method
    public String deposit(double amount){
        if (amount <= 0){
            return "Enter an amount, it cannot equal to $0";
        } else {
            balance += amount;
            return "Deposited $" + amount + ".\nNew balance: $" + balance;
        }
    }

    public String witdraw(double amount){
        if (amount <= 0){
            return "Withdraw amount must be greater than $0.";
        } else if (amount < 1 | amount > 300) {
            return "Withdraw amount must be between $1 and $200.";
        } else if (amount > balance){
            return "Insufficient funds. Current balance: $" + balance;
        } else {
            balance -= amount;
            return "Withdrew $" + amount + ".\nNew balance: $" + balance;
        }
    }

    public String transfer(ATM targetAccount, double amount){
        if (amount <= 0){
            return "Transfer amount must be greater than $0.";
        } else if (amount > this.balance) {
            return "Insufficient funds for transfer. Current balance: $" + this.balance;
        } else if (amount < 1 || amount > 200){
            return "Transfer amount must be between $1 and $200.";
        } else {
            this.balance -= amount;
            targetAccount.balance += amount;
            return "Transferred $" + amount + " to " + targetAccount.getName() + ".\nYour new balance: $" + this.balance;
        }
    }

    public String toString(){
        return "Account Name: " + name + "\nAccount Number: " + number + "\nBalance: $" + balance;
    }
/*
    public static void main(String[] args){
        ATM atm = new ATM("Neko", 123, 1000);
        System.out.println(atm.toString());

        // Test getter methods
        System.out.println("Using Getter Methods:");
        System.out.println("Account Name: " + atm.getName());
        System.out.println("Account Number: " + atm.getNumber());
        System.out.println("Account Balance: $" + atm.getBalance());

        // Test setter methods
        atm.setName("Maria");
        atm.setNumber(456);
        atm.setBalance(1200);
        System.out.println("After Using Setter Methods:");
        System.out.println(atm.toString());
    }
 */
}
