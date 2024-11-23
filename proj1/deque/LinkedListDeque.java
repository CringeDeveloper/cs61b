package deque;

public class LinkedListDeque {
    static class Node {
        public int item = 0;
        public Node next = null;
        public Node prev = null;

        public Node(int i, Node p, Node n) {
            prev = p;
            next = n;
            item = i;
        }
    }

    private Node sentinelFront;
    private Node sentinelBack;
    private int size;

//    public LinkedListDeque(int x) {
//        sentinel = new Node(42, null, null);
//        sentinel.next = new Node(x, null, null);
//
//        size = 1;
//    }
    public LinkedListDeque() {
        sentinelFront = new Node(42, null, null);
        sentinelBack = new Node(42, null, null);
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

    public void addFirst(int x) {
        sentinelFront.next = new Node(x, sentinelFront, sentinelFront.next);
        sentinelFront.next.next.prev = sentinelFront.next;
        size += 1;
    }

    public void addLast(int x) {
        sentinelBack.prev = new Node(x, sentinelBack.prev, sentinelBack);
        sentinelBack.prev.prev.next = sentinelBack.prev;

        size += 1;
    }
}
