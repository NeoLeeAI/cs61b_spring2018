public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void upSize() {
        T[] a = (T []) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void downSize() {
        T[] a = (T []) new Object[(int) (items.length * 0.5)];
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int first = (nextFirst + 1) % items.length;
        for (; first != nextLast; first = (first + 1) % items.length) {
            System.out.print(items[first] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if ((size <= items.length * 0.25) && (size != 0)) {
            downSize();
        }
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if ((size <= items.length * 0.25) && (size != 0)) {
            downSize();
        }
        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1 || size == 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }
}
