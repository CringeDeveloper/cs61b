package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int firstNext;
    private int lastNext;
    private int cap;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        firstNext = 0;
        lastNext = 1;
        cap = 8;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (size == cap) {
            resize();
        }
        items[firstNext] = item;

        if (firstNext == 0) {
            firstNext = cap - 1;
        } else {
            firstNext -= 1;
        }

        size += 1;
    }

    public void addLast(T item) {
        if (size == cap) {
            resize();
        }
        items[lastNext] = item;

        if (lastNext == cap - 1) {
            lastNext = 0;
        } else {
            lastNext += 1;
        }

        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (firstNext + 1 >= cap) {
            firstNext = 0;
        } else {
            firstNext += 1;
        }

        size -= 1;
        return items[firstNext];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (lastNext - 1 < 0) {
            lastNext = cap - 1;
        } else {
            lastNext -= 1;
        }

        size -= 1;
        return items[lastNext];
    }

    public T get(int index) {
        if (firstNext + index + 1 >= cap) {
            return items[Math.abs(cap - firstNext - index - 1)];
        }

        return items[index + firstNext + 1];
    }


    public void resize() {
        T[] newArr = (T[]) new Object[cap * 2];

        int i = 0;
        while (i < lastNext) {
            newArr[i] = items[i];
            i++;
        }

        int j = lastNext + cap;
        while (i < cap) {
            newArr[j] = items[i];
            j++;
            i++;
        }

        firstNext = firstNext + cap;
        cap = cap * 2;
        items = newArr;
    }
}
