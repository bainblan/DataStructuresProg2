
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver program for the DoublyLinkedList project. Prompts the user for a list
 * type int, double, or string, and an input file containing values of that
 * type. The values are read from the file and inserted into a
 * DoublyLinkedList. The user can then interactively issue commands to modify
 * the list.
 */
public class DoublyLinkedListDriver {

    /**
     * Driver program for the DoublyLinkedList project.
     *
     * Usage: java DoublyLinkedListDriver &lt;input file&gt;
     * The program prompts for a list type (i/d/s) and then accepts interactive
     * commands.
     *
     * @param args command-line arguments (args[0] should be the input filename)
     */
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
                    && command != 'l' && command != 't' && command != 'r'
                    && command != 's' && command != 'b') {
                System.out.print("Invalid command try again: ");
                command = input.next().charAt(0);
            }
            runCommands(command, input, list, type);
        }
        input.close();
    }

    /**
     * Execute the command specified by 'command' on the given list, using input as
     * needed.
     * 
     * @param command
     * @param input
     * @param list
     * @param type
     */
    public static void runCommands(char command, Scanner input, DoublyLinkedList list, String type) {
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

    /**
     * Handle the insert command. Prompts the user for a value of the correct
     * type, inserts it into the list, and prints the list forwards and in
     * reverse.
     *
     * @param input Scanner to read user input
     * @param list  the DoublyLinkedList to operate on
     * @param type  a string indicating the value type
     *              ("number","double","string")
     */
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

    /**
     * Handle the delete command. Prompts the user for a value, deletes it from
     * the list (if present), and prints the list forwards and in reverse.
     *
     * @param input Scanner to read user input
     * @param list  the DoublyLinkedList to operate on
     * @param type  a string indicating the value type
     *              ("number","double","string")
     */
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

    /**
     * Handle the print command: print the list forwards.
     *
     * @param input Scanner (unused)
     * @param list  the DoublyLinkedList to print
     * @param type  the current data type (unused)
     */
    public static void pCalled(Scanner input, DoublyLinkedList list, String type) {
        list.print();
    }

    /**
     * Handle the length command: print the number of elements in the list.
     *
     * @param input Scanner (unused)
     * @param list  the DoublyLinkedList to query
     * @param type  the current data type (unused)
     */
    public static void lCalled(Scanner input, DoublyLinkedList list, String type) {
        System.out.println("The length of the list is: " + list.length());
    }

    /**
     * Handle the print-reverse command: print the list from tail to head.
     *
     * @param input Scanner (unused)
     * @param list  the DoublyLinkedList to print
     * @param type  the current data type (unused)
     */
    public static void tCalled(Scanner input, DoublyLinkedList list, String type) {
        list.printReverse();
    }

    /**
     * Handle the reverse command: reverse the list in-place and print it.
     *
     * @param input Scanner (unused)
     * @param list  the DoublyLinkedList to reverse
     * @param type  the current data type (unused)
     */
    public static void rCalled(Scanner input, DoublyLinkedList list, String type) {
        list.reverseList();
        list.printReverse();
    }

    /**
     * Handle the "b" command which deletes a subsection of the list between
     * user-provided lower and upper bounds (inclusive). The bounds are read as
     * the current data type.
     *
     * @param input Scanner used to read bounds
     * @param list  the DoublyLinkedList to modify
     * @param type  the current data type ("number","double","string")
     */
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

    /**
     * Handle the swap-alternate command: swap each adjacent pair of nodes, then
     * print the list and its reverse.
     *
     * @param input Scanner (unused)
     * @param list  the DoublyLinkedList to operate on
     * @param type  the current data type (unused)
     */
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
