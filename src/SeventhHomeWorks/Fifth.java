package SeventhHomeWorks;

import java.util.*;

public class Fifth {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 1, 3));

        list1.stream()
                .filter(elem -> elem > Collections.max(list2))
                .forEach(System.out::println); //output 2 6 10 14
    }
}
