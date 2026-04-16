public class MyHeap {
    private MyArrayList<Integer> heap = new MyArrayList<>();

    public void add(int val) {
        heap.addLast(val);
        heapifyUp(heap.size() - 1);
    }

    public int getMin() {
        return heap.get(0);
    }

    public int removeMin() {

        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();

        heapifyDown(0);
        return min;
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;

        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}