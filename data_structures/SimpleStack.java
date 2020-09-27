package data_structures;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack {
    private List<Integer> stack;
    
    /**
     * Constructs a SimpleStack with a capacity of 10.
     */
    public SimpleStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Inserts num at the top of the stack.
     * @param num the element to insert.
     */
    public void push(Integer num) {
        this.stack.add(num);
    }

    /**
     * Removes the element at the top of the stack.
     * @return The element that has been popped.
     */
    public Integer pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return this.stack.remove(this.stack.size() - 1);
    }

    /**
     * Returns the element at the top of the stack.
     * @return The element at the top of the stack.
     */
    public Integer peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return this.stack.get(this.stack.size() - 1);
    }

    /**
     * Checks whether the stack is empty.
     * @return True if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public String toString() {
        return this.stack.toString();
    }
}
