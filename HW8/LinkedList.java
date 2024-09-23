import java.util.NoSuchElementException;
/**
 * LinkedList class.
 * @author Diya Sharma
 * @version 1.0
 * @param <T> The type of data held in a list.
 */
public class LinkedList<T> implements List<T>, Queue<T>, Stack<T> {

    private Node head;
    private Node tail;
    private int size;
    /**
     * LinkedList contrsuctor.
     * Sets all values to null or 0.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * toString method.
     * @return string representation of list
     */
    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        String result = "[";
        Node<T> current = head;
        while (current.getNext() != null) {
            result += current.getData() + "] --> [";
            current = current.getNext();
        }
        result += current.getData() + "]";
        return result;
    }

    /**
     * checks if list is empty.
     * @return true if size is zero
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns size of list.
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Adds data to the List at the specified index.
     *
     * If the index is less than 0 or greater than size(), throw
     * an IllegalArgumentException with the message “Invalid index!”.
     *
     * If the data passed in is null, throw an IllegalArgumentException
     * with the message "Can only add non-null data!"
     *
     * @param index The index at which data will be added
     * @param data  the data to add
     */
    public void add(int index, T data) {
        if (index < 0 || index > size()) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (data == null) {
            throw new IllegalArgumentException("Can only add non-null data!");
        }
        if (index == 0) {
            Node<T> newNode = new Node<>(data, head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size()) {
            Node<T> newNode = new Node<>(data);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<>(data, current.getNext());
            current.setNext(newNode);
        }
        size++;
    }


    /**
     * Adds data to the end of the List.
     *
     * If the data passed in is null, throw an IllegalArgumentException
     * with the message "Can only add non-null data!"
     *
     * @param data  the data to add
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Can only add non-null data!");
        }
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;

    }

    /**
     * Removes the data at the specified index and returns the removed data's value.
     *
     * If the index value is out of range based on the list's size,
     * throw an IllegalArgumentException with the message “Invalid index!”
     *
     * @param index the index to remove from
     * @return the removed data value
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }
        Node<T> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedNode = current.getNext();
            current.setNext(removedNode.getNext());
            if (index == size - 1) {
                tail = current;
            }
        }
        size--;
        return removedNode.getData();
    }



    /**
     * Removes the first occurrence of the data if it exists.
     *
     * If no occurrences of the data exist, throw a NoSuchElementException
     * with the message "Not possible to remove entry absent from list.”
     *
     * @param data the data to be removed
     * @return the removed data value
     */
    public T remove(T data) {
        if (head.getData().equals(data)) {
            T removedData = (T) head.getData();
            head = head.getNext();
            return removedData;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                T removedData = current.getNext().getData();
                current.setNext(current.getNext().getNext());
                size--;
                return removedData;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("Not possible to remove entry absent from list.");
    }


    /**
     * Retrieves the data from the specified index and returns it.
     *
     * If the List is empty or the index is less than 0 or greater than
     * or equal size(), throw an IllegalArgumentException
     * with the message “Invalid index!”
     *
     * @param index the index to return from
     * @return the data at the specified index
     */
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            throw new IllegalArgumentException("Invalid index!");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Modifies data in the List at the specified index.
     *
     * If the index is less than 0 or greater than size(), throw
     * an IllegalArgumentException with the message “Invalid index!”.
     *
     * If the data passed in is null, throw an IllegalArgumentException
     * with the message "Can only set to non-null values!"
     *
     * @param index The index at which data will be modified
     * @param data  the new data
     * @return the data originally at the specified index
     */
    public T set(int index, T data) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Invalid index!");
        }
        if (data == null) {
            throw new IllegalArgumentException("Can only set to non-null values!");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T oldData = current.getData();
        current.setData(data);
        return oldData;
    }


    /**
     * Checks to see if the List contains the passed in data.
     *
     * If the passed in data is null, throw an IllegalArgumentException
     * with the message “Null data cannot be in list”
     *
     * @param data the data to look for
     * @return true if the List contains the passed in data, false otherwise
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null data cannot be in list");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    /**
     * Removes all elements from the List.
     */
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(null);
            current = next;
        }
        head = null;
        size = 0;
    }

    /**
     * Adds data to the Queue.
     *
     * If data is null, throw an IllegalArgumentException
     * with the message "Can only enqueue non-null data."
     *
     * NOTE: Enqueue operations should have a worst case of O(1)
     *
     * @param data the data to add to the queue.
     */
    public void enqueue(T data) {
        add(data);
    }

    /**
     * Removes data from the Queue.
     *
     * Remember the FIFO characteristic of a Queue.
     * If the Queue is empty, throw a NoSuchElementException
     * with the message "Cannot dequeue from empty queue.”
     *
     * NOTE: Dequeue operations should have a worst case of O(1)
     *
     * @return the dequeued item
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot dequeue from empty queue.");
        }
        return remove(0);
    }

    /**
     * Adds data to the Stack.
     *
     * Think about what kind of object
     * this data should reside in and where it should go to satisfy
     * the LIFO characteristic of a Stack.
     *
     * If data is null, throw an IllegalArgumentException with message
     * "Can only push non-null data."
     *
     * @param data the data to add to the queue.
     */
    public void push(T data) {
        add(0, data);
    }

    /**
     * Removes an object from the Stack and returns the data that
     * object holds.
     *
     * Remember the LIFO characteristic of a Stack.
     * If the Stack is empty, throw a NoSuchElementException with message "Cannot pop from empty stack.”
     *
     * @return the dequeued item
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from empty stack.");
        }
        return remove(0);
    }

    /**
     * Reverses the List upon which this method is invoked.
     *
     * For example, if a List contains [“a”, “b”, “c”, “d”], following a reverse() call,
     * it should be reordered to [“d”, “c”, “b”, “a”].
     *
     * Your LinkedList implementation must not create new nodes nor modify
     * the data attribute in any nodes. Further, it must not use
     * auxiliary data structures (an array, ArrayList, etc.).
     *
     * HINT: recursion will be needed here
     */
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }
        head = reverseRecursive(null, head);
    }

    private Node<T> reverseRecursive(Node<T> prev, Node<T> current) {
        if (current == null) {
            return prev;
        }
        Node<T> next = current.getNext();
        current.setNext(prev);
        return reverseRecursive(current, next);
    }

    /**
     * Main method.
     * @param args args
     */
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Add some elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Print the list using toString()
        System.out.println("Initial List: " + list.toString());

        // Test add method
        list.add("Mango");
        System.out.println("List after adding 'Mango': " + list.toString());

        list.add(2, "Watermelon");
        System.out.println("List after adding 'Watermelon' at index 2: " + list.toString());

        // Test remove method
        list.remove(1);
        System.out.println("List after removing index 1: " + list.toString());
        list.remove("Apple");
        System.out.println("List after removing 'Apple': " + list.toString());

        // Test contains method
        System.out.println("Does the list contain 'Banana'? " + list.contains("Banana"));
        System.out.println("Does the list contain 'Mango'? " + list.contains("Mango"));

        // Test clear method
        list.clear();
        System.out.println("List after clearing: " + list.toString());

        // Test enqueue and dequeue methods
        list.enqueue("First");
        list.enqueue("Second");
        System.out.println("New List: " + list.toString());
        list.enqueue("Third");
        System.out.println("List after enqueue: " + list.toString());
        list.dequeue();
        System.out.println("List after dequeue: " + list.toString());

        // Test clear method
        list.clear();
        System.out.println("List after clearing: " + list.toString());
        list.push("One");
        list.push("Two");
        System.out.println("New List: " + list.toString());
        // Test push and pop methods
        list.push("Three");
        System.out.println("List after pushing 'Three': " + list.toString());
        list.pop();
        System.out.println("List after one pop: " + list.toString());
        list.pop();
        System.out.println("List after another pop: " + list.toString());

        // Create a LinkedList
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        System.out.println("List 2: " + list2.toString());

        // Test reverse method
        list2.reverse();
        System.out.println("List after reverse: " + list2.toString());
    }
}