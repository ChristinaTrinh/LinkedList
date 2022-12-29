import java.util.NoSuchElementException;

public class LinkedList {
    private Node front;

    // post: constructs an empty list
    public LinkedList() {
        front = null;
    }

    public Node getFront() {
        return this.front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    // pre: 0 <= index < size()
    // post: returns the value at the given index in the list
    public Integer get(int index) {
        return nodeAt(index).getValue();
    }

    // pre: 0 <= i < size()
    // post: returns a reference to the node at the given index
    private Node nodeAt(int index) {
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.getValue();
            Node current = front.getNext();
            while (current != null) {
                result += ", " + current.getValue();
                current = current.getNext();
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the given value(-1 if
    // not found)
    public int indexOf(Integer value) {
        int index = 0;
        Node current = front;
        while (current != null) {
            if (current.getValue() == value) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    // post: return true if the LinkedList is empty, false otherwise
    public boolean isEmpty() {
        if (this.getFront() == null)
            return true;
        return false;
    }

    // post: return true if the LinkedList contains the value that is passed to
    // parameter, false otherwise
    public boolean contains(Integer value) {
        Node current = this.getFront();
        while (current != null) {
            if (current.getValue() == value)
                return true;
            current = current.getNext();
        }
        return false;
    }

    // post: appends the given value to the end of the list
    public void add(Integer value) {
        if (front == null) {
            front = new Node(value);
        } else {
            Node current = front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(value));
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, Integer value) {
        if (index == 0) {
            front = new Node(value, front);
        } else {
            Node current = nodeAt(index - 1);
            current.setNext(new Node(value, current.getNext()));
        }
    }

    public void addAll(LinkedList list) {
        this.addAll(this.size(), list);
    }

    // post: add the second list to the first list and empty the second list
    public void addAll(int index, LinkedList list) {
        if (index == 0) { // special case if we add in index 0
            Node temp = front;
            front = list.getFront();
            Node current = this.nodeAt(this.size() - 1);
            current.setNext(temp);
        } else {
            Node current = this.getFront();
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            Node temp = current.getNext(); // set the rest to temp so it doesn't lose
            current.setNext(list.getFront());
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp); // add the rest back to the "this"
            list.setFront(null);
        }
    }

    // pre: 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.getNext();
        } else {
            Node current = nodeAt(index - 1);
            current.setNext(current.getNext().getNext());
        }
    }

    // pre: 0 <= index < size()
    // post: sets the list's element at that index to have the given value
    public void set(int index, int value) {
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(value);
    }

    // post: clear the LinkedList after the call to this method
    public void clear() {
        this.setFront(null);
    }

    // post: return true if and only if this list contains all elements in list
    // passed by parameter, and the elements need to be in order
    public boolean containsAll(LinkedList list) {
        Node currentThis = this.getFront(); // go over this list
        Node currentList = list.getFront(); // go over the second lsit
        int count = 0; // if this count reaches the list size before exiting the loop then return true
                       // because this list contains all the given list
        while (currentThis != null) {
            if (currentThis.getValue().equals(currentList.getValue())) {
                count++;
                if (count == list.size())
                    return true;
                currentList = currentList.getNext();
            } else
                count = 0;
            currentThis = currentThis.getNext();

        }
        return false;

    }

    // post: returns true if and only if two lists are equal to each other, they
    // must have the same size in order to be considered equal
    public boolean equals(LinkedList list) {
        if (this.size() != list.size())
            return false;
        Node currentThis = this.getFront();
        Node currentList = list.getFront();
        return this.containsAll(list);
    }

    // post: returns the index in the list of the last occurrence of that value
    // returns -1 if the value is not found in the list
    public int lastIndexOf(Integer value) {
        if (this.indexOf(value) == -1)
            return -1;
        else {
            int index = -1;
            Node current = front;
            for (int i = 0; i < this.size(); i++) { // make the loop = list size so it loops through every node
                if (current.getValue() == value) // if found the value then immediately return index
                    index = i;
                current = current.getNext();
            }
            return index;
        }
    }

    // post: removes the first occurence of the value given in the list
    public boolean remove(Integer value) {
        int index = this.indexOf(value);
        if (index == -1)
            return false;
        this.remove(index);
        return true;
    }

    // post: Removes from this list all of its elements that are contained in the
    // specified list
    public void removeAll(LinkedList list) {
        Node current = list.getFront();
        while (current != null) {
            while (this.contains(current.getValue()))
                this.remove(current.getValue());
            current = current.getNext();
        }
    }

    public void retainAll(LinkedList list) {
        Node current = this.getFront();
        for (int i = 0; i < this.size(); i++) {
            if (!list.contains(current.getValue())) {
                this.remove(i);
                i--;
            }
            current = current.getNext();
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Node current = front;
        for (int i = 0; i < this.size(); i++) {
            array[i] = current.getValue();
            current = current.getNext();
        }
        return array;
    }
}