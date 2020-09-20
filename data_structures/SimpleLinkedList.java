package data_structures;

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
            return;
        }
        
        Node newFirst = this.first.next;
        
        this.first.next = null;
        this.first = newFirst;

        this.size -= 1;
    }

    public void removeLast() {

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
     * Returns the number of elements in the list.
     * @return the number of elements in the list.
     */
    public int size() {
        return this.size;
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

        ll.addFirst(1);
        ll.addFirst(1);
    }
}
