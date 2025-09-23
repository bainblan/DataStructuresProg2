public class DoublyLinkedListDriver {
    
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertItem(10);
        list.insertItem(20);
        list.insertItem(30);
        list.print(); // Expected: 10 20 30
        list.printReverse(); // Expected: 30 20 10
        System.out.println("Length: " + list.length()); // Expected: Length: 3
        list.deleteItem(20);
        list.print(); // Expected: 10 30
        System.out.println("Length: " + list.length()); // Expected: Length: 2
    }
}