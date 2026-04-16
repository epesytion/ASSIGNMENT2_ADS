public interface MyList<T> extends Iterable<T>{

    void add(T item); //stack heap
    void add(int index, T item);
    void addFirst(T item); //stack
    void addLast(T item); //stack
    T get(int index);
    T getFirst(); //stack
    T getLast(); //queue
    void remove(int index);
    void removeFirst(); //queue minHeap
    void removeLast(); //stack
    void sort(); //all
    int indexOf(Object object); //array
    int lastIndexOf(Object object); //stack queue
    boolean exists(Object object); //all
    public Object[] toArray(); //heap
    void clear(); //all
    int size(); //Stack queue heap

    boolean isEmpty();


    //stack - LIFO
    //queue - FIFO
}
