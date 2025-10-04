
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
        while (curr != null && !curr.getInfo().equals(item)) {
            curr = curr.getNext();
        }
        if (curr == null) {
            throw new IllegalArgumentException("Item does not exist");
        }
        if (curr.getBack() != null) {
            curr.getBack().setNext(curr.getNext());
        } else {
            head = curr.getNext();
        }
        if (curr.getNext() != null) {
            curr.getNext().setBack(curr.getBack());
        }
    }

    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>();
        newNode.setInfo(item);
        NodeType<T> curr = head;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //Iterate
            while (curr.getNext() != null && curr.getInfo().compareTo(item) < 0) {
                if (curr.getInfo().compareTo(item) == 0) {
                    throw new IllegalArgumentException("Item already exists");
                }
                curr = curr.getNext();
            }

            //End Case
            if (curr.getInfo().compareTo(item) < 0) {
                curr.setNext(newNode);
                newNode.setBack(curr);
                tail = newNode;
                size++;
                return;
            } else {
                //Main Case
                curr.getBack().setNext(newNode);
                newNode.setBack(curr.getBack());
                newNode.setNext(curr);
                curr.setBack(newNode);
            }

        }

    }

    public int length() {
        return size;
    }

    public void print() {
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
        NodeType<T> curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        while (curr != null) {
            System.out.print(curr.getInfo() + " ");
            curr = curr.getBack();
        }
        System.out.println();
    }

    public void deleteSubsection(T lower, T upper) {
    }

    public DoublyLinkedList<T> reverseList() {
        return null;
    }

}
