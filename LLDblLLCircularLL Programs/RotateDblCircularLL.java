import java.util.*;

public class RotateDblCircularLL {
    public static void main(String[] args) {
        DoubleLLNode head = null, tail = null;
        Scanner console = new Scanner(System.in);
        System.out.print("How long is the list? ");
        int n = console.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("What number do you want to be on the list? ");
            DoubleLLNode add = new DoubleLLNode(console.nextInt());
            if (i == 0) // set the initial value as the head
                head = add;
            else {
                DoubleLLNode current = head;
                while (current.getNext() != null)
                    current = current.getNext();
                current.setNext(add); // add the value at the end
                add.setPrevious(current);
                if (i == (n - 1)) { // set the last value as the tail
                    tail = add; // if we are adding the last Node then we will point the tail to add
                    tail.setNext(head);
                    head.setPrevious(tail);
                }
            }
        }
        print(head, tail);
        System.out.println("Do you want to rotate?\n(a) Rotate\n(b) Quit"); // gives user 2 options
        System.out.print("Please type only the letter a or b: ");
        String isRotate = console.next(); // get the answer
        if (isRotate.toLowerCase().equals("a")) { // convert the input into lower case to avoid errors
            System.out.print("How much do you want to rotate? ");
            System.out.print(" (positive number means to rotate to the right and ");
            System.out.print("negative number means to rotate to the left) ");
            int rotateNum = console.nextInt();
            DoubleLLNode temp1 = head;
            DoubleLLNode temp2 = tail;
            for (int i = 0; i < Math.abs(rotateNum); i++) {
                if (rotateNum >= 0) { // take care of rotating to the right (head & tail move to the right)
                    temp1 = temp1.getNext();
                    temp2 = temp2.getNext();
                } else if (rotateNum < 0) { // take care of rotating to the left(head & tail move to the left)
                    temp1 = temp1.getPrevious();
                    temp2 = temp2.getPrevious();
                }
            }
            head = temp1;
            tail = temp2;
            print(head, tail);
        }
    }

    public static void print(DoubleLLNode head, DoubleLLNode tail) {
        DoubleLLNode current = head;
        if (current != null) { // print and count the first element because we want to print in nice format
            System.out.print(current.getValue());
            current = current.getNext();
        }
        while (current != null && current != head) { // print and count the rest
            System.out.print(", " + current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }
}
