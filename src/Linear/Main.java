package Linear;

import Linear.Queues.LinkedListQueue;
import Linear.Queues.PriorityQueue;
import Linear.Queues.QueueReverser;
import Linear.Queues.StackWithTwoQueues;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        var stack = new StackWithTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();




        System.out.println("Item on top " + stack.peek() );

        System.out.println("Item removed: " + stack.pop());
        System.out.println("New Item on top " + stack.peek());
        System.out.println("Item removed: " + stack.pop());
        System.out.println("New Item on top " + stack.peek());
        System.out.println("Item removed: " + stack.pop());
        System.out.println("New Item on top " + stack.peek());
        System.out.println("Item removed: " + stack.pop());
        System.out.println("New Item on top " + stack.peek());
        System.out.println("Item removed: " + stack.pop());










    }
}
