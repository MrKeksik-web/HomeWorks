package AlgorithmsAndData.SecondHomeWorks.First;

public interface setInterface<T> {
    boolean add(T elem);
    boolean has(T elem);
    int size();
    boolean remove(T elem);

    Set merge(Set set);
    boolean contains(Set set);
}
