package deque;

public class ArrayDeque<T> {
    T[] items;
    int size;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addLast(T item) {
        items[size] = item;

        size += 1;
    }

    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }

        return items[index];
    }
}
