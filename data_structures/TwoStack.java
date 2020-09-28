package data_structures;

import java.util.LinkedList;
import java.util.List;

public class TwoStack {
    private List<Integer> items;
    private int count1 = 0;
    private int count2 = 0;

    public TwoStack() {
        this.items = new LinkedList<>();
    }

    public void push1(Integer item) {
        this.items.add(0, item);
        this.count1 += 1;
    }

    public void push2(Integer item) {
        this.items.add(item);
        this.count2 += 1;
    }

    public Integer pop1() {
        if (this.isEmpty1()) {
            throw new IllegalStateException();
        } 

        count1 -= 1;
        return this.items.remove(0);
    }

    public Integer pop2() {
        if (this.isEmpty2()) {
            throw new IllegalStateException();
        }

        count2 -= 1;
        return this.items.remove(this.items.size() - 1);
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == 0;
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}
