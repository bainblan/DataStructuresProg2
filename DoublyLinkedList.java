
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

}
