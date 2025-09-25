//BANKING APPLICATION FOR ACCOUNT MANAGEMENT


import java.util.Scanner;

class Account{
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    void deposit (double amount){
        if ( amount > 0){
            balance += amount;
            System.out.println("SUCCESSFULLY DEPOSITED" + amount);
        }
        else{
            System.out.println("DEPOSIT AMOUNT SHOULD BE POSITIVE ");
        }
    }

    void withdraw ( double amount ){
        if ( amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("SUCCESSFULLY WITHDRAWN " + amount);
        }
        else if ( amount > 0 && amount > balance){
            System.out.println("INSUFFICIENT BALANCE\n"+ "CURRENT BALANCE : Rs. "+ balance);
        }
        else{
            System.out.println("WITHDRAWAL AMOUNT SHOULD BE POSITIVE ");
        }

    }

    void displayAccountDetails (){
        System.out.println(" Account Number: " + accountNumber);
        System.out.println(" Account Holder's Name: " + accountHolderName);
        System.out.println(" Current Balance:  Rs. " + balance);
        System.out.println(" Email Address : " + email);
        System.out.println(" Contact Number: " + phoneNumber);

    }

    void updateContactDetails ( String email, String phoneNumber){
        this.email= email;
        this.phoneNumber = phoneNumber;
        System.out.println("CONTACT DETAILS UPDATED SUCCESSFULLY!");
    }

}
class UserInterface{
    Account [] accounts;
    int accountCount;
    static int accountNumberStart =10000;
    Scanner userInput;

    UserInterface() {
        accounts = new Account[100];
        accountCount =0;
        userInput = new Scanner(System.in);
    }

    void createAccount () {
        int accountNumber = ++ accountNumberStart;

        userInput.nextLine();
        System.out.println(" Enter account holder's name : ");
        String name = userInput.nextLine();

        System.out.println("Enter the initial account balance : ");
        double initialBalance = userInput.nextDouble();
        userInput.nextLine();

        System.out.println(" Enter the email : ");
        String email = userInput.nextLine();

        System.out.println("Enter contact number : ");
        String phone = userInput.nextLine();

         accounts[accountCount] = new Account(accountNumber, name, initialBalance, email, phone );
        System.out.println("\n ACCOUNT CREATED SUCCESSFULLY WITH ACCOUNT NUMBER : " + accountNumber);
        accountCount++;
    }

    void performDeposit(){
        System.out.println("Enter account number : ");
        int accNo = userInput.nextInt();
        for ( int i=0; i < accountCount; i++){
            if (accounts[i].accountNumber == accNo){
                System.out.println(" Enter amount to be deposited : ");
                double amount = userInput.nextDouble();
                accounts[i].deposit(amount);
                return;
            }
        }
         System.out.println("ACCOUNT NOT FOUND!");
    }

    void performWithdraw(){
        System.out.println("Enter account number : ");
        int accNo = userInput.nextInt();
        for ( int i=0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNo) {
                System.out.println(" Enter amount to be withdrawn : ");
                double amount = userInput.nextDouble();
                accounts[i].withdraw(amount);
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND!");
    }

    void showAccountDetails(){
        System.out.println("Enter account number : ");
        int accNo = userInput.nextInt();
        for ( int i=0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNo) {
                accounts[i].displayAccountDetails();
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND!");
    }

    void updateContact(){
        System.out.println("Enter account number :");
        int accNo = userInput.nextInt();
        userInput.nextLine();
        for ( int i=0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNo) {
                System.out.println("Enter new email address : ");
                String email = userInput.nextLine();
                System.out.println("Enter new phone number : ");
                String phone = userInput.nextLine();
                accounts[i].updateContactDetails(email, phone);
                return;
            }
        }
        System.out.println("ACCOUNT NOT FOUND!");
    }

    void mainMenu(){
        while ( true ){
            System.out.println("\n----------WELCOME TO THE BANKING APPLICATION !!----------\n");
            System.out.println(" 1. Create a New Account");
            System.out.println(" 2. Deposit Money ");
            System.out.println(" 3. Withdraw Money ");
            System.out.println(" 4. View Account Details ");
            System.out.println(" 5. Update Contact Details ");
            System.out.println(" 6. EXIT \n\n");

            System.out.println("Enter your choice: ");
            int choice = userInput.nextInt();

            switch(choice){
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdraw();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println(" Thank You for using our Banking Application.");
                    return;
                default:
                    System.out.println("INVALID CHOICE!\n PLEASE TRY AGAIN!!");
            }

        }
    }
}

public class BankingApp{
    public static void main(String[] args) {
        UserInterface UI = new UserInterface();
        UI.mainMenu();
    }
}