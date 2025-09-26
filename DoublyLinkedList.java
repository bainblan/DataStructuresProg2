public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;

    public DoublyLinkedList() {
        head = null;
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
        if (head == null) {
            head = newNode;
            return;
        }
        if (head.getInfo().compareTo(item) > 0) {
            newNode.setNext(head);
            head.setBack(newNode);
            head = newNode;
            return;
        }
        NodeType<T> curr = head;
        while (curr.getNext() != null && curr.getNext().getInfo().compareTo(item) < 0) {
            curr = curr.getNext();
        }
        if (curr.getNext().getInfo().compareTo(item) == 0
                || curr.getNext() != null && curr.getInfo().compareTo(item) == 0) {
            throw new IllegalArgumentException("Can't insert duplicates");
        }
        newNode.setNext(curr.getNext());
        newNode.setBack(curr);
        if (curr.getNext() != null) {
            curr.getNext().setBack(newNode);
        }
        curr.setNext(newNode);
    }

    public int length() {
        int count = 0;
        NodeType<T> curr = head;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count;
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

    public void deleteSubsection(T lower, T upper) {}

    public DoublyLinkedList<T> reverseList() {}

}