package data_structures;

import java.util.Arrays;
import java.util.Objects;

public class MySimpleArrayList<T> {
    private T[] arr;
    private int size = 0;
    private int capacity;

    /**
     * Creates an array list with a capacity of 5.
     */
    public MySimpleArrayList() {
        this.arr = (T[]) new Object[5];
        this.capacity = 5;
    }

    /**
     * Creates an array list with a capacity of initialCapacity.
     * @param initialCapacity used to set the initial capacity of the array
     * list 
     */
    public MySimpleArrayList(int initialCapacity) {
        this.arr = (T[]) new Object[initialCapacity];
        this.capacity = initialCapacity; 
    }

    /**
     * Appends the element elem to the end of the array list.
     * @param elem the element to insert
     */
    public void insert(T elem) {
        this.size += 1;

        if (this.size > this.capacity) {
            this.arr = Arrays.copyOf(this.arr, this.capacity * 2);
            this.arr[this.size - 1] = elem;

            this.capacity *= 2;
        } else {
            this.arr[this.size - 1] = elem;
        }
    }

    /**
     * Removes the element at index.
     * @param index locates the element to remove
     * @throws IndexOutOfBoundsException if index is invalid 
     * @return the removed element
     */
    public T removeAt(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }

        T elemToRemove = this.arr[index];

        for (int i = index; i < this.size - 1; i += 1) {
            this.arr[i] = this.arr[i + 1];
        }

        this.size -= 1;

        this.arr[this.size] = null;

        return elemToRemove;
    }

    /**
     * Returns the index of the first instance (from the left) of elem.
     * @param elem the element to search for
     * @return the index that elem is located in or -1 if elem not found
     */
    public int indexOf(T elem) {
        int index = -1;
        
        if (elem == null) {
            return index;
        }
        
        for (int i = 0; i < this.size; i += 1) {
            if (this.arr[i].equals(elem)) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * Gets the number of inserted elements in the array list.  
     * @return the size of the array list
     */
    public int size() {
        return this.size;
    }

    /**
     * Prints the contents of the array list.
     */
    public void printAllElems() {
        for (int i = 0; i < this.size; i += 1) {
            System.out.print(this.arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MySimpleArrayList<Integer> al = new MySimpleArrayList<>(3);
        al.insert(100);
        al.insert(200);
        al.insert(300);
        al.insert(400);
        al.insert(500);
        
        al.removeAt(2);

        al.insert(600);

        al.printAllElems();
    }
}