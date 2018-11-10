// Account - For verification gives 3 attempts Account # and PIN # (SSN ??)
// We need 4 functions - View Balance, Deposit, Withdraw, Transfer
import java.util.Scanner;

public class Account {
    int accountNumber;
    int PIN;
    int SSN;
    boolean validate = false;
    double balance;
    Account next;
    Account prev;

    Account(){
        this.accountNumber = 0;
        this.next = null;
        this.prev = null;
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
       if (ValidatePIN)
       {
           System.out.println(" Your balance is " + balance);
       }

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

