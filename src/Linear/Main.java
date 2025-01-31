package Linear;

import Linear.LinkedLists.LinkedList;

public class Main {
    public static void main(String[] args) {
        var linkedList = new LinkedList();

        linkedList.addFirst(10); //A
        linkedList.addFirst(20); //B
        linkedList.addFirst(30); //C
        linkedList.addFirst(40); //D
        linkedList.addFirst(50); //E
//        linkedList.addFirst(60); //F

        linkedList.printMiddle();

    }
}
