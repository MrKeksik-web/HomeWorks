package SeventhHomeWorks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sixth {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("Arturka");
        s.add("AAAAA");
        s.add("ABAV");
        s.add("BBB");
        s.add("Dmitry");
        s.add("UPOIPO");

        String str =  "aeiouAEIOU";

        s.stream()
                .filter(elem -> {
                    char[] arr = elem.toCharArray();
                    int count = 0;
                    for(int i = 0;i < arr.length;i++){
                        if(str.indexOf(arr[i]) != -1){
                            count++;
                        }
                    }
                    if(count > 3) {
                        return true;
                    }
                    return false;
                })
                .forEach(System.out::println);
    }
}
