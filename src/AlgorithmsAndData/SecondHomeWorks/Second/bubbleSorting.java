package AlgorithmsAndData.SecondHomeWorks.Second;

import SecondHomeWorks.First.Man;
import SecondHomeWorks.Second.mainComparator;

import java.util.ArrayList;
import java.util.Arrays;

public class bubbleSorting {
    public bubbleSorting(mainComparator comparator) {
    }

    public static int[] bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            boolean f = false;
            for (int j = 0; j  <arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    f = true;
                }
            }
            if (f == false) {
                break;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];

        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 50;
        arr[3] = 0;
        arr[4] = 43;

        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
