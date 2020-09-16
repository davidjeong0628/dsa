package data_structures;

import java.util.Arrays;

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

        this.checkResize();
        this.arr[this.size - 1] = elem;
    }

    /**
     * Inserts elem at index.
     * @param elem the element to insert
     * @param index the index at which the element will be inserted
     */
    public void insert(T elem, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        this.size += 1;

        this.checkResize();
        
        for (int i = this.size - 1; i > index; i -= 1) {
            this.arr[i] = this.arr[i - 1];
        }

        this.arr[index] = elem;
    }

    /**
     * Resizes the internal array if necessary.
     */
    private void checkResize() {
        if (this.size > this.capacity) {
            this.arr = Arrays.copyOf(this.arr, this.capacity * 2);
            this.capacity *= 2;
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
     * Reverses the array list.
     */
    public void reverse() {
        T[] newArr = (T[]) new Object[this.capacity];

        for (int i = 0; i < this.size; i += 1) {
            newArr[i] = this.arr[this.size - i - 1];
        }

        this.arr = newArr;
    }

    public static void main(String[] args) {
        MySimpleArrayList<Integer> al = new MySimpleArrayList<>(3);
        al.insert(100);
        al.insert(200);
        al.insert(300);
        al.insert(400);
        al.insert(500);
        
        int num = al.removeAt(2);

        al.reverse();

        al.insert(num, 2);
        al.insert(0, 5);
        al.insert(600, 0);

        System.out.println(Arrays.toString(al.arr));
    }
}