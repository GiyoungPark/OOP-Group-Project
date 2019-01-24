// Daniel, Lora, GiYoung, Chase
import java.util.Scanner;

class Cust extends Bank
{
        boolean validate;
	Scanner sc = new Scanner(System.in);
        int menu = 0;

	void startMenu(Account tmpAccnt){
       int accountNumber = tmpAccnt.getAccountNumber();
       if (tmpAccnt.checking){
            Checking acc = super.searchCheckings(accountNumber);
            acc.validatePIN();

            if (validate = true){

                while (true){
                System.out.println("(1) View Balance");
                System.out.println("(2) View Last Deposited Amount");
                System.out.println("(3) Deposit");
                System.out.println("(4) Withdraw");
                System.out.println("(5) Tranfer Funds to Another Account");
                System.out.println("(6) Cancel");

                menu = sc.nextInt();

                if (menu == 1){
                    acc.Query();
                }
                if (menu == 2) {
                    acc.lastDepositAmount();
                }
                if (menu == 3) {
                    acc.deposit();
                }
                if (menu == 4) {
                    acc.withdraw();
                }
                if (menu == 5) {
                    System.out.println("To-Account: ");
                    int toAcc = sc.nextInt();
                    System.out.println("Amount: ");
                    double amount = sc.nextDouble();
                    acc.transfer(toAcc, amount);
                }
                if (menu == 6) {
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
                }
            }
       }else if (tmpAccnt.saving){
            Saving acc = super.searchSavings(accountNumber);
            acc.validatePIN();

            if (validate = true){

                while (true){
                System.out.println("(1) View Balance");
                System.out.println("(2) View Last Deposited Amount");
                System.out.println("(3) Deposit");
                System.out.println("(4) Withdraw");
                System.out.println("(5) Tranfer Funds to Another Account");
                System.out.println("(6) Cancel");

                menu = sc.nextInt();

                if (menu == 1){
                    acc.Query();
                }
                if (menu == 2) {
                    acc.lastDepositAmount();
                }
                if (menu == 3) {
                    acc.deposit();
                }
                if (menu == 4) {
                    acc.withdraw();
                }
                if (menu == 5) {
                    System.out.println("To-Account: ");
                    int toAcc = sc.nextInt();
                    System.out.println("Amount: ");
                    double amount = sc.nextDouble();
                    acc.transfer(toAcc, amount);
                }
                if (menu == 6) {
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                    return;
                }
                }
            }
       }else
           System.out.println("ERROR");

    }

}


