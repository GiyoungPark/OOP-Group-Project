
public class Bank
{
    int size;
    Account head;
    Account tail;

	public Bank() {

	}
	//////////////////////Mehtods//////////////////////
	 void addAccount(int accountNumber, int index) {
    	//Input validation
    	if (index > size || index < 0) {
    		System.out.println("Invalid index");
    		return;
        }
    	//Initialize new account
    	Account newAccount = new Account();
    	
    	//Insert at the head of the list
    	if (index == 0) {
            newAccount.setNext(head);
            if (size != 0)
                head.setPrev(newAccount);
            head = newAccount;
            if (size == 0)
                tail = newAccount;
        }
    	//Insert anywhere else
    	else {
            Account temp = head;
            for(int i=0; i < index - 1; i++, temp = temp.getNext());
            newAccount.setNext(temp.getNext());
            temp.setNext(newAccount);
            newAccount.setPrev(temp);
            if(newAccount.getNext() == NULL)
                tail = newAccount;
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

        // remove from head
        if (tmpAccnt == this.head){
            head = tmpAccnt.getNext();
            head.setPrev(null);
            tmpAccnt = null;
        } else {
        // remove form body
            Account tmpAccnt2 = tmpAccnt.getPrev();
            // check that temp is not Account before the tail Account
            if (tmpAccnt2 == this.tail) {
                if (this.size != 1)
                    this.tail = tmpAccnt2.getPrev();
                tmpAccnt2 = null;
            }
            // remove Account
            tmpAccnt2.setNext(tmpAccnt.getNext().getNext());		//should this be tmpAccnt2.setNext(tmpAccnt2.getNext().getNext()); ?
            if (tmpAccnt2.getNext() == null) {
                this.tail = tmpAccnt2;
            } else {
                tmpAccnt2 = tmpAccnt2.getNext();
                tmpAccnt2.setPrev(tmpAccnt2.getPrev().getPrev());
            }
            tmpAccnt = null;
        }
        this.size--;
    }
	// we need error handle i.e incorrect account #
	// Search Function
    Account searchAccounts(int accountNumber) {
        Account tmpAccnt = this.head;
    	while (tmpAccnt != null && tmpAccnt.getAccountNumber() != accountNumber) {
        	tmpAccnt = tempAccnt.getNext();
    	}
    	return tmpAccnt;
    }

}

