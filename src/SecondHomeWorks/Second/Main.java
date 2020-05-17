package SecondHomeWorks.Second;

import SecondHomeWorks.Second.bubbleSorting;
import SecondHomeWorks.First.Man;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Man m1 = new Man(15);
        Man m2 = new Man(18);

        ArrayList<Man> arr = new ArrayList<Man>();

        arr.add(new Tatarin(50));
        arr.add(new Man(11));
        arr.add(new Tatarin(18));
        arr.add(new Man(24));
        arr.add(new Tatarin(33));

        mainComparator comparator = new mainComparator();

        bubbleSorting sort = new bubbleSorting(comparator);

        System.out.println(sort.sort(arr));
    }
}
