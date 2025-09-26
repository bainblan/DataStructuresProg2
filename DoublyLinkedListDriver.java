import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {
    
    public static void main(String[] args) {
        DoublyLinkedList<T> list = new DoublyLinkedList<>();
        try (Scanner s = new Scanner(new File(args[0]))) {
            while (s.hasNext()) {
                list.insertItem(s.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        Scanner input = new Scanner(System.in);
        char command = ' ';
        System.out.println("Enter list type (i - int, d - double, s - string): ");
    }
}