package Linear.LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    /*
    * Linked Lists:
    *   We use linked list to store a list of objects in a sequence.
    *   They can grow and shrink automatically
    *
    *   They consist of a group of nodes in a sequence. Each node holds 2 pieces of data
    *       - Value
    *       - Reference to the address of the next node
    *
    *           Head                  Node A           Node B (tail)
    *   [10 | Node A address] -> [20|Node B address ] -> [30| ]
    *
    *
    *
    * */

    private Node head;
    private Node tail;
    private int count;

    private static class Node {
        //Attributes
        private int value;
        private Node next; //Keep a reference to the next node
        //Constructor
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [" +
                    "value=" + value +
                    ", next=" + next +
                    " ]";
        }
    }

    /**
     * @param value we wish to save in the LinkedList
     * */
    public void addFirst(int value) {
        //Create a new node
        var newNode = new Node(value);

        //If the LinkedList is empty, set the current node to Head and Tail
        if (isEmpty())
            head = tail = newNode;

        //Otherwise, link the new Node to the current head and then set it as the new Head
        else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    /**
     * @param value we wish to save in the LinkedList
     * */
    public void addLast(int value) {
        //Create a new Node
        var newNode = new Node(value);

        //If the LinkedList is empty, set the New Node as Head and Tail
        if (isEmpty())
            head = tail = newNode;

        else {
            //Link the newNode at the end of the LinkedList
            tail.next = newNode;
            //Set the newNode as the newTail
            tail = newNode;
        }
        count++;
    }

    /**
     * Remove the first node in the LinkedList
     * */
    public void removeFirst() {
        //Verify if the node is empty. If it is return an exception
        if(isEmpty())
            throw new NoSuchElementException("List is empty");

        //Verify if the LinkedList has a single item:
        if (containsOneItem())
            head = tail = null;
        else {
            //Save a reference of the new Head
            var newHead = head.next;
            //Detach the current Head. Java garbage collector will understand that this node is no longer being used and remove it from memory
            head.next = null;
            //Set the new Head
            head = newHead;
        }

        count--;
    }

    /**
     * removes the last node in the LinkedList
     * */
    public void removeLast() {
        //Verify if the LinkedList is empty
        if (isEmpty())
            throw new NoSuchElementException("List is empty");

        //Verify if the list has a single item
        if (containsOneItem())
            head = tail = null;
        else {
            //Traverse the list until the node before the Tail is reached Have Tail pointing to newTail
            tail = getPrevious(tail);

            //Remove the previous tail
            assert tail != null;
            tail.next = null;

        }
        count--;
    }

    /**
     * @param value to be searched in the LinkedList
     * @return true if the value exists or false if it does not
    * */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    /**
     * @param value we wish to search in the LinkedList
     * @return index of the targeted value or -1 if the value does not exist in the LinkedList
     * */
    public int indexOf(int value) {
        //Verify if the LinkedList is empty
        if(isEmpty())
            throw new NoSuchElementException("List is empty");

        var index = 0;
        //Iterate over the LinkedList until the target value is found
        var currentNode = head;
        while(currentNode != null) {
            if(currentNode.value == value)
                return index;

            index++;
            currentNode = currentNode.next;
        }

        return -1;
    }

    /**
     * @return the number of items in the LinkedList
    * */
    public int size() {
        return count;
    }

    public int[] toArray() {
        int[] array = new int[count];
        int index = 0;
        var currentNode = head;

        while(currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    /**
     * Reverse the direction of the links inside the LinkedList
    * */
    public void reverse() {

        if(isEmpty() || head == tail)
            return;

        var newTail = head;
        var current = head.next;
        var next = current.next;
        while(next != null ) {
            //Switch: Set the current Head as the next Node of current
            current.next = head;

            //Advance: Shift all node reference to the right
            head = current;
            current = next;
            next = current.next;
        }
        //Set Head
        current.next = head;
        head = current;

        //Set tail:
        newTail.next = null;
        tail = newTail;
    }

    /**
     * * Find the Kth node from the end of a linked list in one pass
     *  Most LinkedList problems can be solved using 2 pointers referencing Nodes in the LinkedList:
     *  - We move both pointers forward simultaneously until the second pointer reaches the end of our list
     *  - At this point we can use the first pointer to find the targeted node
     *  - Both pointers should be positioned properly, so they should not be too close or far apart. So when the second pointer reaches the end
     *      the first pointer will be precisely at the target node.
     */
    public int getKthFromEnd(int k) {

        if(isEmpty())
            throw new NoSuchElementException("List is empty");

        if(k <= 0 || k > count)
            throw new IllegalArgumentException("K out of bounds");

        var distanceBetweenNodes = k -1;
        var firstPointer = head;
        var secondPointer = head;

        secondPointer = positionSecondPointer(distanceBetweenNodes, secondPointer);

        // Move both pointers forward until the second pointer is at the end of the LinkedList
        while(secondPointer != tail) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        //Return the value of the first pointer
        return firstPointer.value;
    }

    /**
     * Return the middle of a linkedList in one pass
     * If the list has an even number of nodes, there would be two middle nodes
     * Assume we don't know the size of the list ahead of time
    * */
    public void printMiddleOld() {

        if (isEmpty()) throw new NoSuchElementException("List is empty");

        var middlePointer = head;
        var secondPointer = head;
        var size = 1; //If LinkedList is not empty, it has at least one node

        //Move the second pointer until it reaches the end of the list and get the size of the LinkedList
        while(secondPointer != tail) {
            secondPointer = secondPointer.next;
            size++;
        }

        //Move the middlePointer to the middle of the LinkedList
        var startPosition = (size % 2 == 0) ? 1 : 0;
        while (startPosition < size / 2) {
            middlePointer = middlePointer.next;
            startPosition++;
        }


        var middle = (size % 2 == 0) ? middlePointer.value + " | " + middlePointer.next.value : middlePointer.value;

        System.out.println(middle);

    }

    public void printMiddle() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");

        var middlePointer = head;
        var endPointer = head;

        while(endPointer != tail && endPointer.next != tail) {
            endPointer = endPointer.next.next;
            middlePointer = middlePointer.next;
        }

        if (endPointer == tail)
            System.out.println(middlePointer.value);
        else
            System.out.println(middlePointer.value + " | " + middlePointer.next.value);
    }

    //Private methods
    private boolean isEmpty() {
        return head == null;
    }
    private boolean containsOneItem() {
        return head == tail;
    }
    private Node getPrevious(Node targetNode) {
        var currentNode = head;
        while (currentNode != null) {
            //If the node before the targetNode is found, return it
            if (currentNode.next == targetNode)
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * Move the second pointer forward until it is at the right distance of the first pointer
     * */
    private Node positionSecondPointer(int distance, Node secondPointer) {
        var placesMoved = 0;
        while (placesMoved < distance) {
            secondPointer = secondPointer.next;
            placesMoved++;
        }
        return secondPointer;
    }

}
