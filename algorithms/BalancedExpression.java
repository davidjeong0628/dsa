package algorithms;

import java.util.Stack;

public class BalancedExpression {
    /**
     * Checks whether the brackets in str are balanced. 
     * @param str the string to check for balanced brackets
     * @return true if brackets are balanced, otherwise false
     */
    public static boolean check(String str) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < str.length(); i += 1) {
            char ch = str.charAt(i);

            if (isBracket(ch, true)) {
                brackets.push(ch);
                continue;
            }

            if (isBracket(ch, false)) {
                if (!brackets.empty() && matchBracket(brackets.pop(), ch)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        return brackets.empty();
    }

    private static boolean isBracket(char ch, boolean open) {
        boolean bracket;

        if (open) {
            bracket = (ch == '[') || (ch == '{') || (ch == '(') ||
                (ch == '<'); 
        } else {
            bracket = (ch == ']') || (ch == '}') || (ch == ')') ||
                (ch == '>');
        }

        return bracket;
    }

    private static boolean matchBracket(char open, char closed) {
        boolean match;

        if (open == '[') {
            match = closed == ']';
        } else if (open == '{') {
            match = closed == '}';
        } else if (open == '(') {
            match = closed == ')';
        } else {
            match = closed == '>';
        }

        return match;
    }
}
