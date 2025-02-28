package Linear.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    private Stack<Integer> stack = new Stack<Integer>();

    /**
     * Take a queue and reverse it using only the following methods:
     *      add
     *      remove
     *      IsEmpty
     * */
    public Queue<Integer> reverse(Queue<Integer> queue) {
        //TODO: Verify edge cases
        var reversed = new ArrayDeque<Integer>();

        //Empty the queue and add each item to a stack
        while (!queue.isEmpty())
            stack.push(queue.remove());

        //Empty the stack and add each item into the reversed queue
        while (!stack.isEmpty())
            reversed.add(stack.pop());

        return reversed;

    }
    /**
     * Takes a queue and reverse its first k elements
     * */
    public Queue<Integer>reverseTheFirstKElements(int k, Queue<Integer> queue){
        if (k > queue.size() || k < 0)
            throw new IllegalArgumentException("k must be smaller than the size of the queue and greater than 0");

        Queue<Integer> result = new ArrayDeque<>();

        //Iterate over the first k elements of the queue and store them in a Stack
        while(k > 0){
            stack.push(queue.remove());
            k--;
        }

        //Empty the stack and add the items in the result queue
        while (!stack.isEmpty())
            result.add(stack.pop());

        //Add the remaining items of the queue at the end of the new queue
        while(!queue.isEmpty())
            result.add(queue.remove());

        return result;
    }


}
