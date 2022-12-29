public class Node {
    private Object myValue; // this is a pointer to an Object
    private Node next;

    /*** Constructor for objects of class Node */
    public Node() {
        myValue = null; // set default values
        next = null;
    }

    public Node(Object x) {
        myValue = x;
        next = null;
    }

    public void setNext(Node n) {
        next = n;
    }

    public void setMyValue(Object x) {
        myValue = x;
    }

    public void setMyValueObject(Object x) {
        myValue = x;
    }

    public Node getNext() {
        return next;
    }

    public String getMyValue() {
        return myValue.toString();
    }

    public Object getMyValueObject() {
        return myValue;
    }
}
