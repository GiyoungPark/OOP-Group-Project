
public class Bank
{
    int size;
    Account head;
    Account tail;

	public Bank() {

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
            tmpAccnt2.setNext(tmpAccnt.getNext().getNext());
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
}

