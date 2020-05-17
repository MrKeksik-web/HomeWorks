package AlgorithmsAndData.SecondHomeWorks.First;

public class MultiSet<T> extends Set<T> implements setInterface<T>{
    private int size;
    private int capacity;
    private count[] arr;

    public class count<T>{
        private T value;
        private int count;

        public count(T value) {
            this.value = value;
            this.count = 1;
        }

        public void counterPlus(){
            count++;
        }

        public void counterMinus(){
            count--;
        }

        public int getCount(){
            return count;
        }

        public T getValue(){
            return value;
        }
    }

    public MultiSet() {
        this.size = 0;
        this.capacity = 5;
        this.arr = new count[capacity];
    }

    private void increase(){
        this.capacity += 100;
        count[] newArray = new count[capacity];

        for (int i = 0; i < size;i++){
            newArray[i] = this.arr[i];
        }

        this.arr = newArray;
    }

    @Override
    public boolean add(T elem){
        if (this.capacity - this.size <= 0){
            increase();
        }
        if (this.has(elem)) {
            arr[arrayIndex(elem)].counterPlus();
        }
        arr[size] = new count<>(elem);
        size++;
        return true;
    }

    private int arrayIndex(T elem){
        for (int i = 0;i < size;i++) {
            if (arr[i].getValue() == elem) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean has(T elem) {
        for (int i = 0;i < size;i++) {
            if (arr[i].getValue() == elem) {
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    private void shift(int index){
        for (int i = index;i < size;i++){
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public boolean remove(T elem){
        for (int i = 0;i < size;i++) {
            if (arr[i].getValue().equals(elem)) {
                if (arr[i].getCount() == 1) {
                    this.shift(i);
                    size--;
                } else {
                    arr[i].counterMinus();
                }
            }
        }
        return false;
    }

    @Override
    public Set merge(Set set){
        for (int i = 0;i < set.size();i++) {
            this.add((T)set.arr[i]);
        }
        return this;
    }

    @Override
    public boolean contains(Set set) {
        for (int i = 0;i < set.size();i++) {
            if (!this.has((T)set.arr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String s = "[ ";

        for (int i = 0;i < size;i++) {
            s += arr[i] + ", ";
        }

        return s + " ]";
    }


    public static void main(String[] args) {
        MultiSet<Integer> set = new MultiSet<>();

        set.add(1);
        set.add(2);
        set.add(1);
        set.add(1);

        System.out.println(set.arr[0].getValue() + " " + set.arr[0].getCount());

        set.remove(1);

        System.out.println(set.arr[0].getValue() + " " + set.arr[0].getCount());
    }
}
