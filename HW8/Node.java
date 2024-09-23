/**
 * This class defines the units that will comprise the LinkedList.
 * @author Diya Sharma
 * @version 1.0
 * @param <T> The type of data held in a Node object.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructs a Node with the given data and reference to the next node.
     *
     * @param data The data to be stored in the Node.
     * @param next The reference to the next Node in the LinkedList.
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructs a Node with the given data and sets the reference to the next node to null.
     *
     * @param data The data to be stored in the Node.
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * Retrieves the data stored in the Node.
     *
     * @return The data stored in the Node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data stored in the Node.
     *
     * @param data The data to be stored in the Node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Retrieves the reference to the next Node in the LinkedList.
     *
     * @return The reference to the next Node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next Node in the LinkedList.
     *
     * @param next The reference to the next Node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
