/**
 * Represents the List Abstract Data type.
 * @author David, Nicolas
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface List<T> {
    /**
     * Returns a boolean indicating whether the List is empty.
     *
     * @return true if List is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the size of the List.
     *
     * @return the number of items in this list
     */
    int size();

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
    void add(int index, T data);

    /**
     * Adds data to the end of the List.
     *
     * If the data passed in is null, throw an IllegalArgumentException
     * with the message "Can only add non-null data!"
     *
     * @param data  the data to add
     */
    void add(T data);

    /**
     * Removes the data at the specified index and returns the removed data's value.
     *
     * If the index value is out of range based on the list's size,
     * throw an IllegalArgumentException with the message “Invalid index!”
     *
     * @param index the index to remove from
     * @return the removed data value
     */
    T remove(int index);

    /**
     * Removes the first occurence of the data if it exists.
     *
     * If no occurences of the data exist, throw a NoSuchElementException
     * with the message "Not possible to remove entry absent from list.”
     *
     * @return the removed data value
     */
    T remove(T data);

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
    T get(int index);

    /**
     * Modifies data in the List at the specified index.
     *
     * If the index is less than 0 or greater than size(), throw
     * an IllegalArgumentException with the message “Invalid index!”.
     *
     * If the data passed in is null, throw an IllegalArgumentException
     * with the message "Can only set to non-null values!"
     *
     * @param index The index at which data will be added
     * @param data  the data to add
     * @return the data originally at the specified index
     */
    T set(int index, T data);

    /**
     * Checks to see if the List contains the passed in data.
     *
     * If the passed in data is null, throw an IllegalArgumentException
     * with the message “Null data cannot be in list”
     *
     * @param data the data to look for
     * @return true if the List contains the passed in data, false otherwise
     */
    boolean contains(T data);

    /**
     * Removes all elements from the List.
     */
    void clear();

    /**
     * Reverses the List upon which this method is invoked.
     *
     * For example, if a List contains [“a”, “b”, “c”, “d”], following a reverse() call,
     * it should be reordered to [“d”, “c”, “b”, “a”].
     *
     * Your LinkedList implementation must not create new nodes nor modify
     * the data attribute in any nodes. Further, it must not use
     * auxillary data structures (an array, ArrayList, etc.).
     *
     * HINT: recursion will be needed here
     */
    void reverse();
}
