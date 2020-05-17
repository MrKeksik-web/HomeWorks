package ThirdHomeWorks.Fourth;

import FirstHomeWorks.Second.exceptions.ArrayEmptyException;
import FirstHomeWorks.Second.exceptions.IOExeption;
import FirstHomeWorks.Second.interfaces.Inter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * This class implements a dynamic array
 * Each ArrayList instance has a capacity. The capacity is the size of the array used to store the elements in the list. It is always at least as large as the list size. As elements are added to an ArrayList, its capacity grows automatically. The details of the growth policy are not specified beyond the fact that adding an element has constant amortized time cost.
 * @author Александров Дмитрий
 * @version 1.1
 * @since 1.0
 */

public class EndlessArrayIterable<T> implements Inter<T>, Iterable<T> {
    private static final int INITIAL_SIZE = 10;
    private final int STEP = 5;
    private int size;
    private int capacity;
    private Object[] arr;

    /**
     * Constructs an empty list with an initial capacity of ten.
     * @throws IOExeption if the specified initial capacity is negative
     */
    public EndlessArrayIterable() throws IOExeption {
        this(INITIAL_SIZE);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param capacity - the initial capcity of the EdnlessArray
     * @throws IOExeption if the specified initial capacity is negative
     */
    public EndlessArrayIterable(int capacity) throws IOExeption {
        if (capacity < 0) {
            throw new IOExeption("Input or Output error");
        }
        this.size = capacity;
        this.capacity = capacity;
        this.arr = new Object[this.size];
    }

    /**
     * Creates a list containing the elements of a sequence
     * @param args - sequence of elements
     */
    public EndlessArrayIterable(T ...args){
        int length = args.length;
        this.size = length - 1;
        this.capacity = length - 1;
        this.arr = new Object[this.size];
        for (int i = 0; i < length; i++){
            this.add(args[i]);
        }
    }

    private void expansion(){
        Object [] arrCopy = this.arr;
        this.size +=this.STEP;
        this.capacity +=this.STEP;
        this.arr = new Object[this.size];
        for (int i = 0; i  < arrCopy.length; i++){
            arr[i] = arrCopy[i];
        }
    }

    /**
     * Inserts the specified element in this EndlessArray
     * @param element - the element to be inserted
     */
    public void add(T element){
        if (this.capacity <= 0){
            this.expansion();
        }
        this.arr[this.getLength()] = element;
        this.capacity -=1;
    }

    /**
     * Removes an element from the end of the array
     * @throws ArrayEmptyException if the index is out of range
     * @return the element that was removed from the EndlessArray
     */
    public T remove() throws ArrayEmptyException {
        if (this.isEmpty()) {
            throw new ArrayEmptyException("Out of memory");
        }
        this.capacity +=1;
        return (T)this.arr[this.getLength()];
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the left
     * @param index - the index of the element to be removed
     * @throws ArrayEmptyException if the index is out of range
     * @return the element that was removed from the list
     */
    public T remove(int index) throws ArrayEmptyException {
        if (this.isEmpty()) {
            throw new ArrayEmptyException("Out of memory");
        }
        Object element = this.arr[index];
        for (int i = index + 1; i < this.getLength();i++){
            this.arr[i - 1] = this.arr[i];
        }
        this.arr[this.getLength()] = 0;
        this.capacity +=1;
        return (T) element;
    }

    /**
     * Returns the element at the specified position in this EndlessArray.
     * @param index - index of the element to return
     * @throws IndexOutOfBoundsException - if the index is out of range
     * @return Returns the element at the specified position in this list.
     */
    public T getFromIndex(int index) throws IndexOutOfBoundsException{
        if (index >= 0 && index < this.getLength()){
            return (T)this.arr[index];
        }
        throw new IndexOutOfBoundsException("index out of bounds");
    }

    /**
     * Returns the index of the first occurrence of the specified element in this EndlessArray, or -1 if this list does not contain the element.
     * @param element - element to search for
     * @return the index of the first occurrence of the specified element in this EndlessArray, or -1 if this list does not contain the element
     */
    public int indexOf(T element){
        for (int i = 0; i < this.getLength(); i++){
            if (this.arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this EndlessArray, or -1 if this list does not contain the element.
     * @param element - element to search for
     * @param fromIndex - the index from which the search will begin
     * @return the index of the first occurrence of the specified element in this EndlessArray, or -1 if this list does not contain the element
     */
    public int indexOf(T element,int fromIndex){
        if (fromIndex > this.getLength()){
            return -1;
        }

        for (int i = fromIndex; i < this.getLength(); i++){
            if (this.arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    public boolean isEmpty(){
        if (this.getLength() == 0){
            return true;
        }
        return false;
    }

    /**
     * Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists are defined to be equal if they contain the same elements in the same order.
     * This implementation first checks if the specified object is this list. If so, it returns true; if not, it checks if the specified object is a list. If not, it returns false; if so, it iterates over both lists, comparing corresponding pairs of elements. If any comparison returns false, this method returns false. If either iterator runs out of elements before the other it returns false (as the lists are of unequal length); otherwise it returns true when the iterations complete.
     * {@inheritDoc} equals in class Object
     * @param o - the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndlessArrayIterable that = (EndlessArrayIterable) o;
        return this.compareArrays(that);
    }

    private boolean compareArrays(EndlessArrayIterable firstArr){
        if(this.getLength() != firstArr.getLength()){
            return false;
        }
        for(int i = 0; i < this.getLength(); i++){
            if (this.getFromIndex(i) != firstArr.getFromIndex(i)){
                return false;
            }
        }
        return true;
    }

    private Object[] toCutArray(){
        Object[] modified = new Object[this.getLength()];
        for (int i = 0; i < this.getLength();i++) {
            modified[i] = this.getFromIndex(i);
        }
        return modified;
    }

    /**
     * Returns the hash code value for this list.
     * {@inheritDoc} hashCode in class Object
     * @return the hash code value for this list
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(INITIAL_SIZE, STEP, size, capacity);
        result = 31 * result + Arrays.hashCode(this.toCutArray());
        return result;
    }

    /**
     * Returns a string representation of this array
     * {@inheritDoc} toString in class Object
     * @return a string representation of this collection
     */
    @Override
    public String toString() {
        return "com.EndlessArray{" +
                ", size=" + size +
                ", arr=" + Arrays.toString(this.toCutArray()) +
                '}';
    }

    /**
     * Calculates and returns the length of the array
     * @return Returns the length of the array
     */
    public int getLength(){
        return this.size - this.capacity;
    }

    public static void main(String[] args) throws IOExeption {
        EndlessArrayIterable arr = new EndlessArrayIterable();
    }

    @Override
    public Iterator<T> iterator() {
        return new ThirdHomeWorks.Third.EndlessArrayIterator(this);
    }
}
