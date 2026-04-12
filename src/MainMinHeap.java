public class MainMinHeap {
    static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.add(1);
        myHeap.add(2);
        myHeap.add(3);
        myHeap.add(4);
        System.out.println(myHeap.getMin());
    }
}
