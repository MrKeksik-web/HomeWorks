package SeventhHomeWorks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Eighth {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("qwfgsd");
        arr.add("qwfsd");
        arr.add("qwfgs");
        arr.add("qwf");
        arr.add("qwfgsd");
        arr.add("qwfgskkll");
        arr.add("qfgd");
        arr.add("qsd");

        long length = arr.stream()
                .filter(elem -> elem.toString().length() > 5)
                .map(elem -> elem.toString().length())
                .reduce(0, (acc, x) -> acc + x);

        System.out.println(length);
    }
}
