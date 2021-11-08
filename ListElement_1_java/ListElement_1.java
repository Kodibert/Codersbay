public class ListElement_1 {
    Entry first;  //Pointer erstes Element
    Entry last;   //Pointer letztes Element

    public ListElement_1(Entry first, Entry last){
        this.first = first;
        this.last = last;

        this.first.next = null;
        this.last.prev = this.first;
    }
    public void add(Entry e){
        last.next = e; // An der letzten Stelle wird statt null mit last.next e eingetragen
        e.prev = last; // Nach dem hinzufügen wird das eingegebene Element wieder als last element deklariert
        last = e;
    }
    public Entry get(int i){
        Entry e = first;
       for(int j = 0; j < i; j++){
           e = e.next;
        }
    return e;
    }
    public int size(){
        int i = 0;
        Entry e = first;

        while(e != last){
            i++;
            e = e.next;
        }
return i+1;
    }


}
