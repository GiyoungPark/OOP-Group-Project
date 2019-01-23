// Daniel, Lora, GiYoung, Chase
import java.util.*;

public class BankSystem extends Bank{
    Scanner scanner = new Scanner(System.in);
    int choice;


	public BankSystem() {
        ///Account default
        Account defaultA;
		this.addAccount(10001, true);
		defaultA = this.searchAccounts(10001);
		defaultA.setPIN(1234);
		defaultA.setSSN(567890123);
		defaultA.balance = 700;
		this.addAccount(10002, true);
		defaultA= this.searchAccounts(10002);
		defaultA.setPIN(1123);
		defaultA.setSSN(234567890);
		defaultA.balance = 2000;
		this.addAccount(10003, true);
		defaultA= this.searchAccounts(10003);
		defaultA.setPIN(6789);
		defaultA.setSSN(789012345);
		defaultA.balance = 9000;
		this.addAccount(10004, true);
		defaultA= this.searchAccounts(10004);
		defaultA.setPIN(7890);
		defaultA.setSSN(890123456);
		defaultA.balance = 1000;
		this.addAccount(11111, false);
		defaultA = this.searchAccounts(11111);
		defaultA.setPIN(5678);
		defaultA.setSSN(123456789);
		defaultA.balance = 300;
		this.addAccount(11112, false);
		defaultA = this.searchAccounts(11112);
		defaultA.setPIN(4567);
		defaultA.setSSN(234567890);
		defaultA.balance = 4000;
		this.addAccount(11113, false);
		defaultA = this.searchAccounts(11113);
		defaultA.setPIN(3456);
		defaultA.setSSN(345678901);
		defaultA.balance = 70;
		this.addAccount(11114, false);
		defaultA = this.searchAccounts(11114);
		defaultA.setPIN(2345);
		defaultA.setSSN(456789012);
		defaultA.balance = 5000;

        ////Savings default
        Saving defaultS;
		defaultS = this.searchSavings(10001);
		defaultS.setPIN(1234);
		defaultS.setSSN(567890123);
		defaultS.balance = 700;
		defaultS = this.searchSavings(10002);
		defaultS.setPIN(1123);
		defaultS.setSSN(234567890);
		defaultS.balance = 2000;
		defaultS = this.searchSavings(10003);
		defaultS.setPIN(6789);
		defaultS.setSSN(789012345);
		defaultS.balance = 9000;
		defaultS = this.searchSavings(10004);
		defaultS.setPIN(7890);
		defaultS.setSSN(890123456);
		defaultS.balance = 1000;

        ////checking default
        Checking defaultC;
		defaultC = this.searchCheckings(11111);
		defaultC.setPIN(5678);
		defaultC.setSSN(123456789);
		defaultC.balance = 300;
		defaultC = this.searchCheckings(11112);
		defaultC.setPIN(4567);
		defaultC.setSSN(234567890);
		defaultC.balance = 4000;
		defaultC = this.searchCheckings(11113);
		defaultC.setPIN(3456);
		defaultC.setSSN(345678901);
		defaultC.balance = 70;
		defaultC = this.searchCheckings(11114);
		defaultC.setPIN(2345);
		defaultC.setSSN(456789012);
		defaultC.balance = 5000;
	}

	void customerMenu(Account tmpAccnt){
        int accountNumber = tmpAccnt.getAccountNumber();
        tmpAccnt.validatePIN();
        if (!tmpAccnt.validate){
            System.out.println("input validation faild");
            return;
        }
        if (tmpAccnt.checking){
            Checking acc = super.searchCheckings(accountNumber);


                while (true){
                    System.out.println("(1) View Balance");
                    System.out.println("(2) View Last Deposited Amount");
                    System.out.println("(3) Deposit");
                    System.out.println("(4) Withdraw");
                    System.out.println("(5) Tranfer Funds to Another Account");
                    System.out.println("(6) Cancel");

                    choice = scanner.nextInt();

                if (choice == 1){
                    acc.Query();
                }
                if (choice == 2) {
                    acc.lastDepositAmount();
                }
                else if (choice == 3) {
                    acc.deposit();
                }
                else if (choice == 4) {
                    acc.withdraw();
                }
                else if (choice == 5) {
                    System.out.println("To-Account: ");
                    int toAcc = scanner.nextInt();
                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    acc.transfer(toAcc, amount);
                }
                else if (choice == 6) {
                    return;
                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
            }
        }else if (tmpAccnt.saving){
                Saving acc = super.searchSavings(accountNumber);

                while (true){
                    System.out.println("(1) View Balance");
                    System.out.println("(2) View Last Deposited Amount");
                    System.out.println("(3) Deposit");
                    System.out.println("(4) Withdraw");
                    System.out.println("(5) Tranfer Funds to Another Account");
                    System.out.println("(6) Cancel");

                    choice = scanner.nextInt();

                if (choice == 1){
                    acc.Query();
                }
                else if (choice == 2) {
                    acc.lastDepositAmount();
                }
                else if (choice == 3) {
                    acc.deposit();
                }
                else if (choice == 4) {
                    acc.withdraw();
                }
                else if (choice == 5) {
                    System.out.println("To-Account: ");
                    int toAcc = scanner.nextInt();
                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    acc.transfer(toAcc, amount);
                }
                else if (choice == 6) {
                    return;
                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
            }
        }else
               System.out.println("ERROR cutomer menue");

    }

    void staffMenue(){
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

        //verify Checking or Saving
        System.out.println("(1) Checking Account ");
        System.out.println("(2) Savings Account");
        this.choice = scanner.nextInt();

        super.addAccount(accountNumber, false);
        Account tmpAccnt1 = new Account();
        tmpAccnt1 = super.searchAccounts(accountNumber);
        //add SSN
        int SSN = 0;
        System.out.print("Enter 9 digit SSN: ");
        SSN = scanner.nextInt();
        System.out.println("New SSN number is: " + SSN);
        tmpAccnt1.setSSN(SSN);

        //add PIN
        System.out.print("Enter 4 digit PIN: ");
        int PIN = scanner.nextInt();
        System.out.println("New PIN number is: " + PIN);
        tmpAccnt1.setPIN(PIN);

        if(choice == 1){
            Checking tmpAccntC = new Checking();
            tmpAccntC = super.searchCheckings(accountNumber);
            //add SSN
            tmpAccntC.setSSN(SSN);

            //add PIN
            tmpAccntC.setPIN(PIN);


        }else if (choice == 2) {
            Saving tmpAccntS = new Saving();
            tmpAccntS = super.searchSavings(accountNumber);
            //add SSN
            tmpAccntS.setSSN(SSN);

            //add PIN
            tmpAccntS.setPIN(PIN);

        }else{
            System.out.println("ERROR bad choice");
            return;
        }

    }

    void removeAccount(){
        System.out.print("Enter account number: ");
        int accountNumber = this.scanner.nextInt();
        super.removeAccount(accountNumber);
    }


}


