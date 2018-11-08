
public class Bank
{
    int size;
    Account head;

	public Bank() {

	}

    void removeAccount(int accountNumber){
        Account tmpAccnt = searchAccounts(accountNumber);

        // if the account is at the tail of the list assign it to null
        if (tmpAccnt == this.head){
            head = tmpAccnt.getNext();
            tmpAccnt = null;
        }
        else if (tmpAccnt.getNext() == null) {
            tmpAccnt = null;
        }else {
            Account tmpAccnt2 = tmpAccnt;
            tmpAccnt.setNext(tmpAccnt.getNext().getNext());


}

