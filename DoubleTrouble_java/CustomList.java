public class CustomList {

    public void append(int value) {
        ListNode new_node = new ListNode(value);
        new_node.nextElement = new_node.prevElement;
        new_node.prevElement = new_node.nextElement;
    }
    public void insertAtBeginning(int value) {
        ListNode new_node = new ListNode(value);
        new_node.prevElement = null;
        new_node.nextElement = new_node;
    }
    public ListNode getByValue(int value){
        return null;
    }
    public ListNode getByIndex(int index){
        return null;
    }
    public ListNode removeByValue(int value){
        return null;
    }
    public ListNode removeByIndex(int index){
        return null;
    }
}
