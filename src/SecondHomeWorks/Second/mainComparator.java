package SecondHomeWorks.Second;

import SecondHomeWorks.First.Man;

import java.util.Comparator;

public class mainComparator implements Comparator<Man> {
    @Override
    public int compare(Man o1, Man o2) {
        return o1.getAge() - o2.getAge();
    }
}
