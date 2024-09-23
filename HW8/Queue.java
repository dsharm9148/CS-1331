/**
 * Represents the Queue Abstract Data Type, adhering to a First-In-First-Out (FIFO) policy.
 * @author David, Melanie
 * @version 1.0
 * @param <T> The type of elements in this Queue
 */
public interface Queue<T> {
    /**
     * Returns a boolean indicating whether the Queue is empty.
     *
     * @return true if Queue is empty, false otherwise
     */
    boolean isEmpty();

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
    void enqueue(T data);

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
    T dequeue();
}