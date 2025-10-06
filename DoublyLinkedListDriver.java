import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        char command = input.next().charAt(0);
        
        try (Scanner s = new Scanner(new File(args[0]))) {
            switch (command) {
                case 'i': {
                    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
                    while (s.hasNext()) {
                        list.insertItem(Integer.parseInt(s.next()));
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
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
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
            if (command == 'q') {
                System.out.println("Exiting the program...");
            } else if (command == 'i') {
                iCalled(input, list);
            } else if (command == 'd') {
                dCalled(input, list);
            } else if (command == 's') {
                sCalled(input, list);
            } else if (command == 'a') {
                aCalled(input, list);
            } else if (command == 'm') {
                mCalled(input, list);
            } else if (command == 't') {
                tCalled(input, list);
            } else if (command == 'p') {
                System.out.print("The list is: ");
                list.printList();
            } else if (command == 'l') {
                System.out.println("The length of the list is " + list.getLength());
            }
        }
        input.close();
    }

    public static void dCalled(Scanner input, DoublyLinkedList list) {

    }

    public static void iCalled(Scanner input, DoublyLinkedList list) {

    }

    public static void sCalled(Scanner input, DoublyLinkedList list) { 

    }

    public static void mCalled(Scanner input, DoublyLinkedList list) { 

    }

    public static void aCalled(Scanner input, DoublyLinkedList list) { 
    
    }

    public static void tCalled(Scanner input, DoublyLinkedList list) { 

    }
}