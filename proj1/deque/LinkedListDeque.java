package deque;

public class LinkedListDeque<T> {
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

//    public LinkedListDeque(t x) {
//        sentinel = new Node(42, null, null);
//        sentinel.next = new Node(x, null, null);
//
//        size = 1;
//    }
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node temp = sentinelFront.next;

        for(int i = 0; i < size; i++) {
            System.out.print(temp.item + " ");
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
}
