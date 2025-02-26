import java.util.Stack;
import java.util.Scanner;
import java.util.Collections;

/**
 * Main Class. This class serves as an entry point to the methods implemented.
 */
public class Main {

    /**
     * Constructor. Creates an empty stack.
     * Asks user to input the integers that need to be sorted.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Maintenance change: Update stack variables.
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        System.out.print("Enter the numbers you wish to add (separated by spaces), then press enter: ");
        String inputLine = scanner.nextLine();

        /**
         * While loop intended to collect the numbers entered for sorting until the user submits 'done'.
         * Uses a space to separate the numbers entered.
         * Converts the string collected into integers.
         * Includes error handling to only accept inputs that are in integer format.
         */
        while (!inputLine.equalsIgnoreCase("done")) {
            String[] numbers = inputLine.split("\\s+");

            for (String numStr : numbers) {
                try {
                    int number = Integer.parseInt(numStr);
                    insertSorted(tempStack, number);  // Maintenance Change: Use tempStack vs sortedList.
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + numStr + ". Please enter integers only.");
                }
            }

            System.out.print("Add more numbers (separated by spaces), or enter 'done' to sort your list: ");
            inputLine = scanner.nextLine();
        }

        /**
         * Outputs the sorted list.
         */
        System.out.println("Sorted Stack (Smallest to Largest): ");
        while (!tempStack.isEmpty()) {
            System.out.println(tempStack.pop());
        }
        
        scanner.close();
    }

    /**
     * Method to insert a number in sorted order into a stack.
     * @param stack The stack to insert into.
     * @param num The number to insert.
     */
    private static void insertSorted(Stack<Integer> stack, int num) {
        Stack<Integer> temp = new Stack<>();

        // Maintenance Change: Stack implementation: move int to temp stack until correct position is found.
        while (!stack.isEmpty() && stack.peek() > num) {
            temp.push(stack.pop());
        }

        stack.push(num);  // Maintenance Change: Insert int. 

        // Maintenance Change: Push back remaining int.
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
