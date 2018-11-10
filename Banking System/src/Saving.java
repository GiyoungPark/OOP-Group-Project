
public class Saving extends Account{
    boolean saving;
    int years;

	public Saving() {
        this.savings = True;
        this.years = 0;
	}

    double addInterest(){
        this.balance = this.balance + Math.pow(1.05, this.years);
    }

    void setYears(int years){
        this.years = years;
    }

}

