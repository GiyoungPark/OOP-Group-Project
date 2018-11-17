import java.util.*;

public class BankStaff extends Bank{
    int choice;
    Scanner scanner = new Scanner(System.in);

	public BankStaff() {
        this.menueChoice();
        if (choice == 1){
            this.addAccount();
        } if (choice == 2){
            this.removeAccount();
        }
	}

    void menueChoice(){
        System.out.println("Bank Admin");
        System.out.println("////////////////////////////////");
        System.out.println("1. Add Account");
        System.out.println("2. Close Account");
        while (true){
            try {
                this.choice = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.print("Please specify selection with 1 or 2: ");
                scanner.next();
            }finally {
                return;
            }
        }
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
        try {
            SSN = scanner.nextInt();
            String ssn = Integer.toString(SSN);
            if (ssn.length() != 9){
                throw new java.lang.RuntimeException(ssn + " " + ssn.length());
            }
        }catch (InputMismatchException e){
            System.out.print("Please specify a number");
            scanner.nextInt();
        }catch (java.lang.RuntimeException e){
            System.out.println("Please enter a 9 digit number: ");
            scanner.nextInt();
        }finally{
            System.out.println("SSN: " + SSN);
        }
        tmpAccnt.setSSN(SSN);

        //add PIN
        System.out.print("Enter 4 digit PIN: ");
        int PIN = scanner.nextInt();
        tmpAccnt.setPIN(PIN);

        //verify Checking or Saving
        System.out.println("1. Checking Account ");
        System.out.println("2. Savings Account");
        while (true){
            try {
                this.choice = scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.next();
                System.out.print("Please specify selection with 1 or 2: ");
            }
        }

    }

    void removeAccount(){
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        super.removeAccount(accountNumber);
    }

}


