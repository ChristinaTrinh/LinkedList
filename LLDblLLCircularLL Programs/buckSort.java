import java.util.*;

public class buckSort {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("This program sorts a LinkedList of type Node using the Bucket Sort method.");
        System.out.println("You will get to create your customized LinkedList and I will do the sorting task.");
        System.out.print("How long do you want the list to be? ");
        int length = console.nextInt();
        Node front = new Node();
        for (int i = 0; i < length; i++) {
            System.out.print("What number do you want to be on the list? ");
            Node add = new Node(console.nextInt());
            if (i == 0) // set the initial value as the head
                front = add;
            else {
                Node current = front;
                while (current.getNext() != null)
                    current = current.getNext();
                current.setNext(add); // add the value at the end
            }
        }
        printList(front); // print out the LinkedList before sorting
        BucketSort(front);
        printList(front); //// print out the LinkedList after sorting
    }

    public static void BucketSort(Node front) {
        boolean isContinue = true; // allows the loop to continue or stop
        int count = 0;

        // count the total elements of the LinkedList that was passed in
        int size = 0;
        Node countNodes = front;
        while (countNodes != null) {
            size++;
            countNodes = countNodes.getNext();
        }

        // declare and initialize the buckets array that we will put the values into
        Node[] buckets = new Node[10];
        for (int i = 0; i < 10; i++) // To fill the array with the ten base buckets.
            buckets[i] = new Node();

        // start the sorting process
        while (isContinue) {
            // putting the values of "front" into the appropriate index in the buckets array
            // Note: we will transfer from the buckets array back to the front later
            Node current = front;
            for (int i = 0; i < size; i++) {
                int digit = current.getValue() / (int) Math.pow(10, count) % 10;
                Node temp = buckets[digit];
                if (buckets[digit].getValue() == 0)
                    buckets[digit].setValue(current.getValue());
                else {
                    while (temp.getNext() != null)
                        temp = temp.getNext();
                    temp.setNext(new Node(current.getValue()));
                }
                current = current.getNext();
            }

            // transfer the values from the buckets array into the LinkedList
            // note: transfer each value will allow the memory address to stay stable
            // so I debugged the error existed before where I was trying to point the
            // LinkedList to the Nodes in the array. This will cause errors because we clean
            // up the buckets array eventually at the end of each loop
            Node temp1 = front;
            for (int i = 0; i < 10; i++) {
                if (buckets[i].getValue() != 0) {
                    Node temp2 = buckets[i];
                    while (temp2 != null) {
                        temp1.setValue(temp2.getValue());
                        temp2 = temp2.getNext();
                        temp1 = temp1.getNext();
                    }
                }
            }

            // check if the first element of buckets array contains all the Nodes of front
            // if so, it is sorted and we break out of the loop
            // same idea as the bucket sort that uses 2D array
            Node curr = buckets[0];
            int stopSize = 0;
            while (curr != null) {
                stopSize++;
                curr = curr.getNext();
            }
            if (stopSize == size) {
                isContinue = false;
                break;
            }

            // clear the buckets array before going to the next loop
            // set value of the first Node in each element to 0
            // set the next field to null
            for (int i = 0; i < 10; i++) {
                buckets[i].setNext(null);
                buckets[i].setValue(0);
            }
            count++;
        }
    }

    public static void printList(Node front) {
        if (front == null) {
            System.out.println("[]");
        } else {
            System.out.print("[" + front.getValue());
            Node current = front.getNext();
            while (current != null) {
                System.out.print(", " + current.getValue());
                current = current.getNext();
            }
            System.out.print("]");
        }
        System.out.println();
    }

}
