
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
            throw new IllegalArgumentException("List is empty");
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
            // Find the first node >= item (or null if we reach the end)
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
        while (curr.getNext() != null) {
            if (curr.getInfo().compareTo(lower) >= 0 && curr.getInfo().compareTo(upper) <= 0) {
                deleteItem(curr.getInfo());
            }
            curr = curr.getNext();

        }
    }

    public void reverseList() {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
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
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        } else if (head.getNext() == null) {
            return;
        }

        NodeType<T> curr = head;
        while (curr != null && curr.getNext() != null) {
            NodeType<T> first = curr;
            NodeType<T> second = curr.getNext();

            //Connect last pair
            if (first.getBack() != null) {
                first.getBack().setNext(second);
            } else {
                head = second;
            }

            //Connect next pair
            if (second.getNext() != null) {
                second.getNext().setBack(first);
            } else {
                tail = first;
            }

            first.setNext(second.getNext());
            second.setBack(first.getBack());
            second.setNext(first);
            first.setBack(second);

            curr = first.getNext();
        }

    }

}
