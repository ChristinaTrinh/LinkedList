public interface List<E> {
    public int size();

    public ListNode<E> getFront();

    public void setFront(ListNode<E> front);

    public E get(int index);

    public int indexOf(E value);

    public boolean isEmpty();

    public boolean contains(E value);

    public void add(E value);

    public void add(int index, E value);

    public void addAll(LinkedList<E> other);

    public void addAll(int index, LinkedList<E> list);

    public void remove(int index);

    public void set(int index, E value);

    public void clear();

    public boolean containsAll(List<E> list);

    public boolean equals(Object o);

    public int lastIndexOf(E value);

    public boolean remove(E value);

    public void removeAll(List<E> list);

    public void retainAll(List<E> list);

    public Object[] toArray();

}
