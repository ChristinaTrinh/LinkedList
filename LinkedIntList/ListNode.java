public class ListNode {
    public int data; // data stored in this node
    public ListNode next; // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(int data) {
        this(data, null);
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    // get methods
    public int getData() {
        return this.data;
    }

    public ListNode getNext() {
        return this.next;
    }

    // set methods
    public void setData(int data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
