package SecondHomeWorks.Second;

import java.util.ArrayList;
import java.util.Comparator;

public class bubbleSorting<T> {
    private ArrayList<T> arr;
    private Comparator comparator;

    public bubbleSorting(Comparator comparator) {
        this.comparator = comparator;
    }

    public ArrayList<T> sort(ArrayList<T> arr){

        for (int i = 0; i < arr.size();i++){
            for (int j = 0; j < arr.size();j++){
                if (comparator.compare(arr.get(i),arr.get(j)) > 0) {
                    T t = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,t);
                }
            }
        }

        return arr;
    }
}
