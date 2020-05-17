package ThirdHomeWorks.Fifth;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIteratorLeftRight<T> implements Iterator<T> {
    private Object[] arr;
    private int cursor;
    private int way;

    public ArrayIteratorLeftRight(Object[] arr) {
        this.arr = arr;
        way = 1;
    }

    @Override
    public boolean hasNext() {
        if (this.arr.length % 2 == 0) {
            if (cursor < this.arr.length / 2) {
                return true;
            }
            return false;
        } else {
            if (cursor < this.arr.length / 2 ) {
                return true;
            } else if (cursor == this.arr.length / 2 && way == 1) {
                return true;
            }
            return false;
        }
    }

    @Override
    public T next() {
        try {
            if (way == 1) {
                way = -1;
                return (T)arr[cursor];
            }
            way = 1;
            return (T) arr[arr.length - 1 - cursor++];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[5];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;

        ArrayIteratorLeftRight<Integer> iterator = new ArrayIteratorLeftRight<>(arr);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
