package AlgorithmsAndData.SecondHomeWorks.First;

import java.util.Iterator;
import java.util.Map;

public class Set<T> implements setInterface<T> {
    private int size;
    private int capacity;
    protected Object[] arr;

    public Set() {
        this.size = 0;
        this.capacity = 5;
        this.arr = new Object[capacity];
    }

    private void increase(){
        this.capacity += 100;
        Object[] newArray = new Object[capacity];

        for (int i = 0; i < size;i++){
            newArray[i] = this.arr[i];
        }

        this.arr = newArray;
    }

    @Override
    public boolean add(T elem){
        if (this.capacity - this.size <= 0){
            increase();
        }
        if (this.has(elem)) {
            return false;
        }
        arr[size] = elem;
        size++;
        return true;
    }

    @Override
    public boolean has(T elem) {
        for (int i = 0;i < size;i++) {
            if (arr[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    private void shift(int index){
        for (int i = index;i < size;i++){
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public boolean remove(T elem){
        for (int i = 0;i < size;i++) {
           if (arr[i].equals(elem)) {
                this.shift(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Set merge(Set set){
        for (int i = 0;i < set.size();i++) {
            if (!this.has((T)set.arr[i])) {
                this.add((T)set.arr[i]);
            }
        }
        return this;
    }

    @Override
    public boolean contains(Set set) {
        for (int i = 0;i < set.size();i++) {
            if (!this.has((T)set.arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String s = "[ ";

        for (int i = 0;i < size;i++) {
            s += arr[i] + ", ";
        }

        return s + " ]";
    }

    public Iterator iterator(){
        return new Iterator() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                if(cursor < size){
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                try {
                    return arr[cursor++];
                } catch (ArrayIndexOutOfBoundsException e){
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        };
    }

    public static void main(String[] args) {
        Set<Integer> set = new Set<Integer>();

        set.add(5);
        set.add(6);
        set.add(7);

        System.out.println(set.toString());

        set.remove(6);
        System.out.println(set.toString());

        set.remove(8);
        System.out.println(set.toString());

        System.out.println(set.has(6));

        Set newSet = new Set();
        newSet.merge(set);
        System.out.println(newSet);

        newSet.add(6);

        System.out.println(set.contains(newSet));
    }
}
