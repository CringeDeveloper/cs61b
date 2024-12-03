package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void isEmpty() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        assertTrue(arr.isEmpty());
    }

    @Test
    public void size() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        assertEquals(0, arr.size());
    }

    @Test
    public void addLast() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        assertEquals(3, arr.size());
        assertFalse(arr.isEmpty());
    }

    @Test
    public void removeFirst() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);
        arr.addFirst(8);
        assertEquals(8, (int)arr.removeFirst());
        assertEquals(7, (int)arr.removeFirst());
        assertEquals(6, (int)arr.removeFirst());
        assertEquals(5, (int)arr.removeFirst());
        assertEquals(4, (int)arr.removeFirst());
        assertEquals(3, (int)arr.removeFirst());
        assertEquals(2, (int)arr.removeFirst());
        assertEquals(1, (int)arr.removeFirst());
        assertNull(arr.removeFirst());
        assertNull(arr.removeFirst());
        assertEquals(0, arr.size());
    }

    @Test
    public void removeLast() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addLast(5);
        arr.addLast(6);
        arr.addLast(7);
        arr.addLast(8);
        assertEquals(8, (int)arr.removeLast());
        assertEquals(7, (int)arr.removeLast());
        assertEquals(6, (int)arr.removeLast());
        assertEquals(5, (int)arr.removeLast());
        assertEquals(4, (int)arr.removeLast());
        assertEquals(3, (int)arr.removeLast());
        assertEquals(2, (int)arr.removeLast());
        assertEquals(1, (int)arr.removeLast());
        assertNull(arr.removeLast());
        assertNull(arr.removeLast());
        assertEquals(0, arr.size());
    }

    @Test
    public void add() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);
        arr.addFirst(8);
        assertEquals(8, arr.size());
        assertFalse(arr.isEmpty());
    }

    @Test
    public void get() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addFirst(5);
        arr.addFirst(4);
        arr.addFirst(3);
        arr.addFirst(2);
        arr.addFirst(1);
        arr.addFirst(0);
        arr.addLast(6);
        assertEquals(7, arr.size());
        assertEquals(0, (int) arr.get(0));
        assertEquals(1, (int) arr.get(1));
        assertEquals(2, (int) arr.get(2));
        assertEquals(3, (int) arr.get(3));
        assertEquals(4, (int) arr.get(4));
        assertEquals(5, (int) arr.get(5));
        assertEquals(6, (int) arr.get(6));
    }

    @Test
    public void resize() {
        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);
        arr.addFirst(8);
        assertEquals(8, arr.size());
        assertFalse(arr.isEmpty());
        arr.addFirst(1);
        assertEquals(9, arr.size());
        assertEquals(16, arr.cap());
    }
}
