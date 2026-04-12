public class draft {
    static void main(String[] args) {
        MyLinkedList<Integer> queue = new MyLinkedList<>();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        System.out.println(queue.getFirst());
    }
}
