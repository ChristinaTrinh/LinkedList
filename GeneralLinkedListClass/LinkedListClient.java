public class LinkedListClient {
    public static void main(String[] args) {
        System.out.println("Testing addAll with the index method: ");
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        System.out.println("list1 before = " + list1.toString());
        System.out.println("list2 before = " + list2.toString());
        list1.addAll(1, list2);
        System.out.println("list1 after = " + list1.toString());
        System.out.println("list2 after = " + list2.toString());
        System.out.println();

        System.out.println("Testing addAll without the index method: ");
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        LinkedList<Integer> list4 = new LinkedList<Integer>();
        list4.add(5);
        list4.add(6);
        list4.add(7);
        list4.add(8);
        System.out.println("list3 before = " + list3.toString());
        System.out.println("list4 before = " + list4.toString());
        list3.addAll(list4);
        System.out.println("list3 after = " + list3.toString());
        System.out.println("list4 after = " + list4.toString());
        System.out.println();

        System.out.println("Testing containsAll method: ");
        LinkedList<Integer> list5 = new LinkedList<Integer>();
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.add(4);
        list5.add(5);
        LinkedList<Integer> list6 = new LinkedList<Integer>();
        list6.add(3);
        list6.add(4);
        list6.add(5);
        System.out.println("list5 = " + list5.toString());
        System.out.println("list6 = " + list6.toString());
        System.out.println("list5 contains all of list6: " + list5.containsAll(list6));
        System.out.println();

        System.out.println("Testing equals method: ");
        LinkedList<Integer> list7 = new LinkedList<Integer>();
        list7.add(3);
        list7.add(4);
        list7.add(5);
        LinkedList<Integer> list8 = new LinkedList<Integer>();
        list8.add(3);
        list8.add(4);
        list8.add(5);
        System.out.println("list7 = " + list7.toString());
        System.out.println("list8 = " + list8.toString());
        System.out.println("list7 equals to list8: " + list7.equals(list8));
        System.out.println();

        System.out.println("Testing removeAll method: ");
        LinkedList<Integer> list9 = new LinkedList<Integer>();
        list9.add(1);
        list9.add(2);
        list9.add(3);
        list9.add(2);
        list9.add(3);
        LinkedList<Integer> list10 = new LinkedList<Integer>();
        list10.add(3);
        list10.add(2);
        System.out.println("list9 before = " + list9.toString());
        System.out.println("list10 before = " + list10.toString());
        list9.removeAll(list10);
        System.out.println("list9 after = " + list9.toString());
        System.out.println("list10 after = " + list10.toString());
        System.out.println();

        System.out.println("Testing retainAll method: ");
        LinkedList<Integer> list11 = new LinkedList<Integer>();
        list11.add(1);
        list11.add(2);
        list11.add(3);
        list11.add(2);
        list11.add(3);
        LinkedList<Integer> list12 = new LinkedList<Integer>();
        list12.add(3);
        list12.add(2);
        System.out.println("list11 before = " + list11.toString());
        System.out.println("list12 before = " + list12.toString());
        list11.retainAll(list12);
        System.out.println("list11 after = " + list11.toString());
        System.out.println("list12 after = " + list12.toString());
        System.out.println();

        System.out.println("Testing toArray method: ");
        LinkedList<Integer> list13 = new LinkedList<Integer>();
        list13.add(1);
        list13.add(2);
        list13.add(3);
        list13.add(4);
        list13.add(5);
        System.out.print("The converted array = ");
        Object[] array = list13.toArray();
        System.out.print("{" + array[0]);
        for (int i = 1; i < array.length; i++)
            System.out.print(", " + array[i]);
        System.out.println("}");
    }
}
