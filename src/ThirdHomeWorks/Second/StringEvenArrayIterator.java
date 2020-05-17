package ThirdHomeWorks.Second;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringEvenArrayIterator implements Iterator {
    private int cursor;
    private String[] data;

    public StringEvenArrayIterator(String[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        do {
            if (data[cursor + 2] != null && data.length > cursor) {
                return true;
            }
        } while (data[cursor + 2] == null && data.length > cursor);
        return false;
    }

    @Override
    public Object next() {
        try {
            do {
                if (data[cursor + 2] != null) {
                    cursor +=2;
                    return data[cursor];
                }
                cursor += 2;
            } while(data[cursor + 2] == null);
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        String[] str = new String[5];
        str[0] = "1";
        str[1] = "2";
        str[2] = null;
        str[3] = "4";
        str[4] = "5";

        StringEvenArrayIterator arr = new StringEvenArrayIterator(str);

        System.out.println(arr.next());
        System.out.println(arr.next());
        System.out.println(arr.next());
        System.out.println(arr.next());
        System.out.println(arr.next());
        System.out.println(arr.next());
        System.out.println(arr.next());
    }
}
