package Linear.Stacks;

/**
 * Use stacks to retrieve the minimum value in constant time
 * */
public class MinStack {
    private Stack stack = new Stack(); //Holds the items
    private Stack minStack = new Stack(); //Holds the smallest items

    public void push(int value){

        if(minStack.isEmpty() || value < minStack.peek())
            minStack.push(value);

        stack.push(value);
    }

    public int pop() {
        var result = stack.pop();

        if(minStack.peek() == result)
            minStack.pop();

        return result;
    }

    public int minValue() {
        return minStack.peek();
    }
}
