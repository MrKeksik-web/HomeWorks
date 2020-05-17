package ThirdHomeWorks.Sixth;

import java.util.Iterator;
import java.util.Random;

public class randomIterator implements Iterator {
    private Random rnd;
    private int epsilon;

    public randomIterator(int epsilon){
        this.epsilon = epsilon;
        this.rnd = new Random();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Double next() {
        return rnd.nextDouble()*epsilon;
    }

    public static void main(String[] args) {
        randomIterator iterator = new randomIterator(100);

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
