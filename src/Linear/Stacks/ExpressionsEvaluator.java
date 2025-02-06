package Linear.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionsEvaluator {
    private final HashMap<Character, Character> brackets;
    private final Stack<Character> stack;

    public ExpressionsEvaluator() {
        stack = new Stack<Character>();
        brackets = new HashMap<>();
        brackets.put('(' , ')');
        brackets.put('[' , ']');
        brackets.put('{' , '}');
        brackets.put('<' , '>');
    }


    /**
     * Examine the syntax of an expression and determine whether the pairs and order of brackets
     * are correct
     * */
    public boolean isBalanced(String expression) {

        if(expression == null)
            throw new IllegalArgumentException("Please provide an expression to be evaluated");

        //Iterate over each character of the expression
        for (char character : expression.toCharArray()) {
            //If we reach an opening bracket, push it to the top of the stack
            if (isLeftBracket(character))
                stack.push(character);

            //If we reach a closing bracket, pop the element at the top of the stack and compare it
            if (isRightBracket(character)) {

                //If the stack is empty at this point, it means the order of the brackets was reversed
                if(stack.isEmpty())
                    return false;

                //If the closing bracket does not match with the opening bracket return false
                var lastOpening = stack.pop();
                if(!bracketsMatch(character, lastOpening))
                    return false;
            }
        }

         return stack.isEmpty();

    }

    private boolean bracketsMatch(char character , Character lastOpening) {
        return brackets.get(lastOpening).equals(character);
    }

    private boolean isRightBracket(char character) {
        return brackets.containsValue(character);
    }

    private boolean isLeftBracket(char character) {
        return brackets.containsKey(character);
    }
}
