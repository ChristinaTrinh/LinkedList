public class DoubleLLNode {
    private int value;
    private DoubleLLNode previous;
    private DoubleLLNode next;

    public DoubleLLNode() {
        this(0, null, null);
    }

    public DoubleLLNode(int value) {
        this(value, null, null);
    }

    public DoubleLLNode(int value, DoubleLLNode previous, DoubleLLNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public DoubleLLNode getPrevious() {
        return this.previous;
    }

    public DoubleLLNode getNext() {
        return this.next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrevious(DoubleLLNode previous) {
        this.previous = previous;
    }

    public void setNext(DoubleLLNode next) {
        this.next = next;
    }

    public String toString() {
        return "" + this.getValue();
    }

}
