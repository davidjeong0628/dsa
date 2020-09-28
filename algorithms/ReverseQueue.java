package algorithms;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    /**
     * Reverses queue.
     * @param queue The queue to reverse.
     */
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> s = new Stack<>();
        
        while (!queue.isEmpty()) {
            s.push(queue.remove());
        }

        while (!s.isEmpty()) {
            queue.add(s.pop());
        }
    }
}
