import java.util.*;

public class RotateCircularLL {
    public static void main(String args[]) {
        Node head = null, tail = null;
        Scanner console = new Scanner(System.in);
        System.out.print("How long is the list? ");
        int n = console.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("What number do you want to be on the list? ");
            Node add = new Node(console.nextInt());
            if (i == 0) // set the initial value as the head
                head = add;
            else {
                Node current = head;
                while (current.getNext() != null)
                    current = current.getNext();
                current.setNext(add); // add the value at the end
                if (i == (n - 1)) { // set the last value as the tail
                    tail = add; // if we are adding the last Node then we will point the tail to add
                    tail.setNext(head); // create the circular loop
                }
            }
        }
        int size = printAndSize(head, tail); // get the size of the list for later use
        System.out.println("Do you want to rotate?\n(a) Rotate\n(b) Quit"); // gives user 2 options
        System.out.print("Please type only the letter a or b: ");
        String isRotate = console.next(); // get the answer
        if (isRotate.toLowerCase().equals("a")) { // convert the input into lower case to avoid errors
            System.out.print("How much do you want to rotate? ");
            System.out.print(" (positive number means to rotate to the right and ");
            System.out.print("negative number means to rotate to the left) ");
            int rotateNum = console.nextInt();
            Node temp1 = head;
            Node temp2 = tail;
            if (rotateNum >= 0) { // take care of rotating to the right (the head and tail move to the right)
                for (int i = 0; i < rotateNum; i++) {
                    temp1 = temp1.getNext();
                    temp2 = temp2.getNext();
                }
            } else if (rotateNum < 0) { // take care of rotating to the left (the head & tail move to the left)
                System.out.println("rotateNum " + rotateNum);
                for (int i = 1; i <= size - Math.abs(rotateNum); i++) { // this is a pattern if you draw it out
                    temp1 = temp1.getNext();
                    temp2 = temp2.getNext();
                }
            }
            head = temp1;
            tail = temp2;
            printAndSize(head, tail);
        }
    }

    public static int printAndSize(Node head, Node tail) { // this method also return the size of the list
        Node current = head;
        int count = 0;
        if (current != null) { // print and count the first element because we want to print in nice format
            count++;
            System.out.print(current.getValue());
            current = current.getNext();
        }
        while (current != null && current != head) { // print and count the rest
            System.out.print(", " + current.getValue());
            count++;
            current = current.getNext();
        }
        System.out.println();
        return count;
    }
}
