package FourthHomeWorks.First.changeableCollection;

import java.util.*;

public class changeableCollectionIterator implements Iterator{
    private int cursor;
    private Object[] col;
    private int size;
    private int index;

    public changeableCollectionIterator(Object[] col,int size) {
        this.cursor = 0;
        this.col = col;
        this.size = size;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (cursor < size) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() throws NoSuchElementException{
        if (index <= size - 1) {
            index++;
            return col[cursor++];
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove(){
        col[cursor--] = null;
    }
}
