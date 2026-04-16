import java.util.ArrayList;

public class draft {
    static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyArrayList<Integer> list2 = new MyArrayList<Integer>();
        list2.addFirst(1);
        list2.addFirst(8);
        list2.addFirst(6);
        list2.addFirst(4);
        list2.print();
        list2.sort();
        list2.print();

    }
}
