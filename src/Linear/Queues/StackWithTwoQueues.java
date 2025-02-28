package Linear.Queues;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

/*
* Simulates a Stack behavior using two queues
*
*
* */
public class StackWithTwoQueues {
    private Queue<Integer> items = new ArrayDeque<Integer>();
    private Queue<Integer> queuePop = new ArrayDeque<Integer>();
    private int top;


    public void push(int item) {
        items.add(item);
        top = item;
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();

        //Get the last item in items
        while (items.size()> 1){
            top = items.remove();//Set the item before the last item as the new top
            queuePop.add(top);
        }

        //Swap the queues
        swapQueues();

        return queuePop.remove();
    }



    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();

        return top;
    }

    private boolean isEmpty() {
        return items.isEmpty();
    }

    private void swapQueues() {
        var tempQueue = items;
        items = queuePop;
        queuePop = tempQueue;
    }

}
