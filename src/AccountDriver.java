import java.util.Scanner;
public class AccountDriver {
    //Entry point of program
    public static  void main(String[] args){
        Scanner keyBoard=new Scanner(System.in);

        //Create  Array of  Account
        Account accounts[] = new Account[10];

        int numAccounts = 0;
        int choice;

        do{
           choice = menu(keyBoard);
            System.out.println();

            if(choice == 1){
                accounts[numAccounts++] = createAccount(keyBoard);
            }else if(choice == 2){
                doDeposit(accounts,numAccounts,keyBoard);
            }else if(choice == 3){
                doWithDraw(accounts, numAccounts, keyBoard);
            }else if(choice == 4){
                applyIntest(accounts, numAccounts, keyBoard);
            }else {
                System.out.println("GoodBye!!! User");
            }
            System.out.println();
        }while(choice != 5);

    }

    /**
     * Account Choice
     * @param keyBoard
     * @return
     */
    public static int accountMenu(Scanner keyBoard){
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyBoard.nextInt();

        }while (choice < 1 || choice > 2);

        return choice;
    }

    public static int searchAccount(Account accounts [],int count,int accountNumber){
        for(int i=0;i<count;i++){
            if(accounts[i].getAccountNumber() == accountNumber);
            return i;
        }
        return -1;
    }

    /**
     * Funtion to perform Deposit on a selected
     * @param accounts
     * @param count
     * @param keyBoard
     */
    public static void doDeposit(Account accounts [],int count,Scanner keyBoard){
        //Get the account number
        System.out.print("\n Please enter account Number: ");
        int accountNumber=keyBoard.nextInt();

        //search for account
        int index=searchAccount(accounts,count,accountNumber);

        if(index >= 0){
            //Amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyBoard.nextDouble();

            accounts[index].deposit(amount);
        }else {
            System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }
    public static void doWithDraw(Account accounts [],int count,Scanner keyBoard){
        //Get the account number
        System.out.print("\n Please enter account Number: ");
        int accountNumber=keyBoard.nextInt();

        //search for account
        int index=searchAccount(accounts,count,accountNumber);

        if(index >= 0){
            //Amount
            System.out.println("Please enter Deposit Amount: ");
            double amount = keyBoard.nextDouble();

            accounts[index].withDraw(amount);
        }else {
            System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }
    public static void applyIntest(Account accounts[],int count,Scanner keyBoard){
        //Get the account number
        System.out.print("\nPlease enter account Number: ");
        int accountNumber=keyBoard.nextInt();

        //search for account
        int index=searchAccount(accounts,count,accountNumber);

        if(index >= 0){
         //must be instance of saving account
            if(accounts[index] instanceof  SavingAccount){
                ((SavingAccount) accounts[index]).applyInterst();
            }
        }else {
            System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }

    /**
     * Function to create a new Account
     * @param keyBoard
     * @return
     */
    public static Account createAccount(Scanner keyBoard){
        Account account=null;
        int choice = accountMenu(keyBoard);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber=keyBoard.nextInt();

        if(choice == 1){
            //checking account
            System.out.print("Enter Transaction Fee: ");
            double fee = keyBoard.nextDouble();
            account=new CheckingAccount(accountNumber,fee);
        }else {
            //saving Account
            System.out.print("Please Enter Interest Rate: ");
            double ir = keyBoard.nextDouble();
            account=new SavingAccount(accountNumber, ir);
        }
        return account;
    }
    /**
     * Menu to display options and get the user's selection
     * @param keyBoard
     * @return
     */
    public static int menu(Scanner keyBoard){
        System.out.println("Bank Account menu");
        System.out.println("1. Create new Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. ApplyInterest");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.print("Enter choice: ");
            choice = keyBoard.nextInt();
        }while (choice<1 || choice > 5);
        return choice;
    }
}
