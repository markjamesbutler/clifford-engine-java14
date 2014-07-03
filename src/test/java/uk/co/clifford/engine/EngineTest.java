package uk.co.clifford.engine;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class EngineTest {

    @Test
    public void testCompute() throws Exception {

        assertComputationIsCorrect(new Integer[] {0, 2, 0, 2, 2}, 4);
        assertComputationIsCorrect(new Integer[] {0, 5, 0, 3, 3}, 2);
        assertComputationIsCorrect(new Integer[] {0, 10, 0, 5, 5}, 2);
        assertComputationIsCorrect(new Integer[] {0, 10, 0, 10, 4}, 100);
        assertComputationIsCorrect(new Integer[] {0, 10, 0, 7, 0, 3, 1, 2}, 17);
        assertComputationIsCorrect(new Integer[] {0, 10, 0, 5, 4, 0, 2, 5}, 25);
        assertComputationIsCorrect(new Integer[] {0, -3, 0, -1, 2}, -4);
        assertComputationIsCorrect(new Integer[] {0, 60, 0, 10, 3, 0, 180, 0, 3, 5, 4, 0, 4, 2}, 3004);

    }

    private static void assertComputationIsCorrect(Integer[] values, int outcome) {

        Deque deque = addValuesToDeque(values);
        int result = new Engine().compute(deque, new ArrayDeque<>());

        assertEquals(outcome, result);
    }

    private static Deque addValuesToDeque(Integer[] values) {

        Deque deque = new ArrayDeque<Integer>();
        deque.addAll(Arrays.asList(values));

        return deque;
    }

}