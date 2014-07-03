package uk.co.clifford.engine;

import java.util.*;

public class Engine {

    private static Operation addition = (a, b) -> a + b;
    private static Operation subtraction = (a, b) -> - a + b;
    private static Operation multiplication = (a, b) -> a * b;
    private static Operation division = (a, b) -> b / a;

    private static DequeOperation pop = (a) -> a.pop();
    private static DequeOperation stackAddition = (a) -> a.push(addition.apply(a.pop(), a.pop()));
    private static DequeOperation stackSubtraction = (a) -> a.push(subtraction.apply(a.pop(), a.pop()));
    private static DequeOperation stackMultiplication = (a) -> a.push(multiplication.apply(a.pop(), a.pop()));
    private static DequeOperation stackDivision = (a) -> a.push(division.apply(a.pop(), a.pop()));

    interface Operation {

        int apply(Integer a, Integer b);

    }

    interface DequeOperation {

        void apply(Deque<Integer> a);
    }

    static HashMap<Integer, DequeOperation> operations = new HashMap<>();

    static
    {
        operations.put(1, pop);
        operations.put(2, stackAddition);
        operations.put(3, stackSubtraction);
        operations.put(4, stackMultiplication);
        operations.put(5, stackDivision);
    }

    public int compute(Deque<Integer> stack, Deque<Integer> queue) {

        if (stack.size() == 0 && queue.size() == 1)
            return queue.pop();

        Integer x = stack.pop();

        if (x == 0)
            queue.push(stack.pop());
        else
            operations.get(x).apply(queue);

        return compute(stack, queue);
    }

    public static void main(String[] args) {

        Deque deque = new ArrayDeque();

        for (String arg: args) {
            deque.push(Integer.valueOf(arg));
        }

        int result  = new Engine().compute(deque, new ArrayDeque<>());

        System.out.println("Result: " + result);
        System.out.println("Hex Result: " + Integer.toHexString(result));

    }
}