
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter list type (i - int, d - double, s - string): ");
        String type = "";
        char command = input.next().charAt(0);
        // make list visible to the later command handling switch
        DoublyLinkedList list = null;

        try (Scanner s = new Scanner(new File(args[0]))) {

            switch (command) {
                case 'i': {
                    list = new DoublyLinkedList<Integer>();
                    type = "number";
                    while (s.hasNext()) {
                        list.insertItem(Integer.valueOf(s.next()));
                    }
                    break;
                }
                case 'd': {
                    list = new DoublyLinkedList<Double>();
                    type = "double";
                    while (s.hasNext()) {
                        list.insertItem(Double.valueOf(s.next()));
                    }
                    break;
                }
                case 's': {
                    list = new DoublyLinkedList<String>();
                    type = "string";
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
                    iCalled(input, list, type);
                    break;
                case 'd':
                    dCalled(input, list, type);
                    break;
                case 'p':
                    pCalled(input, list, type);
                    break;
                case 'l':
                    lCalled(input, list, type);
                    break;
                case 't':
                    tCalled(input, list, type);
                    break;
                case 'r':
                    rCalled(input, list, type);
                    break;
                case 'b':
                    bCalled(input, list, type);
                    break;
                case 's':
                    sCalled(input, list, type);
                    break;
                default:
                    break;
            }
        }
        input.close();
    }

    public static void iCalled(Scanner input, DoublyLinkedList list, String type) {
        list.print();
        System.out.println("Enter a " + type + " to insert: ");
        if (type.equals("number")) {
            Integer value = input.nextInt();
            list.insertItem(value);
        } else if (type.equals("double")) {
            Double value = input.nextDouble();
            list.insertItem(value);
        } else if (type.equals("string")) {
            String value = input.next();
            list.insertItem(value);
        }
        list.print();
        list.printReverse();
    }

    public static void dCalled(Scanner input, DoublyLinkedList list, String type) {
        list.print();
        System.out.println("Enter a " + type + " to delete: ");
        if (type.equals("number")) {
            Integer value = input.nextInt();
            list.deleteItem(value);
        } else if (type.equals("double")) {
            Double value = input.nextDouble();
            list.deleteItem(value);
        } else if (type.equals("string")) {
            String value = input.next();
            list.deleteItem(value);
        }
        list.print();
        list.printReverse();
    }

    public static void pCalled(Scanner input, DoublyLinkedList list, String type) {
        list.print();
    }

    public static void lCalled(Scanner input, DoublyLinkedList list, String type) {
        System.out.println("The length of the list is: " + list.length());
    }

    public static void tCalled(Scanner input, DoublyLinkedList list, String type) {
        list.printReverse();
    }

    public static void rCalled(Scanner input, DoublyLinkedList list, String type) {
        list.reverseList();
        list.printReverse();
    }

    public static void bCalled(Scanner input, DoublyLinkedList list, String type) {
        try {
            if (type.equals("number")) {
                System.out.println("Enter the lower bound: ");
                Integer lower = input.nextInt();
                System.out.println("Enter the upper bound: ");
                Integer upper = input.nextInt();

                System.out.print("The original list: ");
                list.print();
                list.deleteSubsection(lower, upper);
            } else if (type.equals("double")) {
                System.out.println("Enter the lower bound: ");
                Double lower = input.nextDouble();
                System.out.println("Enter the upper bound: ");
                Double upper = input.nextDouble();

                System.out.print("The original list: ");
                list.print();
                list.deleteSubsection(lower, upper);
            } else if (type.equals("string")) {
                System.out.println("Enter the lower bound: ");
                String lower = input.next();
                System.out.println("Enter the upper bound: ");
                String upper = input.next();

                System.out.print("The original list: ");
                list.print();
                list.deleteSubsection(lower, upper);
            } else {
                System.out.print("The original list: ");
                list.print();
                return;
            }

            System.out.print("The modified list: ");
            list.print();

            System.out.print("The reverse list: ");
            list.printReverse();
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot delete subsection: " + e.getMessage());
        }
    }

    public static void sCalled(Scanner input, DoublyLinkedList list, String type) {
        try {
            System.out.print("The original list: ");
            list.print();
            list.swapAlternate();
            System.out.print("The modified list: ");
            list.print();
            System.out.print("The reverse list: ");
            list.printReverse();
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot swap alternates: " + e.getMessage());
        }
    }
}
