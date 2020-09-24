package algorithms;

import java.util.Stack;

public class ReverseString {

    /**
     * Reverses the given string.
     * @param str the string to reverse
     * @return str reversed
     */
    public static String viaStack(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        Stack<Character> chars = new Stack<>();

        for (char ch : str.toCharArray()) {
            chars.push(ch);
        }

        StringBuilder reversed = new StringBuilder(str.length());
        while (!chars.empty()) {
            reversed.append(chars.pop());
        }

        return reversed.toString();
    }
}
