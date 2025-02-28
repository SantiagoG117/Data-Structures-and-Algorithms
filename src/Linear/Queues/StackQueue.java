package Linear.Queues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Use stacks to implement a Queue
 * Queues use the First In First Out principle (FIFO) whereas Stacks use the Last In First Out (LIFO) principle.
 * Since the two data structures follow opposite behaviors we must use two stacks.
 * With two stacks we can move items around and change the order at which they get removed from the Queue
 * */
public class StackQueue {

    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int item){
        while (!dequeueStack.isEmpty())
            enqueueStack.push(dequeueStack.pop());

        enqueueStack.push(item);

    }

    public int dequeue(){
        while (!enqueueStack.isEmpty())
            dequeueStack.push(enqueueStack.pop());

        if (dequeueStack.isEmpty())
            throw new IllegalStateException("Queue is empty");
        return dequeueStack.pop();
    }

    public int peek(){
        while (!enqueueStack.isEmpty())
            dequeueStack.push(enqueueStack.pop());

        if (dequeueStack.isEmpty())
            throw new IllegalStateException("Queue is empty");

        return dequeueStack.peek();
    }
}
