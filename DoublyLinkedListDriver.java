
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        char command = input.next().charAt(0);

        try (Scanner s = new Scanner(new File(args[0]))) {
            if (command == 'i') {
                DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
                while (s.hasNext()) {
                    list.insertItem(Integer.parseInt(s.next()));
                }
            } else if (command == 'd') {
                DoublyLinkedList<Double> list = new DoublyLinkedList<>();
                while (s.hasNext()) {
                    list.insertItem(Double.parseDouble(s.next()));
                }
            } else if (command == 's') {
                DoublyLinkedList<String> list = new DoublyLinkedList<>();
                while (s.hasNext()) {
                    list.insertItem(s.next());
                }
            } else {
                System.out.println("Invalid type entered!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        input.close();
    }
}
