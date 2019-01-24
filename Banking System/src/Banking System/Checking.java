// Daniel, Lora, GiYoung, Chase
public class Checking extends Account {
    Checking next;
    Checking prev;

    Checking() {
        super.checking = true;
        next = null;
        prev = null;
    }
    Checking(int accountNumber) {
        super.checking = true;
        super.accountNumber = accountNumber;
        next = null;
        prev = null;
    }
    void setNext(Checking next){
	    this.next = next;
    }
    Checking getNext(){
	    return this.next;
    }
    void setPrev(Checking prev){
	    this.prev = prev;
    }
    Checking getPrev(){
	    return this.prev;
    }

    /*
    boolean transfer(int accoutNumber, double amount){
         if (this.getAccountNumber() == accoutNumber){
             System.out.println("Account Number must be different from this account: " + this.accountNumber );
             return false;
         }
         Account accnt = new Account();
         // check if head
         if (accnt.getPrev() != null){
             //if not make head
             accnt = accnt.getPrev();
             while (accnt.getPrev() != null) {
                 accnt = accnt.getPrev();
             }

         } else {
             // set tmpAccnt value to next account and check that
             accnt = accnt.getNext();
         }
         // search for transfer account
         while (accnt.getAccountNumber() != accoutNumber || accnt == null){
             accnt = accnt.getNext();
         }
         if (accnt.saving){
             Saving tmpAccnt = new Saving();
             // check if head
             if (tmpAccnt.getPrev() != null){
                 //if not make head
                 tmpAccnt = tmpAccnt.getPrev();
                 while (tmpAccnt.getPrev() != null) {
                     tmpAccnt = tmpAccnt.getPrev();
                 }

             } else {
                 // set tmpAccnt value to next account and check that
                 tmpAccnt = tmpAccnt.getNext();
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
         }else if (accnt.checking){
             Checking tmpAccnt = new Checking();

             // check if head
             if (tmpAccnt.getPrev() != null){
                 //if not make head
                 tmpAccnt = tmpAccnt.getPrev();
                 while (tmpAccnt.getPrev() != null) {
                     tmpAccnt = tmpAccnt.getPrev();
                 }

             } else {
                 // set tmpAccnt value to next account and check that
                 tmpAccnt = tmpAccnt.getNext();
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
         }else
             System.out.println("ERROR unspecified account type");
         return false;
    }
    */
}
