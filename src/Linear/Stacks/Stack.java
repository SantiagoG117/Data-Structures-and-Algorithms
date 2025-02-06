package Linear.Stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * This class simulates the behavior of a Stack using an array
 * */
public class Stack {
    private int[] items = new int[10];
    private int top = 0;


    /**
     * @param value: save the value at the top of the stack
     *
    * */
    public void push(int value){
        if(isFull())
            increaseLength();

        items[top++] = value;
    }

    /**
     * @return The element on top of the stack and removes it
     * */
    public int pop(){
        if (isEmpty())
            throw new EmptyStackException();

        var result = items[--top];
        items[top] = 0;

        return result;
    }


    /**
     * @return the first element of the Stack or the element present at the top of the Stack without removing it
     * */
    public int peek(){
        if (isEmpty())
             throw new EmptyStackException();

        return items[top -1];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void printStack() {
        var content = Arrays.copyOfRange(items, 0, top);

        System.out.println(Arrays.toString(content));
    }



    private boolean isFull() {
        return items.length == top;
    }

    private void increaseLength() {
        //Build a new array
        var newItems = new int [items.length + (items.length / 2)];
        //Copy the items from the old array into the new
        System.arraycopy(items, 0, newItems, 0 ,items.length);
        //Set the newItems as Items
        items = newItems;
    }

}
