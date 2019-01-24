// Daniel, Lora, GiYoung, Chase
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DecimalFormat;

public class Saving extends Account{
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar dateOpened;
    Saving next;
    Saving prev;
    int years;
    double intrest;
    DecimalFormat df = new DecimalFormat("#.##");

	public Saving() {
        this.saving = true;
        this.dateOpened = Calendar.getInstance();
        this.years = 0;
        this.intrest = 0.0;
	}

	public Saving(int accountNumber) {
        super.accountNumber = accountNumber;
        this.saving = true;
        this.dateOpened = Calendar.getInstance();
        this.years = 0;
        this.intrest = 0.0;
	}
    void addInterest(){
        Calendar currentDate = Calendar.getInstance();
        years = currentDate.get(Calendar.YEAR) - dateOpened.get(Calendar.YEAR);
        for(int i = 1; i <= this.years; i++){
            this.intrest = .05 * this.balance;
            this.balance += this.intrest;
        }
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

    void Query()
    {
       this.addInterest();
       System.out.println(" Your balance is $ " + df.format(this.balance));
       System.out.println(" Interest earned is $ " + df.format(this.intrest));
    }

    void setYears(int years){
        this.years = years;
        dateOpened.set(Calendar.YEAR, years);
    }

    void setDateOpened(int year, int month, int day ){
        dateOpened.set(year,month,day);
    }
    void setNext(Saving next){
	    this.next = next;
    }
    Saving getNext(){
	    return this.next;
    }
    void setPrev(Saving prev){
	    this.prev = prev;
    }
    Saving getPrev(){
	    return this.prev;
    }
}
