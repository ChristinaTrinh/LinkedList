import java.util.NoSuchElementException;

//Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList implements IntList {
    private ListNode front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    public ListNode getFront() {
        return this.front;
    }

    public void setFront(ListNode front) {
        this.front = front;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = this.getFront();
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    // pre: 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.getNext();
            while (current != null) {
                result += ", " + current.data;
                current = current.getNext();
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the given value(-1 if
    // not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = this.getFront();
        while (current != null) {
            if (current.getData() == value) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = this.getFront();
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ListNode(value));
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.setNext(new ListNode(value, current.getNext()));
        }
    }

    // pre: 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.getNext();
        } else {
            ListNode current = nodeAt(index - 1);
            current.setNext(current.getNext().getNext());
        }
    }

    // pre: 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = this.getFront();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    // Exercise #1
    // pre: 0 <= index < size()
    // post: sets the list's element at that index to have the given value
    public void set(int index, int value) {
        ListNode current = this.getFront();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(value);
    }

    // Exercise #2
    // post: returns the minimum value in a list of integer.
    // Throes NoSuchElementException if the list is empty
    public int min() {
        if (this.size() == 0) {
            throw new NoSuchElementException(); // if the list is empty
        } else {
            ListNode current = this.getFront();
            int minimum = current.getData();
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getData() < minimum) {
                    minimum = current.getData(); // if found the smaller value, then set = min
                }
            }
            return minimum;
        }
    }

    // Exercise #3
    // post: returns true if the list is in sorted(nondecreasing) order and returns
    // false otherise. An empty list is considered to be sorted
    public boolean isSorted() {
        if (this.size() == 0)
            return true;
        else {
            ListNode current = this.getFront();
            int num = current.getData();
            while (current.getNext() != null) {
                current = current.getNext(); // get the next one to compare to the last one
                if (current.getData() < num)
                    return false;
                num = current.getData();
            }
            return true;
        }
    }

    // Exercise #4
    // post: returns the index in the list of the last occurrence of that value
    // returns -1 if the value is not found in the list
    public int lastIndexOf(int value) {
        if (this.indexOf(value) == -1)
            return -1;
        else {
            int index = -1;
            ListNode current = this.getFront();
            for (int i = 0; i < this.size(); i++) { // make the loop = list size so it loops through every node
                if (current.getData() == value) // if found the value then immediately return index
                    index = i;
                current = current.getNext();
            }
            return index;
        }
    }

    // Exercise #5
    // pre: the list is in sorted order
    // post: returns the number of duplicates in a sorted list
    public int countDuplicates() {
        if (this.size() == 0)
            return 0;
        else {
            int count = 0;
            ListNode current = this.getFront();
            int currNumber = current.getData();
            int currDuplicate = 0;
            while (current.getNext() != null) {
                current = current.getNext();
                if (current.getData() == currNumber)
                    currDuplicate++;
                else {
                    count += currDuplicate;
                    currNumber = current.getData();
                    currDuplicate = 0;
                }
            }
            count += currDuplicate; // there is still duplicate that wasn't counted because the loop terminates too
                                    // early so we add that at the end before returning
            return count;
        }
    }

    // Exercise #6
    // post: returns whether or not a lost of integers has two adjacent numbers that
    // are consecutive integers (true if such a pair exists and false otherwise)
    // [7,8] is considered a consecutive pair while [7,9] is not
    public boolean hasTwoConsecutive() {
        if (this.size() <= 1)
            return false;
        else {
            ListNode current = this.getFront();
            while (current != null) {
                int currNumber = current.getData();

                // make sure the next node is not null before comparing
                if (current.next != null && (currNumber + 1) == current.getNext().getData())
                    return true;
                current = current.getNext();
            }
            return false;
        }
    }

    // Exercise #7
    // post: deletes the last value (the value at the back of the list)
    // returns the deleted value. Throws NoSuchElementException if list is empty
    public int deleteBack() {
        if (this.size() == 0)
            throw new NoSuchElementException();
        else {
            ListNode current = this.getFront();
            for (int i = 1; i < this.size() - 1; i++) {
                current = current.getNext();
            }
            int value = current.getNext().getData();
            current.setNext(null); // delete the last node by setting it equals to null
            return value;
        }
    }

    // Exercise #8
    // post: switches the order of values in the list in a pairwise fashion
    public void switchPairs() {
        ListNode current = this.getFront();
        int temp = current.getData();
        while (current.getNext() != null) {
            current.setData(current.getNext().getData());
            current.getNext().setData(temp);
            current = current.getNext().getNext();
            temp = current.getData();
        }
    }

    // Exercise #9
    // post: doubles the size of a list by replacing every integer in the list with
    // two of that integer
    public void stutter() {
        ListNode current = this.getFront();
        ListNode temp = this.getFront(); // this is used to create new list node and later connect to current
        while (current != null) {
            temp.setNext(new ListNode(current.getData(), current.getNext())); // create a new listnode for temp
            current = temp; // connect with current
            current = current.getNext().getNext();
            temp = temp.getNext().getNext();
        }
    }

    // Exercise #10
    // post: increases a list of integers by a factor of n by replacing each integer
    // in the original list with n copies of that integer
    // if n is 0 or negatice, the list should become empty
    public void stretch(int n) {
        if (n <= 0)
            front = null;
        else {
            ListNode current = this.getFront();
            ListNode temp = this.getFront();
            while (current != null) {
                for (int i = 1; i < n; i++) { // 1 of them already existed, so we only add 1 less than n
                    temp.setNext(new ListNode(current.getData(), current.getNext()));
                    current = temp;
                    temp = temp.getNext();
                    current = current.getNext();
                }
                current = current.getNext();
                temp = temp.getNext();
            }
        }
    }

    // Exercise #11
    // post: replaces every pair of elements in the list with a single element equal
    // to the sum of the pair. If the list if of odd size, leave the last element
    // unchanged
    public void compress() {
        ListNode current = this.getFront();
        while (current.getNext() != null) {
            int total = current.getData() + current.getNext().getData();
            current.setData(total);
            current.setNext(current.getNext().getNext());
            current = current.getNext();
        }
    }

    // Exercise #12
    // post: rearranges the elements of the a list so that all of the negative
    // values appear before all of the nonnegatives
    public void split() {
        ListNode current = front;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData() < 0) {
                ListNode temp = current.getNext();
                current.setNext(current.getNext().getNext());
                temp.setNext(this.getFront());
                front = temp;
                temp = null;
            } else {
                current = current.getNext();
            }
        }
    }

    // Exercise #13
    // pre: either of the two lists could be empty. Neither list is null
    // post: moves values from the second list to this list
    public void transferFrom(LinkedIntList list1) {
        ListNode current1 = this.getFront();
        while (current1.getNext() != null) {
            current1 = current1.getNext();
        }
        current1.setNext(list1.getFront());
        list1.setFront(null);
    }

    // Exercise #14
    // post: removes all occurrences of a particular value
    public void removeAll(int value) {
        ListNode current = front;
        int size = this.size();
        for (int i = 0; i < size; i++) {
            if (current.getData() == value) {
                remove(i);
                i--;
                size--;
            }
            current = current.getNext();
        }

    }

    // Exercise #15
    // post: returns true of the two lists are equal, and returns false otherwise
    public boolean equals(LinkedIntList list2) {
        if (this.size() != list2.size())
            return false;
        else {
            ListNode currentList1 = this.getFront();
            ListNode currentList2 = list2.getFront();
            while (currentList1 != null && currentList2 != null) {
                if (currentList1.getData() != currentList2.getData())
                    return false;
                currentList1 = currentList1.getNext();
                currentList2 = currentList2.getNext();
            }
            return true;
        }
    }

    // Exercise #16
    // post: removes the values in even-numbered indexes from a list, returns new
    // list that contains those values in their original order
    public LinkedIntList removeEvens() {
        LinkedIntList list2 = new LinkedIntList();
        int size = this.size();
        list2.setFront(this.getFront());
        ListNode curr1 = this.getFront();
        ListNode curr2 = list2.getFront();
        this.setFront(curr1.getNext());
        curr1 = curr1.getNext();
        for (int i = 1; i < size - 1; i += 2) {
            curr2.setNext(curr1.getNext());
            curr2 = curr2.getNext();
            curr1.setNext(curr2.getNext());
            curr1 = curr1.getNext();
            curr2.setNext(null);
        }
        return list2;
    }

    // Exercise #17
    // pre: 0 <= start <= end < size
    // post: removes the elements at a given range of indexes.
    // Throws IllegalArgumentException of either of the positions is negative
    public void removeRange(int start, int end) {
        ListNode startNode = nodeAt(start - 1);
        ListNode endNode = nodeAt(end + 1);
        startNode.setNext(endNode);
    }

    // Exercise #18
    // post: doubles the size of a list by appending a copy of the original sequence
    // to the end of the list
    // Run in O(N) time where N is the number of nodes in the list
    public void doubleList() {
        ListNode current = front;
        ListNode temp = new ListNode(current.getData());
        current = current.getNext();
        ListNode ctemp = temp;
        while (current.next != null) {
            ctemp.setNext(new ListNode(current.getData()));
            current = current.getNext();
            ctemp = ctemp.getNext();
        }
        ctemp.setNext(new ListNode(current.getData()));
        current.setNext(temp);
    }

    // Exercise #19
    // post: moves the value at the front of a list of integers to the end of the
    // list
    public void rotate() {
        ListNode temp = this.getFront();
        this.setFront(front.getNext());
        ListNode current = this.getFront();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        current.getNext().setNext(null);
    }

    // Exercise #20
    // post: rearranges the elements of a list of integers by moving to the end of
    // the list all values that are in odd-numbered positions and otherwise
    // preserving order
    public void shift() {
        ListNode current = this.getFront();
        int size = this.size();
        for (int i = 1; i <= size / 2; i++) {
            ListNode temp = nodeAt(i);
            current.setNext(temp.getNext());
            temp.setNext(null);
            this.nodeAt(size - 2).setNext(temp);
            current = current.getNext();
        }
    }

    // Exercise #20
    // post: reverses the order of the elements in the list
    public void reverse() {
        ListNode prev = null;
        ListNode current = front;
        ListNode temp;
        while (current != null) {
            temp = current.getNext();
            current.setNext(prev);
            prev = current;
            front = current;
            current = temp;
        }

    }
}