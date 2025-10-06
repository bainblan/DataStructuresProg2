
/**
 * Simple node type for a doubly-linked list.
 *
 * @param <T> element type (must be Comparable)
 */
public class NodeType<T extends Comparable<T>> {

    private T info;
    private NodeType<T> next;
    private NodeType<T> back;

    /**
     * Create an empty node with null links and no info set.
     */
    public NodeType() {
        next = null;
        back = null;
    }

    /**
     * Return the payload stored in this node.
     *
     * @return the info value (may be null)
     */
    public T getInfo() {
        return info;
    }

    /**
     * Set the payload for this node.
     *
     * @param info value to store in the node
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Get the next node in the list.
     *
     * @return reference to the next node, or null if none
     */
    public NodeType<T> getNext() {
        return next;
    }

    /**
     * Set the next node reference.
     *
     * @param next node to set as next
     */
    public void setNext(NodeType<T> next) {
        this.next = next;
    }

    /**
     * Get the previous (back) node in the list.
     *
     * @return reference to the previous node, or null if none
     */
    public NodeType<T> getBack() {
        return back;
    }

    /**
     * Set the previous (back) node reference.
     *
     * @param back node to set as previous
     */
    public void setBack(NodeType<T> back) {
        this.back = back;
    }
}
