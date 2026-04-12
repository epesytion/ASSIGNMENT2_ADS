import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        ensureCapacity();
        array[size++] = item;
    }

    @Override
    public void add(T item) {

    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        ensureCapacity();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new RuntimeException("Empty");
        return (T) array[0];
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new RuntimeException("Empty");
        return (T) array[size - 1];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[--size] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty");
        array[--size] = null;
    }

    @Override
    public void sort() {
        // simple bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable a = (Comparable) array[j];
                Comparable b = (Comparable) array[j + 1];

                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = 0;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // needed for heap
    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        array[index] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void  print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}