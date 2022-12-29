import java.util.*;

public class FirstSecondLargestSmallest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int n = console.nextInt();
        if (n == -1) {
            System.out.println(list);
            System.out.println("GOOD BYE!!!");
        } else {
            int L1 = n, L2 = n, S1 = n, S2 = n;
            while (n != -1) {
                if (n > L1) { // takes care of n greater than L1
                    L2 = L1;
                    L1 = n;
                } else if (n > L2) // takes care of n greater than L2 but less than L1
                    L2 = n;
                else if (n < S1) { // takes care of n less than S1
                    S2 = S1;
                    S1 = n;
                } else if (n < S2) // takes care of n less than S2 but greater than S1
                    S2 = n;
                Node current = list.getFront();
                int index = 0;
                while (current != null && current.getValue() < n) {
                    current = current.getNext();
                    index++;
                }
                list.add(index, n);
                System.out.println("Current list = " + list);
                System.out.println("L1 = " + L1 + ", L2 = " + L2 + ", S1 = " + S1 + ", S2 = " + S2);
                System.out.print("Enter a number: ");
                n = console.nextInt();
            }
        }
    }
}
