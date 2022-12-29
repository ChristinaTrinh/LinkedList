import java.util.*;

public class NumbersInOutDoubleLL {
    public static void main(String[] args) {
        int num, absDiff1, absDiff2;
        boolean deleted = false;
        DoubleLLNode head, add;
        DoubleLLNode current, next; // current, next, previous
        Scanner console = new Scanner(System.in);

        // Set head
        System.out.print("To start the DoubleLLNode list, enter a positive number: ");
        num = console.nextInt();
        head = new DoubleLLNode(num);

        System.out.print("\n Enter next k (0 to end input): ");
        num = console.nextInt();

        while (num != 0) {
            if (num > 0) { // add the value into the list in ascending order
                current = head;
                add = new DoubleLLNode(num);
                DoubleLLNode last = head;

                // find the last value of the list to know if we need to add at the last element
                int val = 0;
                while (last.getNext() != null) {
                    last = last.getNext();
                    val = last.getValue();
                }

                if (add.getValue() <= head.getValue()) { // take care of adding at front
                    add.setNext(head);
                    head = add;
                    add.getNext().setPrevious(add);
                } else if (add.getValue() >= val) { // take care of adding at the last one
                    last.setNext(add);
                    add.setPrevious(last);
                } else { // take care of the rest value that is being add in the middle
                    while (current != null && current.getValue() < num)
                        current = current.getNext();
                    add.setNext(current);
                    add.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(add);
                    current.setPrevious(add);
                }
            } else { // num < 0
                current = head;
                int temp = 0;
                while (current.getNext() != null) {
                    absDiff1 = Math.abs(current.getValue() - Math.abs(num));
                    absDiff2 = Math.abs(current.getNext().getValue() - Math.abs(num));
                    if (absDiff1 < absDiff2 || (deleted && absDiff1 > temp)) // if there is a tie or the appropriate
                                                                             // placement is detected then break
                        // out of the loop
                        break;
                    else if (absDiff1 == absDiff2) {
                        deleted = true;
                        temp = absDiff1;
                    } else
                        deleted = false;
                    current = current.getNext();
                }
                System.out.println(current.getValue());
                if (deleted) { // take care of if there is a tie - remove the one before current
                    if (current.getPrevious() == null) // if we remove the last element
                        head = null;
                    else if (current.getPrevious().getPrevious() == null) { // if we remove 2nd to last element
                        head = current;
                        current.setPrevious(null);
                    } else {
                        current.getPrevious().getPrevious().setNext(current);
                        current.setPrevious(current.getPrevious().getPrevious());
                        deleted = false;
                    }
                } else if (current.getNext() == null) { // if we remove the last element in the list
                    current.getPrevious().setNext(null);
                    current.setPrevious(null);
                } else if (current == head) { // if we remove the first element in the list
                    current.getNext().setPrevious(null);
                    head = current.getNext();
                } else { // normal cases fall here - remove the current
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
            } // k < 0

            System.out.print("\n\n\t The current DoubleLLNode list: ");
            for (next = head; next != null; next = next.getNext()) {
                System.out.print(next + ",  ");
            }
            System.out.println();

            System.out.print("\n Enter next number (0 to end input): ");
            num = console.nextInt();
        } // while (num != 0)
        System.out.println("Thanks for playing DoubleLLNode!!");
    }
}
