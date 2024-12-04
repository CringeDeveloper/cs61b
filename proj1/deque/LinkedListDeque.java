package deque;

import java.util.Iterator;
import java.util.Objects;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    class Node {
        public T item = null;
        public Node next = null;
        public Node prev = null;

        public Node(T i, Node p, Node n) {
            prev = p;
            next = n;
            item = i;
        }
    }

    private Node sentinelFront;
    private Node sentinelBack;
    private int size;

    public LinkedListDeque() {
        sentinelFront = new Node(null, null, null);
        sentinelBack = new Node(null, null, null);
        sentinelFront.next = sentinelBack;
        sentinelBack.prev = sentinelFront;

        size = 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        Node temp = sentinelFront.next;

        for (int i = 0; i < size; i++) {
            System.out.print(temp.item.toString() + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public void addFirst(T x) {
        sentinelFront.next = new Node(x, sentinelFront, sentinelFront.next);
        sentinelFront.next.next.prev = sentinelFront.next;
        size += 1;
    }

    public void addLast(T x) {
        sentinelBack.prev = new Node(x, sentinelBack.prev, sentinelBack);
        sentinelBack.prev.prev.next = sentinelBack.prev;

        size += 1;
    }

    public T removeFirst() {
        if (sentinelFront.next == sentinelBack) {
            return null;
        }
        Node toDelete = sentinelFront.next;
        sentinelFront.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        toDelete.prev = null;
        toDelete.next = null;

        size -= 1;
        return toDelete.item;
    }

    public T removeLast() {
        if (sentinelBack.prev == sentinelFront) {
            return null;
        }
        Node toDelete = sentinelBack.prev;
        sentinelBack.prev = toDelete.prev;
        toDelete.prev.next = toDelete.next;
        toDelete.prev = null;
        toDelete.next = null;

        size -= 1;
        return toDelete.item;
    }

    public T get(int index) {
        if (index + 1 > size || index < 0) {
            return null;
        }

        Node temp = sentinelFront.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.item;
    }

    public T getRecursive(int index) {
        if (index + 1 > size || index < 0) {
            return null;
        }
        Node temp = sentinelFront.next;

        return getRecursiveIterator(index, temp);
    }

    private T getRecursiveIterator(int index, Node node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursiveIterator(index - 1, node.next);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        } else if (((LinkedListDeque<?>) o).size() != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(((LinkedListDeque<?>) o).get(i), get(i))) {
                return false;
            }
        }

        return true;
    }

    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private int seer;

        public  LinkedIterator() {
            int seer = 0;
        }

        public boolean hasNext() {
            return seer < size;
        }

        public T next() {
            T returnValue = get(seer);
            seer++;
            return returnValue;
        }
    }
}
