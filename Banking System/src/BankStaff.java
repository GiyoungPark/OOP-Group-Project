import java.util.*;

public class BankStaff extends Bank{
    Scanner scanner = new Scanner(System.in);
    int choice;
 

	public BankStaff() {
	}

    void menueChoice(){
        System.out.println("Bank Admin");
        System.out.println("(1) Add Account");
        System.out.println("(2) Close Account");
        this.choice = scanner.nextInt();
        if (choice == 1) {
            this.addAccount();
        }else if(choice == 2){
            this.removeAccount();
        }else
            System.out.println("Error bad choice");
    }

    void addAccount(){
        Random rand = new Random();

        int accountNumber = rand.nextInt(99999) + 10000;
        System.out.println("New Account number is: " + accountNumber);
        super.addAccount(accountNumber, 0);
        Account tmpAccnt = new Account();
        tmpAccnt = super.searchAccounts(accountNumber);


        //add SSN
        int SSN = 0;
        System.out.print("Enter 9 digit SSN: ");
        SSN = scanner.nextInt();
        tmpAccnt.setSSN(SSN);

        //add PIN
        System.out.print("Enter 4 digit PIN: ");
        int PIN = scanner.nextInt();
        tmpAccnt.setPIN(PIN);

        //verify Checking or Saving
        System.out.println("(1) Checking Account ");
        System.out.println("(2) Savings Account");
        this.choice = scanner.nextInt();
        if(choice == 1){
            tmpAccnt.checking = true;
        }else if (choice == 2) {
            tmpAccnt.saving = false;
        }else
            System.out.println("ERROR bad choice");

    }

    void removeAccount(){
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        super.removeAccount(accountNumber);
    }

    Saving searchSaving(int accountNumber){
    }

    Checking searchChecking(int accountNumber){
    }


}


