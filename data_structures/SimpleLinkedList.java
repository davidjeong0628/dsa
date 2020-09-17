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
     * Appends elem to the end of the list.
     * @param elem the element to append
     */
    public void addLast(int elem) {
        Node newNode = new Node(elem);

        if (this.first == null) {
            this.first = newNode;
        } else {
            Node curr = this.first;
            
            while (curr.next != null) {
                curr = curr.next;
            }
            
            curr.next = newNode;
        }
        
        this.last = newNode;
        this.size += 1;
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

    public static void main(String[] args) {
        SimpleLinkedList ll = new SimpleLinkedList();

        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);

        System.out.println(ll);
        System.out.println(ll.size());
    }
}
