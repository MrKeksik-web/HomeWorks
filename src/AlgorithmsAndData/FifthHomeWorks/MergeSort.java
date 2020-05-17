package AlgorithmsAndData.FifthHomeWorks;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort<T> {
    Comparator comparator;

    public MergeSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    private ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right){
        ArrayList<T> mergedArr = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while(left.size() > leftIndex && right.size() > rightIndex){
            if(comparator.compare(left.get(leftIndex),right.get(rightIndex)) < 0){
                mergedArr.add(left.get(leftIndex));
                leftIndex++;
            } else{
                mergedArr.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        for(int i = leftIndex;i < left.size();i++){
            mergedArr.add(left.get(i));
        }
        for(int i = rightIndex;i < right.size();i++){
            mergedArr.add(right.get(i));
        }

        return mergedArr;
    }

    public ArrayList<T> mergeSort(ArrayList<T> arr){
        if(arr.size() < 2){
            return arr;
        } else{
            ArrayList<T> left = new  ArrayList<T>();
            ArrayList<T> right = new ArrayList<T>();
            for(int i = 0;i < arr.size()/2;i++){
                left.add(arr.get(i));
            }
            for(int i = arr.size()/2;i < arr.size();i++){
                right.add(arr.get(i));
            }
            left = mergeSort(left);
            right = mergeSort(right);
            ArrayList<T> sortedArr = merge(left,right);
            return sortedArr;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(5);
        arr.add(-4);
        arr.add(1);
        arr.add(10);
        arr.add(-11);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(-11);
        arr.add(-11);
        arr.add(0);
        arr.add(0);
        arr.add(-11);
        arr.add(1300);
        arr.add(-1000);
        arr.add(1020);
        arr.add(-1010);

        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

        MergeSort mergeSort = new MergeSort(comparator);
        arr = mergeSort.mergeSort(arr);

        for(int i = 0;i < arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}
