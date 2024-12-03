package deque;

import org.hamcrest.Factory;

import java.util.Objects;

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

    public int cap() {
        return cap;
    }

    public void addFirst(T item) {
        if (size == cap) {
            resizeUp();
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
            resizeUp();
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
        } else if (cap / size >= 4) {
            resizeDown();
        }

        if (firstNext + 1 >= cap) {
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
        } else if (cap / size >= 4) {
            resizeDown();
        }

        if (lastNext - 1 < 0) {
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque)) {
            return false;
        } else if (((ArrayDeque<?>) o).size != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(((ArrayDeque<?>) o).get(i), get(i))) {
                return false;
            }
        }

        return true;
    }

    private void resizeUp() {
        T[] newArr = (T[]) new Object[cap * 2];

        for (int i = 0; i < size; i++) {
            newArr[i] = get(i);
        }

        firstNext = cap * 2 - 1;
        lastNext = size;
        cap = cap * 2;
        items = newArr;
    }

    private void resizeDown() {
        T[] newArr = (T[]) new Object[cap / 2];

        for (int i = 0; i < size; i++) {
            newArr[i] = get(i);
        }

        firstNext = cap/2-1;
        lastNext = size;
        cap = cap / 2;
        items = newArr;
    }
}
