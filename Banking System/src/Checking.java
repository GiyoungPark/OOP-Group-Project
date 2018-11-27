public class Checking extends Account {
    Checking next;
    Checking prev;

    Checking() {
        super.checking = true;
        next = null;
        prev = null;
    }
    void setNext(Checking next){
	    this.next = next;
    }
    Checking getNext(){
	    return this.next;
    }
    void setPrev(Checking prev){
	    this.prev = prev;
    }
    Checking getPrev(){
	    return this.prev;
    }
}
