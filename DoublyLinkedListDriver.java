
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        char command = input.next().charAt(0);

        if (args.length != 1) {
            System.out.println("Please provide a valid command.");
            return;
        }

        try (Scanner s = new Scanner(new File(args[0]))) {

            switch (command) {
                case 'i': {
                    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
                    while (s.hasNext()) {
                        list.insertItem(Integer.parseInt(s.next()));
                        System.out.println("");
                    }
                    break;
                }
                case 'd': {
                    DoublyLinkedList<Double> list = new DoublyLinkedList<>();
                    while (s.hasNext()) {
                        list.insertItem(Double.parseDouble(s.next()));
                    }
                    break;
                }
                case 's': {
                    DoublyLinkedList<String> list = new DoublyLinkedList<>();
                    while (s.hasNext()) {
                        list.insertItem(s.next());
                    }
                    break;
                }
                default:
                    System.out.println("Invalid type entered!");
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        input.close();
    }
}
