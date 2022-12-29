import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    private ListNode<E> front;

    // post: constructs an empty list
    public LinkedList() {
        front = null;
    }

    public ListNode<E> getFront() {
        return this.front;
    }

    public void setFront(ListNode<E> front) {
        this.front = front;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode<E> current = front;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    // pre: 0 <= index < size()
    // post: returns the value at the given index in the list
    public E get(int index) {
        return nodeAt(index).getData();
    }

    // pre: 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current = front;
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
            String result = "[" + front.getData();
            ListNode<E> current = front.getNext();
            while (current != null) {
                result += ", " + current.getData();
                current = current.getNext();
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the given value(-1 if
    // not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front;
        while (current != null) {
            if (current.getData() == value) {
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
    public boolean contains(E value) {
        ListNode<E> current = this.getFront();
        while (current != null) {
            if (current.getData() == value)
                return true;
            current = current.getNext();
        }
        return false;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        if (front == null) {
            front = new ListNode<E>(value);
        } else {
            ListNode<E> current = front;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ListNode(value));
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, E value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode<E> current = nodeAt(index - 1);
            current.setNext(new ListNode(value, current.getNext()));

        }
    }

    public void addAll(LinkedList<E> list) {
        this.addAll(this.size(), list);
    }

    // post: add the second list to the first list and empty the second list
    public void addAll(int index, LinkedList<E> list) {
        if (index == 0) { // special case if we add in index 0
            ListNode<E> temp = front;
            front = list.getFront();
            ListNode<E> current = this.nodeAt(this.size() - 1);
            current.setNext(temp);
        } else {
            ListNode<E> current = this.getFront();
            for (int i = 0; i < index - 1; i++)
                current = current.getNext();
            ListNode<E> temp = current.getNext(); // set the rest to temp so it doesn't lose
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
        } else if (index == size() - 1) {
            ListNode<E> current = nodeAt(size() - 2);
            current.setNext(null);
        } else {
            ListNode<E> current = nodeAt(index - 1);
            current.setNext(current.getNext().getNext());
        }
    }

    // pre: 0 <= index < size()
    // post: sets the list's element at that index to have the given value
    public void set(int index, E value) {
        ListNode<E> current = front;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(value);
    }

    // post: clear the LinkedList after the call to this method
    public void clear() {
        this.setFront(null);
    }

    // post: return true if and only if this list contains all elements in list
    // passed by parameter, and the elements need to be in order
    public boolean containsAll(List<E> list) {
        ListNode<E> currentThis = this.getFront(); // go over this list
        ListNode<E> currentList = list.getFront(); // go over the second lsit
        int count = 0; // if this count reaches the list size before exiting the loop then return true
                       // because this list contains all the given list
        while (currentThis != null) {
            if (currentThis.getData().equals(currentList.getData())) {
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
    public boolean equals(LinkedList<E> list) {
        if (this.size() != list.size())
            return false;
        ListNode<E> currentThis = this.getFront();
        ListNode<E> currentList = list.getFront();
        return this.containsAll(list);
    }

    // post: returns the index in the list of the last occurrence of that value
    // returns -1 if the value is not found in the list
    public int lastIndexOf(E value) {
        if (this.indexOf(value) == -1)
            return -1;
        else {
            int index = -1;
            ListNode<E> current = front;
            for (int i = 0; i < this.size(); i++) { // make the loop = list size so it loops through every node
                if (current.getData() == value) // if found the value then immediately return index
                    index = i;
                current = current.getNext();
            }
            return index;
        }
    }

    // post: removes the first occurence of the value given in the list
    public boolean remove(E value) {
        int index = this.indexOf(value);
        if (index == -1)
            return false;
        this.remove(index);
        return true;
    }

    // post: Removes from this list all of its elements that are contained in the
    // specified list
    public void removeAll(List<E> list) {
        ListNode<E> current = list.getFront();
        while (current != null) {
            while (this.contains(current.getData()))
                this.remove(current.getData());
            current = current.getNext();
        }
    }

    public void retainAll(List<E> list) {
        ListNode<E> current = this.getFront();
        for (int i = 0; i < this.size(); i++) {
            if (!list.contains(current.getData())) {
                this.remove(i);
                i--;
            }
            current = current.getNext();
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        ListNode<E> current = front;
        for (int i = 0; i < this.size(); i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }

}