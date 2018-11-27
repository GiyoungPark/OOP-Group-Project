//import java.util.Scanner;

public class Bank
{
    int size;
    Account head, tail;
    Checking chead, ctail;
    Saving shead, stail;
    //Scanner scan = new Scanner(System.in);

	public Bank() {
		Saving temp;
		this.addAccount(10001, true);
		temp = this.searchSavings(10001);
		temp.setPIN(1234);
		temp.setSSN(567890123);
		temp.balance = 700;
		this.addAccount(10002, true);
		temp = this.searchSavings(10002);
		temp.setPIN(0123);
		temp.setSSN(234567890);
		temp.balance = 2000;
		this.addAccount(10003, true);
		temp = this.searchSavings(10003);
		temp.setPIN(6789);
		temp.setSSN(789012345);
		temp.balance = 9000;
		this.addAccount(10004, true);
		temp = this.searchSavings(10004);
		temp.setPIN(7890);
		temp.setSSN(890123456);
		temp.balance = 1000;		
	}
	//////////////////////Mehtods//////////////////////
    //boolean type determins type of accont 0 is checking, 1 is saving
	 void addAccount(int accountNumber,  boolean type) {
    	//Initialize new account
        if (type){
            Saving newAccount = new Saving();
            //Insert at the head of the list
            newAccount.setNext(shead);
            if (size != 0)
                shead.setPrev(newAccount);
            shead = newAccount;
            if (size == 0)
                stail = newAccount;

        }else {
            Checking newAccount = new Checking();
            //Insert at the head of the list
            newAccount.setNext(chead);
            if (size != 0)
                chead.setPrev(newAccount);
            chead = newAccount;
            if (size == 0)
                ctail = newAccount;

        }

        Account newAllAccount = new Account();
    	//Insert at the head of the list
        if (size != 0)
            head.setPrev(newAllAccount);
        head = newAllAccount;
        if (size == 0)
            tail = newAllAccount;

    	//Increment size
    	this.size++;
	 }

    void removeAccount(int accountNumber){
        Account tmpAccnt = searchAccounts(accountNumber);
        if (tmpAccnt.checking){
            Checking tmpAccntC = searchCheckings(accountNumber);
            // remove from head
            if (tmpAccntC == chead){
                chead = tmpAccntC.getNext();
                chead.setPrev(null);
                tmpAccntC = null;
            } else {
            // remove form body
                Checking tmpAccnt2 = searchCheckings(accountNumber);

                // check that temp is not Account before the tail Account
                if (tmpAccnt2 == tail) {
                    if (this.size != 1)
                        tail = tmpAccnt2.getPrev();
                    tmpAccnt2 = null;
                }
                // remove Account
                tmpAccnt2.setNext(tmpAccnt.getNext().getNext());		//should this be tmpAccnt2.setNext(tmpAccnt2.getNext().getNext()); ?
                if (tmpAccnt2.getNext() == null) {
                    tail = tmpAccnt2;
                } else {
                    tmpAccnt2 = tmpAccnt2.getNext();
                    tmpAccnt2.setPrev(tmpAccnt2.getPrev().getPrev());
                }
                tmpAccnt = null;
            }
            this.size--;
        } else if (tmpAccnt.saving){
            Saving tmpAccntS = searchSavings(accountNumber);
            // remove from head
            if (tmpAccntS == shead){
                shead = tmpAccntS.getNext();
                shead.setPrev(null);
                tmpAccntS = null;
            } else {
            // remove form body
                Saving tmpAccnt2 = searchSavings(accountNumber);
                // check that temp is not Account before the tail Account
                if (tmpAccnt2 == tail) {
                    if (this.size != 1)
                        tail = tmpAccnt2.getPrev();
                    tmpAccnt2 = null;
                }
                // remove Account
                tmpAccnt2.setNext(tmpAccnt.getNext().getNext());		//should this be tmpAccnt2.setNext(tmpAccnt2.getNext().getNext()); ?
                if (tmpAccnt2.getNext() == null) {
                    tail = tmpAccnt2;
                } else {
                    tmpAccnt2 = tmpAccnt2.getNext();
                    tmpAccnt2.setPrev(tmpAccnt2.getPrev().getPrev());
                }
                tmpAccnt = null;
            }
            this.size--;
        }

        // remove from head
        if (tmpAccnt == head){
            head = tmpAccnt.getNext();
            head.setPrev(null);
            tmpAccnt = null;
        } else {
        // remove form body
            Account tmpAccnt2 = new Account();

            // check that temp is not Account before the tail Account
            if (tmpAccnt2 == tail) {
                if (this.size != 1)
                    tail = tmpAccnt2.getPrev();
                tmpAccnt2 = null;
            }
            // remove Account
            tmpAccnt2.setNext(tmpAccnt.getNext().getNext());		//should this be tmpAccnt2.setNext(tmpAccnt2.getNext().getNext()); ?
            if (tmpAccnt2.getNext() == null) {
                tail = tmpAccnt2;
            } else {
                tmpAccnt2 = tmpAccnt2.getNext();
                tmpAccnt2.setPrev(tmpAccnt2.getPrev().getPrev());
            }
            tmpAccnt = null;
        }
        this.size--;

    }
    Saving searchSavings(int accountNumber) {
        Saving tmpAccnt = this.shead;
        while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
            tmpAccnt = tmpAccnt.getNext();
        }
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

        return tmpAccnt;
    }

    Checking searchCheckings(int accountNumber) {
        Checking tmpAccnt = this.chead;
        while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
            tmpAccnt = tmpAccnt.getNext();
        }
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);
        return tmpAccnt;
    }

    Account searchAccounts(int accountNumber) {
        Account tmpAccnt = new Account();
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tmpAccnt.getNext();
    	}
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

    	return tmpAccnt;
    }

}

