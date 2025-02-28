package Linear.Queues;

/**
 * Build a queue using a Linked List from scratch.
 * */
public class LinkedListQueue {
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;


    public void enqueue(int item){
        //Create a new Node
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
            count++;
            return;
        }
        //Have the tail point to the new node
        tail.next = node;

        //Set the new Node as the tail
        tail = node;

        count++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");

        //Get the value of head
        int result = head.value;

        //Verify if the linked list has only a single item
        if(head == tail)
            head = tail = null;
        else {
            //Save the reference to the new head
            var newHead = head.next;

            //Detach the current head
            head = null;

            //Set the new head to the next node of the current head
            head = newHead;
        }

        count--;
        return result;
    }

    public int peek(){
        return head.value;
    }

    public int size(){
        return count;
    }

    private boolean isEmpty(){
        return head == null;
    }

}
