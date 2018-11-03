package Accounts;

class Account{
    private int accountNumber, pin;
	public Account(int accountNumber, int pin, Account_Type accountType) {
        this.set_accountNumber(accountNumber);
        this.pin = pin;
	}

    int get_accountNumber(){
        return this.accountNumber;
    }
    int get_pin(){
        return this.pin;
    }

    void set_accountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    void set_pin(int pin){
        this.pin = pin;
    }

}

