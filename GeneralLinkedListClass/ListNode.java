public class ListNode<E> {
    public E data; // data stored in this node
    public ListNode next; // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode() {
        this(null, null);
    }

    // post: constructs a node with given data and given link
    public ListNode(E data) {
        this(data, null);
    }

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    // get methods
    public E getData() {
        return this.data;
    }

    public ListNode getNext() {
        return this.next;
    }

    // set methods
    public void setData(E data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
