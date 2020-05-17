package FourthHomeWorks.First.unchangeableCollection;

import FourthHomeWorks.First.changeableCollection.changeableCollection;

import java.util.*;

public class unchangeableCollection<T> extends AbstractCollection<T> {
    private int size;
    private Object[] arr;
    private int capacity;

    private class collectionIterator<T> implements Iterator<T> {
        private int cursor;

        public collectionIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            if (cursor < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (cursor <= size - 1) {
                return (T) arr[cursor++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public boolean remove(T elem){
            for(int i = 0;i < size;i++) {
                if (arr[i] == elem) {
                    shift(i);
                    return true;
                }
            }
            return false;
        }
    }

    private void shift(int index){
        for (int i = index;i < size;i++){
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public unchangeableCollection() {
        this.capacity = 0;
        this.size = 0;
        arr = new Object[size];
    }

    public unchangeableCollection(Collection<T> arr) {
        this.capacity = arr.size();
        this.size = this.capacity;

        Iterator iterator = arr.iterator();
        int i = 0;
        this.arr = new Object[arr.size()];

        while (iterator.hasNext()) {
            this.arr[i++] = iterator.next();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new collectionIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        unchangeableCollection<?> that = (unchangeableCollection<?>) o;

        if(size != that.size){
            return false;
        }

        Iterator thisIterator = this.iterator();
        Iterator thatIterator = that.iterator();

        while(thisIterator.hasNext()){
            if(thisIterator.next() != thatIterator.next()){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> col = new ArrayList<>();
        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);

        unchangeableCollection<Integer> arr = new unchangeableCollection<Integer>(col);

        Iterator iterator = arr.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
