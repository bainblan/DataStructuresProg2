
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        char command = input.next().charAt(0);
        // make list visible to the later command handling switch
        DoublyLinkedList list = null;

        try (Scanner s = new Scanner(new File(args[0]))) {

            switch (command) {
                case 'i': {
                    list = new DoublyLinkedList<Integer>();
                    while (s.hasNext()) {
                        list.insertItem(Integer.parseInt(s.next()));
                        System.out.println("");
                    }
                    break;
                }
                case 'd': {
                    list = new DoublyLinkedList<Double>();
                    while (s.hasNext()) {
                        list.insertItem(Double.parseDouble(s.next()));
                    }
                    break;
                }
                case 's': {
                    list = new DoublyLinkedList<String>();
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

        // if no list was created (invalid type or file error), exit to avoid NPEs
        if (list == null) {
            System.out.println("No list available. Exiting.");
            input.close();
            return;
        }

        while (command != 'q') {
            System.out.print("Enter command: ");
            command = input.next().charAt(0);
            while (command != 'q' && command != 'i' && command != 'd' && command != 'p'
                    && command != 'l' && command != 'm' && command != 't'
                    && command != 's' && command != 'a') {
                System.out.print("Invalid command try again: ");
                command = input.next().charAt(0);
            }
            switch (command) {
                case 'q':
                    System.out.println("Exiting the program...");
                    break;
                case 'i':
                    iCalled(input, list);
                    break;
                case 'd':
                    dCalled(input, list);
                    break;
                case 's':
                    sCalled(input, list);
                    break;
                case 'a':
                    aCalled(input, list);
                    break;
                case 'm':
                    mCalled(input, list);
                    break;
                case 't':
                    tCalled(input, list);
                    break;
                case 'p':
                    System.out.print("The list is: ");
                    list.print();
                    break;
                case 'l':
                    System.out.println("The length of the list is " + list.length());
                    break;
                default:
                    break;
            }
        }
        input.close();
    }

    public static void dCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("dCalled executed");
    }

    public static void iCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("iCalled executed");
    }

    public static void sCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("sCalled executed");
    }

    public static void mCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("mCalled executed");
    }

    public static void aCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("aCalled executed");
    }

    public static void tCalled(Scanner input, DoublyLinkedList list) {
        System.out.println("tCalled executed");
    }
}
