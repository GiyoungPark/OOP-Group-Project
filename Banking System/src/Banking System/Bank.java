// Daniel, Lora, GiYoung, Chase
//import java.util.Scanner;

class Bank
{
    int size;
    Account head;
    Checking chead;
    Saving shead;
    //Scanner scan = new Scanner(System.in);

	public Bank() {

	}
	//////////////////////Mehtods//////////////////////
    //boolean type determins type of accont 0 is checking, 1 is saving
	 void addAccount(int accountNumber,  boolean type) {
    	//Initialize new account
        if (type){
            Saving newAccount = new Saving(accountNumber);
            if (shead == null) {
                shead = newAccount;
            }else{
                //Insert at the head of the list
                newAccount.setNext(shead);
                shead.setPrev(newAccount);
                shead = newAccount;
            }

        }else {
            Checking newAccount = new Checking(accountNumber);
            if (chead == null) {
                chead = newAccount;
            }else{
                //Insert at the head of the list
                newAccount.setNext(chead);
                chead.setPrev(newAccount);
                chead = newAccount;
            }

        }

        Account newAllAccount = new Account(accountNumber);
        if (type){
            newAllAccount.saving = true;
        }else
            newAllAccount.checking = true;
        if (head == null) {
            head = newAllAccount;
        }else {
            //Insert at the head of the list
            newAllAccount.setNext(head);
            head.setPrev(newAllAccount);
            head = newAllAccount;
        }
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
                Checking tmpAccntP = tmpAccntC.getPrev();
                Checking tmpAccntN = tmpAccntC.getNext();
                tmpAccntP.setNext(tmpAccntN);
                tmpAccntN.setPrev(tmpAccntP);
                tmpAccntC = null;

            }
        } else if (tmpAccnt.saving){
            Saving tmpAccntS = searchSavings(accountNumber);
            // remove from head
            if (tmpAccntS == shead){
                shead = tmpAccntS.getNext();
                shead.setPrev(null);
                tmpAccntS = null;
            } else {
            // remove form body
                Saving tmpAccntP = tmpAccntS.getPrev();
                Saving tmpAccntN = tmpAccntS.getNext();
                tmpAccntP.setNext(tmpAccntN);
                tmpAccntN.setPrev(tmpAccntP);
                tmpAccntS = null;

            }
        }

        // remove from head
        if (tmpAccnt == head){
            head = tmpAccnt.getNext();
            head.setPrev(null);
        } else {
            // remove from head
            if (tmpAccnt == head){
                head = tmpAccnt.getNext();
                head.setPrev(null);
            } else {
            // remove form body
                Account tmpAccntP = tmpAccnt.getPrev();
                Account tmpAccntN = tmpAccnt.getNext();
                tmpAccntP.setNext(tmpAccntN);
                tmpAccntN.setPrev(tmpAccntP);
            }
        }
        tmpAccnt = null;
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
        Checking tmpAccnt = chead;
        if(chead == null)
        while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
            tmpAccnt = tmpAccnt.getNext();
        }
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);
        return tmpAccnt;
    }

    Account searchAccounts(int accountNumber) {
        Account tmpAccnt = this.head;
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tmpAccnt.getNext();
    	}
        if (tmpAccnt == null)
                System.out.println("Account Number not found: " + accountNumber);

    	return tmpAccnt;
    }

}
