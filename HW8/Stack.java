/**
 * Represents the Stack Abstract Data Type, adhering to a Last-In-First-Out (LIFO) policy.
 * @author David
 * @version 1.0
 * @param <T> The type of elements in this Stack
 */
public interface Stack<T> {
    /**
     * Returns a boolean indicating whether the Stack is empty.
     *
     * @return true if Stack is empty, false otherwise
     */
    boolean isEmpty();

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
    void push(T data);

    /**
     * Removes an object from the Stack and returns the data that
     * object holds.
     *
     * Remember the LIFO characteristic of a Stack.
     * If the Stack is empty, throw a NoSuchElementException with message "Cannot pop from empty stack.”
     *
     * @return the dequeued item
     */
    T pop();
}