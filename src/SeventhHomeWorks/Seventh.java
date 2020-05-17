package SeventhHomeWorks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Seventh {
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put(1,0);
        map.put(2,1);
        map.put(3,2);

        map.keySet().stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        System.out.println(map.keySet());
    }
}
