// Daniel, Lora, GiYoung, Chase
// Account - For verification gives 3 attempts Account # and PIN # (SSN ??)
// We need 4 functions - View Balance, Deposit, Withdraw, Transfer
import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {
    int accountNumber;
    int PIN;
    int SSN;
    boolean validate = false;
    boolean checking = false;
    boolean saving = false;
    double balance;
    double lastDeposit = 0;
    Account next;
    Account prev;
    DecimalFormat df = new DecimalFormat("#.##");
    /* do we give variables here? (gave me build errors without those)
    double amount;
    boolean validatePIN; */

    Account(){
        this.accountNumber = 0;
        this.next = null;
        this.prev = null;
    }
    Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.next = null;
        this.prev = null;
    }


    void deposit() {

     Scanner scan = new Scanner(System.in);
     System.out.println("Deposit amount: ");
     double amount = scan.nextDouble();

            if (amount <= 0.0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount or 0 ");
            }

            balance = (balance + amount);
            lastDeposit = amount;
     }

    void withdraw() {

     Scanner scan = new Scanner(System.in);
     System.out.println("withdraw amount : ");
     double amount = scan.nextDouble();


            if (amount <= 0.0) {
                throw new IllegalArgumentException("Cannot withdraw a negative amount or 0 ");
            }
            if (amount > balance) {
                throw new IllegalStateException("Cannot overdraw an account");
            }

            balance = (balance - amount);
     }

     void lastDepositAmount() {

             System.out.println("Last Deposit Amount: $ " + df.format(lastDeposit));

     }



    void validatePIN() {
        Scanner sc = new Scanner(System.in);
        int trys = 0;
        System.out.println(PIN);
        while (true){
            System.out.println("Enter PIN: ");
            int askPIN = sc.nextInt();
            if (askPIN == PIN){
                validate = true;
                break;
            }
            if (askPIN != PIN){
               System.out.println("Wrong PIN");
               trys++;
            }
            if (trys > 3)
                validate = false;
                break;
        }
    }

    void Query()
    {
       System.out.println(" Your balance is $ " + df.format(this.balance));
    }
  boolean transfer(int accoutNumber, double amount){
         if (this.getAccountNumber() == accoutNumber){
             System.out.println("Account Number must be different from this account: " + this.accountNumber );
             return false;
         }
         Account tmpAccnt = new Account();

         // check if head
         if (this.getPrev() != null){
             //if not make head
             tmpAccnt = this.getPrev();
             while (tmpAccnt.getPrev() != null) {
                 tmpAccnt = tmpAccnt.getPrev();
             }

         } else {
             // set tmpAccnt value to next account and check that
             tmpAccnt = getNext();
         }
         // search for transfer account
         while (tmpAccnt.getAccountNumber() != accoutNumber || tmpAccnt == null){
             tmpAccnt = tmpAccnt.getNext();
         }

         if (amount >= this.balance){
             System.out.println("Error: Transfer amount: $" + df.format(amount) +" is greater than account balance: $"+ df.format(this.balance));
             return false;
         }
         this.balance -= amount;
         tmpAccnt.balance += amount;

         System.out.println("Amount of : $"+ df.format(amount) +" transfered to " + accoutNumber);
         System.out.println("New balance of: $"+ df.format(this.balance));
         return true;
     }

    int getAccountNumber(){
        return this.accountNumber;
    }

    Account getNext(){
        return this.next;
    }

    Account getPrev(){
        return this.prev;
    }

    void setNext(Account nextAccount){
        this.next = nextAccount;
    }

    void setPrev(Account prevAccount){
        this.prev = prevAccount;
    }

    void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    void setPIN(int PIN){
        this.PIN = PIN;
    }

    void setSSN (int SSN){
        this.SSN = SSN;
    }
    //For Timer method we use (1.05)^n
}

