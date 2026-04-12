import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T item) {
        Object[] newArray = new Object[size];
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;

        }
        else {
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        MyNode newNode = new MyNode(item);

        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new RuntimeException("Empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new RuntimeException("Empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new RuntimeException("Empty");

        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;

        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new RuntimeException("Empty");

        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;

        size--;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                Comparable a = (Comparable) i.data;
                Comparable b = (Comparable) j.data;

                if (a.compareTo(b) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    public void print() {
        for (MyNode i = head; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }
        System.out.println();
    }
}