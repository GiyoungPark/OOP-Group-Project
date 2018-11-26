//import java.util.Scanner;

public class Bank
{
    int size;
    Checking chead, ctail;
    Saving shead, stail;
    //Scanner scan = new Scanner(System.in);

	public Bank() {

	}
	//////////////////////Mehtods//////////////////////
    //boolean type determins type of accont 0 is checking, 1 is saving
	 void addAccount(int accountNumber, int index, boolean type) {
    	//Input validation
    	if (index > size || index < 0) {
    		System.out.println("Invalid index");
    		return;
        }
    	//Initialize new account
        if (type){
            Saving newAccount = new Saving();
        }else {
            Checking newAccount = new Checking();
        }

    	//Insert at the head of the list
    	if (index == 0) {
            if (type)
                newAccount.setNext(shead);
            else
                newAccount.setNext(chead);
            if (size != 0)
                if (type)
                    shead.setPrev(newAccount);
                else
                    chead.setPrev(newAccount);
            if (type)
                shead = newAccount;
            else
                chead = newAccount;
            if (size == 0)
                if (type)
                    stail = newAccount;
                else
                    ctail = newAccount;
        }
    	//Insert anywhere else
    	else {
            if (type)
                Saving temp = shead;
            else
                Checking temp = chead;
            for(int i=0; i < index - 1; i++, temp = temp.getNext());
            newAccount.setNext(temp.getNext());
            temp.setNext(newAccount);
            newAccount.setPrev(temp);
            if(newAccount.getNext() == null)
                if (type)
                    stail = newAccount;
                else
                    ctail = newAccount;
            else {
                temp = newAccount.getNext();
                temp.setPrev(newAccount);
            }
        }
    	//Increment size
    	size++;
	 }

    void removeAccount(int accountNumber){
        Account tmpAccnt = searchAccounts(accountNumber);
        if (tmpAccnt.checking){
            Checking tmpAccnt = searchCheckings(accountNumber);
            Checking head = this.chead;
            Checking tail = this.ctail;
        } else if (tmpAccnt.saving){
            Saving tmpAccnt = searchSavings(accountNumber);
            Saving head = this.shead;
            Saving tail = this.stail;
        }

        // remove from head
        if (tmpAccnt == head){
            head = tmpAccnt.getNext();
            head.setPrev(null);
            tmpAccnt = null;
        } else {
        // remove form body
            if (tmpAccnt.checking){
                Checking tmpAccnt2 = new Checking();
                Checking tmpAccnt2 = searchCheckings(accountNumber);
            }else if (tmpAccnt.saving){
                Saving tmpAccnt2 = new Saving();
                Saving tmpAccnt2 = searchSavings(accountNumber);
            }else{
                System.out.println("ERROR");
                return;
            }

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
    Saving searchSavings(int accountNumber, boolean type) {
        if (type){
            Saving tmpAccnt = this.head;
        } else {
            Checking tmpAccnt = this.head;
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tmpAccnt.getNext();
    	}
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

    	return tmpAccnt;
    }
    Checking searchCheckings(int accountNumber, boolean type) {
        if (type){
            Saving tmpAccnt = this.head;
        } else {
            Checking tmpAccnt = this.head;
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tmpAccnt.getNext();
    	}
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

    	return tmpAccnt;
    }
    Account searchAccounts(int accountNumber, boolean type) {
        if (type){
            Saving tmpAccnt = this.head;
        } else {
            Checking tmpAccnt = this.head;
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tmpAccnt.getNext();
    	}
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

    	return tmpAccnt;
    }

}

