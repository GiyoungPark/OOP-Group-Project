import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Saving extends Account{
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar dateOpened;
    Saving next;
    Saving prev;
    int years;
    double intrest;

	public Saving() {
        this.saving = true;
        this.dateOpened = Calendar.getInstance();
        this.years = 0;
        this.intrest = 0.0;
	}

    void addInterest(){
        Calendar currentDate = Calendar.getInstance();
        years = currentDate.get(Calendar.YEAR) - dateOpened.get(Calendar.YEAR);
        this.intrest = Math.pow(1.05, this.years);
        this.balance += this.intrest;
    }

    void Query()
    {
       if (validate)
       {
           this.addInterest();
           System.out.println(" Your balance is " + this.balance);
       }
       else
       {
           System.out.println(" Maximum incorrect PIN attempted");
       }
    }

    void setYears(int years){
        this.years = years;
    }

    void setDateOpened(int year, int month, int day ){
        dateOpened.set(year,month,day);
    }

}

