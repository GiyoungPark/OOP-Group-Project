/*
 * Account.java
 * Copyright (C) 2018 Chase Meyer <chase.e.meyer@gmail.com>
 *
 * Distributed under terms of the GNU license.
 */

package Accounts;

enum Account_Type {
    Checking, Saving
}

class Account
{
    private int accountNumber, pin;
    private Account_Type accountType;
	public Account(int accountNumber, int pin, Account_Type accountType) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.Account_Type = accountType;
	}

    int get_accountNumber(){
        return this.accountNumber;
    }
    int get_pin(){
        return this.pin;
    }
    Account_Type get_accountType(){
        return this.accountType;
    }

    void set_accountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    void set_pin(int pin){
        this.pin = pin;
    }
    void set_accountType(Account_Type accountType){
        this.accountType = accountType;
    }

}

