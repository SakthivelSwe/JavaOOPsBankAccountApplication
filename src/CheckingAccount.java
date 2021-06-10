//Checking Account
public class CheckingAccount extends Account {

    private static double FEE=2.5;

    //Default constructor
    public CheckingAccount(){
        super();
    }

    /**
     * Parameter constructor to intialize checking Account
     * with a custom Account Number and a customer Transaction
     * Fee.
     * @param accountNumber
     * @param fee
     */
    public CheckingAccount(int accountNumber,double fee){
        super(accountNumber);
        FEE = fee;
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
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n",FEE);
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
            if((amount+FEE) <=balance){
                System.out.printf("Amount of %.2f withdraw from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }else {
                System.out.println("Negative amount cannot be withdraw");
            }
        }
    }
}
