package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    private static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    private static class AbsoluteValueComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return Integer.compare(Math.abs(a), Math.abs(b));
        }
    }

    @Test
    public void testEmptyDeque() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        assertNull(deque.max());
        assertNull(deque.max(new AbsoluteValueComparator()));
    }

    @Test
    public void testSingleElement() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        deque.addFirst(5);
        assertEquals(Integer.valueOf(5), deque.max());
    }

    @Test
    public void testMultipleElements() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        deque.addLast(1);
        deque.addLast(3);
        deque.addLast(2);
        assertEquals(Integer.valueOf(3), deque.max());
    }

    @Test
    public void testDifferentComparators() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        deque.addLast(-5);
        deque.addLast(3);
        deque.addLast(-2);

        assertEquals(Integer.valueOf(3), deque.max());
        assertEquals(Integer.valueOf(-5), deque.max(new AbsoluteValueComparator()));
    }
}
