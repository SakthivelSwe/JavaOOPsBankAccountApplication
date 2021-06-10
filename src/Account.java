// Base class
// Abstract class
public abstract class Account {
    //AccountNumber
    private int accountNumber;

    //Balance
    protected double balance;

    //Default constructor
    public  Account(){

    }
    public Account(int accountNumber){
        this.accountNumber=accountNumber;
        balance=0;
    }

    //Getter Methods
    public  double getBalance(){
        return this.balance;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }

    //Abstract
    /**
     *Funciton to deposit funds into the account as long as
     * the amount parameter is >0
     *
     * Apply Transaction fee for the checkingAccount
     * @param amount value to be deposited
     */
    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds from the account as long as
     * 1.Account to withdraw must to >0
     * 2.Account to withdraw must be <=balance
     * @param amount value to be withdraw
     */
    public abstract void withDraw(double amount);
}
