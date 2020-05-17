package FourthHomeWorks.First.changeableCollection;

import java.util.*;

public class changeableCollection<T> extends AbstractCollection<T> {
    private int size;
    private Object[] arr;
    private int capacity;
    private final int STEP = 10;

    public changeableCollection() {
        this.capacity = 5;
        this.size = 0;
        arr = new Object[capacity];
    }

    public changeableCollection(Collection<T> arr) {
        this.capacity = arr.size() + 10;
        this.size = arr.size();

        Iterator iterator = arr.iterator();
        int i = 0;
        this.arr = new Object[arr.size()];

        while (iterator.hasNext()) {
            this.arr[i++] = iterator.next();
        }
    }

    private void increase(){
        Object [] arrCopy = this.arr;
        this.capacity +=this.STEP;
        this.arr = new Object[this.capacity];
        for (int i = 0; i  < arrCopy.length; i++){
            arr[i] = arrCopy[i];
        }
    }

    public boolean add(T elem){
        if (size == capacity - 1) {
            increase();
        }
        this.arr[size++] = elem;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new changeableCollectionIterator(this.arr,this.size);
    }

    @Override
    public int size() {
        return capacity - size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        changeableCollection<?> that = (changeableCollection<?>) o;

        if(size != that.size){
            return false;
        }

        Iterator thisIterator = this.iterator();
        Iterator thatIterator = that.iterator();

        while(thisIterator.hasNext()){
            if(thatIterator.next() != thatIterator.next()){
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
        changeableCollection<Integer> arr = new changeableCollection<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        Iterator iterator = arr.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
