package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.defaultComparator = c;
    }

    public T max() {
        return max(defaultComparator);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxElement = get(0);
        for (int i = 1; i < size(); i++) {
            T currentElement = get(i);
            if (c.compare(currentElement, maxElement) > 0) {
                maxElement = currentElement;
            }
        }
        return maxElement;
    }
}