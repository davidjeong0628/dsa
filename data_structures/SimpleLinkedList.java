package data_structures;

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
     * Returns the index of the node with the value elem, or -1 if not found.
     * @param elem the element to look for
     * @return the index of the node with the value elem or -1 if not found
     */
    public int indexOf(int elem) {
        int currIndex = 0;
        int returnIndex = -1;
        
        Node curr = this.first;

        while (curr != null) {
            if (curr.value == elem) {
                returnIndex = currIndex;
                break;
            }

            curr = curr.next;
            currIndex += 1;
        }

        return returnIndex;
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
        s.replace(s.length() - 2, s.length(), "]");
        
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

        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);

        ll.addFirst(-1);
        ll.addFirst(-2);
        ll.addFirst(-3);
        ll.addLast(3);

        System.out.println(ll.indexOf(0));
        System.out.println(ll.indexOf(-3));
        System.out.println(ll.indexOf(3));
        System.out.println(ll.indexOf(4));

        System.out.println(ll);
        System.out.println(ll.size());
        System.out.println(ll.first.value);
    }
}
