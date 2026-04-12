public class MainStack {
    static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        System.out.println("Size: "+ arrayList.size());
        arrayList.addLast(6);
        arrayList.addLast(7);
        arrayList.addLast(9);
        arrayList.addLast(4);
arrayList.print();

arrayList.removeLast();
arrayList.print();

        MyStack stack2 = new MyStack();
        stack2.push(2);
        stack2.push(1);
        stack2.push(56);
        stack2.print();
        stack2.pop();
        stack2.print();















    }




    //0 1 2 3 4 5
}
