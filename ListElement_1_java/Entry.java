public class Entry {
    int value;
    Entry prev;  //Pointer previousEntry
    Entry next;  //Pointer nextEntry

    public Entry (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry getPrev() {
        return prev;
    }

    public void setPrev(Entry prev) {
        this.prev = prev;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
