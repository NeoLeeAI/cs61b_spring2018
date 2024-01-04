public class ArrayDeque <T> {
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

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[other.size() + 1];
        size = other.size();
        for(int i = 0; i < other.size(); i++) {
            items[i] = (T) other.get(i);
        }
        nextFirst = items.length - 1;
        nextLast = items.length - 1;
    }

    public void resize() {
        T[] temp = (T []) new Object[size * 2];
        for(int i = 0; i < size; i++) {
            temp[i] = get(i);
        }
        items = temp;
        nextFirst = items.length - 1;
        nextLast = size - 1;
    }

    public void downSize() {

    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int start = (nextFirst + 1) % items.length;
        for(int i = start; i != nextLast; i = (i + 1) % items.length) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T item = get(nextFirst);
        items[nextFirst] = null;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T item = get(nextLast);
        items[nextLast] = null;
        size -= 1;
        return item;
    }

    public T get(int index) {

        return items[(nextFirst + 1 + index) % items.length];
    }
}
