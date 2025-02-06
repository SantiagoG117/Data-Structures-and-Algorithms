package Linear.Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class implements two stacks using a single array.
* */
public class TwoStacks {
    private int[] items;
    private int top1;
    private int top2;

    public TwoStacks(int capacity){
        if (capacity <=0)
            throw new IllegalArgumentException("Capacity should be 1 or greater");
        items = new int[capacity];
        top1 = 0;
        top2 = capacity;
    }

    public void push1(int item){
        if(isFull())
            throw new StackOverflowError("Stack 1 is full");

        items[top1++] = item;
    }
    public void push2(int item){
        if(isFull())
            throw new StackOverflowError("Stack 2 is full");
        items[--top2] = item;
    }

    public int pop1(){
        if(isEmpty1())
            throw new EmptyStackException();

        var result = items[--top1];
        items[top1] = 0;

        return result;
    }

    public int pop2(){
        if (isEmpty2())
            throw new EmptyStackException();

        var result = items[top2];

        items[top2++] = 0;

        return result;
    }

    public boolean isFull(){
        return top1 == top2;
    }

    public boolean isEmpty1(){
        return top1 == 0;
    }

    public boolean isEmpty2(){
        return top2 == items.length;
    }

    public void printStack(){
        System.out.println(Arrays.toString(items));
    }


}
