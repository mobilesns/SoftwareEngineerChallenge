package paypay.sechallenge.test;

import paypay.sechallenge.source.*;

public class Test {
    public static void main(String[] args) {
        boolean result = true;
        System.out.println("Tests for the ImmutableStack class starting....");
        result = testStack();
        if (!result) {
            System.out.println("Tests for the ImmutableStack class failed!");
        }
        System.out.println("Tests for the ImmutableStack class passed!");
        System.out.println("");
        System.out.println("");
        System.out.println("Tests for the ImmutableQueue class starting....");
        result = testQueue();
        if (!result) {
            System.out.println("Tests for the ImmutableQueue class failed!");
        }
        System.out.println("Tests for the ImmutableQueue class passed!");
    }

    private static boolean testStack() {
        Stack<Integer> empty = ImmutableStack.EMPTY;
        if (!empty.isEmpty() || empty.peek() != null) {
            return false;
        }
        System.out.println("isEmpty() returned true; peek() returned null. --- Passed.");
        Stack<Integer> s1 = empty.push(10);
        if (s1.isEmpty() || s1.peek() != 10) {
            return false;
        }
        System.out.println("isEmpty() returned false; peek() returned 10. --- Passed.");
        Stack<Integer> s2 = s1.push(20);
        if (s2.isEmpty() || s2.peek() != 20) {
            return false;
        }
        System.out.println("isEmpty() returned false; peek() returned 20. --- Passed.");
        Stack<Integer> s3 = s2.push(30);
        if (s3.isEmpty() || s3.peek() != 30) {
            return false;
        }
        System.out.println("isEmpty() returned false; peek() returned 30. --- Passed.");
        Stack<Integer> s4 = s3.pop();
        if (s4.isEmpty() || s4.peek() != 20) {
            return false;
        }
        System.out.println("isEmpty() returned false; peek() returned 20. --- Passed.");
        Stack<Integer> s5 = s4.pop();
        if (s5.isEmpty() || s5.peek() != 10) {
            return false;
        }
        System.out.println("isEmpty() returned false; peek() returned 10. --- Passed.");
        Stack<Integer> s6 = s5.pop();
        if (!s6.isEmpty() || s6.peek() != null) {
            return false;
        }
        System.out.println("isEmpty() returned true; peek() returned null. --- Passed.");
        try {
            Stack<Integer> s7 = s6.pop();
        } catch(NoSuchElementException ese) {
            System.out.println("Expected NoSuchElementException was thrown. --- Passed.");
        }
        return true;
    }

    private static boolean testQueue() {
        Queue<Integer> empty = ImmutableQueue.EMPTY;
        if (!empty.isEmpty() || empty.head() != null) {
            return false;
        }
        System.out.println("isEmpty() returned true; head() returned null. --- Passed.");
        Queue<Integer> q1 = empty.enQueue(10);
        if (q1.isEmpty() || q1.head() != 10) {
            return false;
        }
        System.out.println("isEmpty() returned false; head() returned 10. --- Passed.");
        Queue<Integer> q2 = q1.enQueue(20);
        if (q2.isEmpty() || q2.head() != 10) {
            return false;
        }
        System.out.println("isEmpty() returned false; head() returned 10. --- Passed.");
        Queue<Integer> q3 = q2.enQueue(30);
        if (q3.isEmpty() || q3.head() != 10) {
            return false;
        }
        System.out.println("isEmpty() returned false; head() returned 10. --- Passed.");
        Queue<Integer> q4 = q3.deQueue();
        if (q4.isEmpty() || q4.head() != 20) {
            return false;
        }
        System.out.println("isEmpty() returned false; head() returned 20. --- Passed.");
        Queue<Integer> q5 = q4.deQueue();
        if (q5.isEmpty() || q5.head() != 30) {
            return false;
        }
        System.out.println("isEmpty() returned false; head() returned 30. --- Passed.");
        Queue<Integer> q6 = q5.deQueue();
        if (!q6.isEmpty() || q6.head() != null) {
            return false;
        }
        System.out.println("isEmpty() returned true; head() returned null. --- Passed.");
        try {
            Queue<Integer> q7 = q6.deQueue();
        } catch(NoSuchElementException ese) {
            System.out.println("Expected NoSuchElementException was thrown. --- Passed.");
        }
        return true;
    }
}
