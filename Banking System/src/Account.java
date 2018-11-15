// Account - For verification gives 3 attempts Account # and PIN # (SSN ??)
// We need 4 functions - View Balance, Deposit, Withdraw, Transfer
import java.util.Scanner;

public class Account {
    int accountNumber;
    int PIN;
    int SSN;
    boolean validate = false;
    double balance;
    double lastDeposit = 0;
    Account next;
    Account prev;

    Account(){
        this.accountNumber = 0;
        this.next = null;
        this.prev = null;
    }


    void deposit() {

     Scanner scan = new Scanner(System.in);
     System.out.println("Deposit amount: ");
     amount = scan.nextDouble();
        
            if (amount <= 0.0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount or 0 ");
            }

            balance = (balance + amount);
            lastDeposit = amount;
     }
    
    void withdraw() {

     Scanner scan = new Scanner(System.in);
     System.out.println("withdraw amount : ");
     amount = scan.nextDouble();
            

            if (amount <= 0.0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount or 0 ");
            }
            if (amount > balance) {
                throw new IllegalStateException("Cannot overdraw an account");
            }

            balance = (balance - amount);
     }
        
     void lastDepositAmount() {
             
             System.out.println("Last Deposit Amount: " + lastDeposit);
            
     }
       
        

    void validatePIN() {
        Scanner sc = new Scanner(System.in);
        int trys = 0

        while (true){
            int askPIN = sc.nextInt();
            if (askPIN == PIN){
                validatePIN = true;
                break;
            }
            if (askPIN != PIN){
               String.out.println("Wrong PIN");
               trys++;
            }
            if (trys > 3)
                validatePIN = false
                break;
        }

    void Query( double balance)  
    {
       if (validate)
       {
           System.out.println(" Your balance is " + balance);
       }
       else
       {
           System.out.println(" Maximum incorrect PIN attempted");
       }
    }
      boolean transfer(int accoutNumber, double amount){
         if (this.getAccountNumber() == accoutNumber){
             System.Out.println("Account Number must be different from this account: " + this.accountNumber );
             return false
         }
         Account tmpAccnt = new Account();

         // check if we are head
         if (this.getPrev() != null){
             //if not make us head
             tmpAccnt = this.getPrev();
             while (tmpAccnt.getPrev() != null) {
                 tmpAccnt = tmpAccnt.getPrev();
             }

         } else {
             // set tmpAccnt value to ouselves
             tmpAccnt = getNext();
         }
         // search for transfer account
         while (tmpAccnt.getAccountNumber() != accoutNumber || tmpAccnt == null){
             tmpAccnt = tmpAccnt.getNext();
         }

         if (amount >= this.balance){
             System.out.println("Error: Transfer amount: $" + amount " is greater than account balance: $" this.balance);
             return false;
         }
         this.balance -= amount;
         tmpAccnt.balance += amount;

         System.out.println("Amount of : $" amount " transfered to " + accoutNumber);
         System.out.println("New balance of: $" this.balance);
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


    //For Timer method we use (1.05)^n
}

