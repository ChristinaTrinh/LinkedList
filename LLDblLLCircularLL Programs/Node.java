public class Node {
    private Integer value;
    private Node next;

    public Node() {
        this(0, null);
    }

    public Node(Integer value) {
        this(value, null);
    }

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}