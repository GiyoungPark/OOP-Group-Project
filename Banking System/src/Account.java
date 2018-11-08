// Account - For verification gives 3 attempts Account # and PIN # (SSN ??)
// We need 4 functions - View Balance, Deposit, Withdraw, Transfer

static class Account {
    int accountNumber;
    Account next;
    Account prev;

    Account(){
        this.accountNumber = 0;
        this.next = null;
        this.prev = null;
    }

    int getAccountNumber(){
        return this.accountNumber;
    }

    Account getNext(){
        return this.next;
    }

    Account getPrev(){
        return this.prev;
    }

    void setNext(Account nextAccount){
        this.next = nextAccount;
    }

    void setPrev(Account prevAccount){
        this.prev = prevAccount;
    }

    void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

}

