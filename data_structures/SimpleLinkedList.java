package data_structures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A simple linked list which can only hold int types.
 */
public class SimpleLinkedList {
    private Node first;
    private Node last;
    private int size;

    /**
     * Represents a node in the list.
     */
    private class Node {
        private int value = 0;
        private Node next = null;
    
        public Node(int value) {
            this.value = value;
        }
        
        public Node(int value, Node next) {
            this(value);
            this.next = next;
        }
    }

    /**
     * Prepends elem to the list.
     * @param elem the element to prepend
     */
    public void addFirst(int elem) {
        Node newNode = new Node(elem);

        if (this.isEmpty()) {
            this.first = this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }

        this.size += 1;
    }
    
    /**
     * Appends elem to the list.
     * @param elem the element to append
     */
    public void addLast(int elem) {
        Node newNode = new Node(elem);

        if (this.isEmpty()) {
            this.first = this.last = newNode;
        } else {
            this.last = this.last.next = newNode;
        }
        
        this.size += 1;
    }

    /**
     * Removes the first element in the list.
     */
    public void removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.first == this.last) {
            this.first = this.last = null;
        } else {
            Node newFirst = this.first.next;
            
            this.first.next = null;
            this.first = newFirst;
        }
        
        this.size -= 1;
    }

    /**
     * Removes the last element in the list.
     */
    public void removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (this.first == this.last) {
            this.first = this.last = null;
        } else {
            Node curr = this.first;
    
            while (curr.next != this.last) {
                curr = curr.next;
            }
    
            curr.next = null;
            this.last = curr;
        }

        this.size -= 1;
    }

    /**
     * Checks whether elem is in the list.
     * @param elem the value to look for
     * @return true if elem is in the list, otherwise false
     */
    public boolean contains(int elem) {
        return this.indexOf(elem) != -1;
    }

    /**
     * Returns the index of the node with the value elem, or -1 if not found.
     * @param elem the element to look for
     * @return the index of the node with the value elem or -1 if not found
     */
    public int indexOf(int elem) {
        Node curr = this.first;
        int index = 0;

        while (curr != null) {
            if (curr.value == elem) {
                return index;
            }

            curr = curr.next;
            index += 1;
        }

        return -1;
    }

    /**
     * Reverses this list.
     */
    public void reverse() {
        if (this.isEmpty()) {
            return;
        }

        Node prev = this.first;
        Node curr = this.first.next;
        
        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        this.last = this.first;
        this.last.next = null;
        this.first = prev;
    }

    /**
     * Returns the kth value from the end.
     * @param k the offset from the end
     * @return the kth value from the end
     */
    public int getKthFromEnd(int k) {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        Node left, right;
        left = right = this.first;

        int dist = 0;
        while (right != this.last && dist < k - 1) {
            right = right.next;

            dist += 1;
        }

        while (right != this.last) {
            left = left.next;
            right = right.next;
        }

        return left.value;
    }

    /**
     * Prints the middle element(s) of the list.
     */
    public void printMiddle() {
        if (this.isEmpty()) {
            return;
        }

        Node left, right;
        left = right = this.first;

        while (right != this.last && right.next != this.last) {
            left = left.next;
            right = right.next.next;
        }

        String s = Integer.toString(left.value);

        if (right != this.last) {
            s += " " + Integer.toString(left.next.value);
        }

        System.out.println(s);
    }

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Converts list to an array.
     * @return the linked list as an array
     */
    public int[] toArray() {
        Node curr = this.first;
        int[] arr = new int[this.size];

        int i = 0;
        while (curr != null) {
            arr[i++] = curr.value;
            
            curr = curr.next;
        }

        return arr;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");

        Node curr = this.first;

        while (curr != null) {
            s.append(curr.value + ", ");
            curr = curr.next;
        }

        s.trimToSize();

        if (!this.isEmpty()) {
            s.replace(s.length() - 2, s.length(), "]");
        } else {
            s.append("]");
        }
        
        return s.toString();
    }

    /**
     * Checks if the list is empty or not.
     * @return true if list is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.first == null ? true : false;
    }

    public static void main(String[] args) {
        SimpleLinkedList ll = new SimpleLinkedList();

        System.out.println(Arrays.toString(ll.toArray()));
    }
}
