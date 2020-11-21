package Midterm;

class AccountTest{
    public static void main(String[] args) throws Exception {
        Account account = new Account(1122,20000);
        System.out.println("Initial Balance: $" + account.getBalance());
        account.setAnnualInterestRate(0.045);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest : $" + account.getMonthlyInterest());
        System.out.println("Date created: " + account.getDateCreated());
    }
}
public class Account {
    private static final int DEFAULT_ID = 0;
    private static final double DEFAULT_BALANCE = 0;
    private static final double DEFAULT_RATE = 0;

    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = DEFAULT_ID;
        this.balance = DEFAULT_BALANCE;
        annualInterestRate = DEFAULT_RATE;
        this.dateCreated = new Date(3,1,2019);
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        annualInterestRate = DEFAULT_RATE;
        this.dateCreated = new Date(3,1,2019);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id < 0) throw new Exception("Error: id cannot be negative!");
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws Exception {
        if(balance < 0) throw new Exception("Error: Balance cannot be negative!");
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) throws Exception {
        if(annualInterestRate < 0) throw new Exception("Error: Rate cannot be negative!");
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return new Date(dateCreated);
    }

    public static double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return this.balance * this.getMonthlyInterestRate();
    }

    public void withdraw(double withdrawAmount) throws Exception {
        System.out.printf("Withdrawing $%.2f from account...\n", withdrawAmount);
        if(withdrawAmount < 0) throw new Exception("Withdraw failure: Withdraw amount cannot be negative!");
        else if(withdrawAmount > this.balance) throw new Exception("Error: Withdraw amount exceeds account balance.");
        else {
            this.balance -= withdrawAmount;
            System.out.printf("Account id: %d. Your account balance is now: $%.2f\n", this.getId(), this.getBalance());
        }
    }

    public void deposit(double depositAmount) throws Exception {
        System.out.printf("Depositing $%.2f to account...\n", depositAmount);
        if(depositAmount < 0) throw new Exception("Deposit failure: Deposit amount cannot be negative!");
        else {
            this.balance += depositAmount;
            System.out.printf("Account id: %d. Your account balance is now: $%.2f\n", this.getId(), this.getBalance());
        }
    }
}
