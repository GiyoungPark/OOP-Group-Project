// Account - For verification gives 3 attempts Account # and PIN # (SSN ??)
// We need 4 functions - View Balance, Deposit, Withdraw, Transfer

public class Account {
    int accountNumber;
    int PIN;
    int SSN;
    double balance;
    Account next;
    Account prev;

    Account(){
        this.accountNumber = 0;
        this.next = null;
        this.prev = null;
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

    //For Timer method we use (1.05)^n
}

