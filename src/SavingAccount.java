//Saving Account child Class
//Has an interest rate
// a method to apply interest - profit

import javax.accessibility.AccessibleValue;

public class SavingAccount extends Account {

    //interest rate
    private  double interestRate;
    //Default constructor
    public SavingAccount(){
        super();
    }

    /**
     * Parameter constructor to intialize Saving account with a customer account
     * number and interest rate
     * @param accountNumber
     * @param
     */
    public SavingAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate=interestRate;

    }
    public double getInterestRate(){
        return this.interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }

    public double calcInterst(){
        return balance * interestRate;
    }
    public void applyInterst(){
        double interest=calcInterst();
        System.out.printf("Interest amount %.2f added to balance%n",interest);
        deposit(interest);
    }
    /**
     *Funciton to deposit funds into the account as long as
     * the amount parameter is >0
     *
     * Apply Transaction fee for the checkingAccount
     * @param amount value to be deposited
     */
    public void deposit(double amount){
        //First Check Amount
        if(amount >0){
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            //Apply Transaction Fee

            System.out.printf("Current Balance is: %.2f deposited%n", amount);
        }else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    /**
     * Function to withdraw funds from the account as long as
     * 1.Account to withdraw must to >0
     * 2.Account to withdraw must be <=balance
     * @param amount value to be withdraw
     */
    public void withDraw(double amount){
        //Same check
        if(amount >0){
            // Check sufficient balance
            if((amount) <=balance){
                System.out.printf("Amount of %.2f withdraw from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);
            }else {
                System.out.println("Negative amount cannot be withdraw");
            }
        }
    }
}
