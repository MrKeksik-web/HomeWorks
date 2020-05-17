package ThirdHomeWorks.Third;

import FirstHomeWorks.Second.exceptions.IOExeption;
import ThirdHomeWorks.Fourth.EndlessArrayIterable;

import java.util.Iterator;

public class EndlessArrayIterator<T> implements Iterator<T> {
    private int cursor;
    private EndlessArrayIterable<T> arr;

    public EndlessArrayIterator(EndlessArrayIterable<T> arr) {
        this.arr = arr;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if (cursor < arr.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        return arr.getFromIndex(cursor++);
    }

    public static void main(String[] args) throws IOExeption {
        EndlessArrayIterable<Integer> arr = new EndlessArrayIterable<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        EndlessArrayIterator iterator = new EndlessArrayIterator(arr);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
