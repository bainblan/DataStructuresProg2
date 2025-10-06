
public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private NodeType<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void deleteItem(T item) {
        if (head == null) {
            throw new IllegalArgumentException("You cannot delete from an empty list");
        }
        NodeType<T> curr = head;
        //Iterate
        while (curr != null && curr.getInfo().compareTo(item) != 0) {
            curr = curr.getNext();
        }
        //Unfound Case
        if (curr == null) {
            throw new IllegalArgumentException("Item not found");
        }
        //Found Case
        if (curr == head) {
            head = head.getNext();
            if (head != null) {
                head.setBack(null);
            } else {
                tail = null;
            }
            size--;
        } else if (curr == tail) {
            tail = tail.getBack();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
            size--;
        } else {
            curr.getBack().setNext(curr.getNext());
            curr.getNext().setBack(curr.getBack());
            size--;
        }
    }

    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>();
        newNode.setInfo(item);
        NodeType<T> curr = head;

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            // Iterate
            while (curr != null && curr.getInfo().compareTo(item) < 0) {
                curr = curr.getNext();
            }

            // Duplicate check
            if (curr != null && curr.getInfo().compareTo(item) == 0) {
                throw new IllegalArgumentException("Item already exists");
            }

            // Insert at end
            if (curr == null) {
                tail.setNext(newNode);
                newNode.setBack(tail);
                tail = newNode;
                size++;
            } else {
                // Insert before curr
                NodeType<T> prev = curr.getBack();
                newNode.setNext(curr);
                curr.setBack(newNode);
                newNode.setBack(prev);
                if (prev != null) {
                    prev.setNext(newNode);
                } else {
                    // inserting at head
                    head = newNode;
                }
                size++;
            }

        }

    }

    public int length() {
        return size;
    }

    public void print() {
        if (head == null) {
            return;
        }
        NodeType<T> curr = head;
        System.out.print("The list is: ");
        while (curr != null) {
            System.out.print(curr.getInfo() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public void printReverse() {
        if (head == null) {
            return;
        }
        NodeType<T> curr = tail;
        while (curr != null) {
            System.out.print(curr.getInfo() + " ");
            curr = curr.getBack();
        }
        System.out.println();
    }

    public void deleteSubsection(T lower, T upper) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }
        NodeType<T> curr = head;
        while (curr != null) {
            NodeType<T> next = curr.getNext();
            if (curr.getInfo().compareTo(lower) >= 0 && curr.getInfo().compareTo(upper) <= 0) {
                // deleteItem will update head/tail/size correctly
                deleteItem(curr.getInfo());
            }
            curr = next;
        }
    }

    public void reverseList() {
        // empty or single-element list: nothing to do
        if (head == null || head.getNext() == null) {
            return;
        }

        NodeType<T> curr = head;
        while (curr != null) {
            NodeType<T> temp = curr.getNext();
            curr.setNext(curr.getBack());
            curr.setBack(temp);
            curr = temp;
        }
        NodeType<T> temp = head;
        head = tail;
        tail = temp;
    }

    public void swapAlternate() {
        // empty or single-element list: nothing to do
        if (head == null || head.getNext() == null) {
            return;
        }

        NodeType<T> curr = head;
        while (curr != null && curr.getNext() != null) {
            NodeType<T> first = curr;
            NodeType<T> second = curr.getNext();

            NodeType<T> prev = first.getBack();
            NodeType<T> next = second.getNext();

            // Link prev to second
            if (prev != null) {
                prev.setNext(second);
            } else {
                head = second;
            }

            // Link next back to first
            if (next != null) {
                next.setBack(first);
            } else {
                tail = first;
            }

            // Swap first and second
            second.setBack(prev);
            second.setNext(first);
            first.setBack(second);
            first.setNext(next);

            // advance to the node after the swapped pair
            curr = first.getNext();
        }

    }

}
