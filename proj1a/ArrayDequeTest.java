/** Performs some basic array tests. */
public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 40; i++) {
            ad1.addLast(i);
        }
        // should not be empty
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        for (int i = 0; i < 40; i++) {
            ad1.removeLast();
        }
        // should be empty
        passed = checkEmpty(true, ad1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    /** Adds a few things, checking get() is correct. **/
    public static void addGetTest() {
        System.out.println("Running add/get test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 40; i++) {
            ad1.addLast(i);
        }
        //should be true
        boolean passed = true;
        for (int i = 0; i < 40; i++) {
            passed = (i == ad1.get(i)) && passed;
        }
        printTestStatus(passed);
    }

    public static void randomRemoveAddTest() {
        System.out.println("Running random add/remove test.");
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        ad1.addLast(0);

        boolean passed = (ad1.removeFirst() == 0);

        ad1.addFirst(2);

        ad1.addFirst(3);

        ad1.addLast(4);

        passed = (ad1.get(1) == 2) && passed;

        passed = (ad1.removeLast()  == 4) && passed;

        passed = (ad1.get(1)  == 2) && passed;

        ad1.addLast(8);

        passed = (ad1.get(2)  == 8) && passed;

        passed = (ad1.removeFirst() == 3) && passed;

        passed = (ad1.removeLast() == 8) && passed;

        ad1.addLast(12);

        passed = (ad1.removeFirst() == 2) && passed;

        passed = (ad1.removeLast() == 12) && passed;

        ad1.addLast(15);

        passed = (ad1.removeFirst() == 15) && passed;

        ad1.addFirst(17);

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        addGetTest();
        randomRemoveAddTest();
    }
}
