package Linear.Stacks;

import java.util.Stack;

public class StringReverser {

    private final Stack<Character> stack;

    public StringReverser() {
        stack = new Stack<Character>();
    }

    public String reverseString(String string) {

        StringBuilder reversedString = new StringBuilder();

        //Save the characters of the string in an array
        var chars = string.toCharArray();

        //Iterate over the char array and store each character in the stack
        for(char ch : chars)
            stack.push(ch);

        //Pop each item from the stack and appended it to the reverseString variable
        while (!stack.isEmpty())
            reversedString.append(stack.pop());


        return reversedString.toString();
    }
}
