package SixthHomeWorks;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

import AlgorithmsAndData.SecondHomeWorks.First.Set;

public class Map<K,V> extends AbstractMap<K,V> implements java.util.Map<K,V>{
    protected ArrayList<ArrayList<K>> keys;
    protected ArrayList<ArrayList<V>> values;
    private final int INITIAL_CAPACITY = 6;
    private int size;

    public Map() {
        values = new ArrayList<>(INITIAL_CAPACITY);
        keys = new ArrayList<>(INITIAL_CAPACITY);
        size = 0;

        for(int i = 0;i < INITIAL_CAPACITY;i++){
            values.add(i,new ArrayList<V>());
            keys.add(i,new ArrayList<K>());
        }
    }

    @Override
    public V put(K key, V value) throws NullPointerException{
        if(key == null || value == null){
            throw new NullPointerException();
        }

        ArrayList<K> entryKeys = keys.get(this.hash(key));
        ArrayList<V> entryValues = values.get(this.hash(key));

        for(int i = 0; i < entryKeys.size();i++){
            if(key.equals(entryKeys.get(i))){
                V oldValue = entryValues.get(i);
                entryValues.set(i,value);
                return oldValue;
            }
        }

        entryKeys.add(key);
        entryValues.add(value);

        size++;

        return null;
    }

    @Override
    public V remove(Object key) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        if(this.get(key) != null){
            int index = keys.get(hash((K)key)).indexOf(key);
            keys.get(hash((K)key)).remove(key);
            V val = values.get(hash((K)key)).get(index);
            values.get(hash((K)key)).remove(index);
            return val;
        }
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        if(this.get(key) != null){
            int indexVal = keys.get(hash((K)key)).indexOf((K)key);
            int indexKey = keys.get(hash((K)key)).indexOf((K)key);

            K thisKey = keys.get(hash((K)key)).get(indexKey);
            V val = values.get(hash((K)key)).get(indexVal);

            if(val == (V)value && key == thisKey){
                keys.get(hash((K)key)).remove(indexKey);
                values.get(hash((K)key)).remove(indexVal);
                return true;
            }
        }

        return false;
    }

    @Override
    public V get(Object key) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        ArrayList<K> arr = keys.get(hash((K)key));
        for(int i = 0;i < arr.size();i++){
            if(arr.get(i).equals((K)key)){
                return values.get(hash((K)key)).get(i);
            }
        }
        return null;
    }

    @Override
    public V replace(K key, V value) throws NullPointerException{
        if(key == null || value == null){
            throw new NullPointerException();
        }

        ArrayList<K> entryKeys = keys.get(hash((K)key));

        if(entryKeys.size() > 0){
            int index = entryKeys.indexOf(key);
            if(index == -1){
                return null;
            }
            if(entryKeys.get(index) != null){
                ArrayList<V> entryValues = values.get(hash((K)key));
                V oldVal = entryValues.get(index);
                entryValues.set(index,(V)value);
                return oldVal;
            }
        }
        return null;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) throws NullPointerException{
        if(key == null || oldValue == null || newValue == null){
            throw new NullPointerException();
        }

        ArrayList<K> entryKeys = keys.get(hash((K)key));

        if(entryKeys.size() > 0){
            int index = entryKeys.indexOf(key);
            if(index == -1){
                return false;
            }
            if(entryKeys.get(index) != null){
                ArrayList<V> entryValues = values.get(hash((K)key));
                if(entryValues.get(index) == oldValue){
                    entryValues.set(index,newValue);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        ArrayList<K> arr = keys.get(hash((K)key));

        if(arr.contains(key)){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) throws NullPointerException{
        if(value == null){
            throw new NullPointerException();
        }

        for(int i = 0;i < values.size();i++){
            for(int j = 0;j < values.get(i).size();j++){
                if(values.get(i).get(j).equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public java.util.Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new Set<Entry<K,V>>();
        for(int i = 0;i < keys.size();i++){
            for(int j = 0; j < values.get(i).size();j++){
                int finalI = i;
                int finalJ = j;
                Entry<K,V> entry = new Entry<K, V>() {
                    private K key = keys.get(finalI).get(finalJ);
                    private V value;

                    @Override
                    public K getKey() {
                        return key;
                    }

                    @Override
                    public V getValue() {
                        return value;
                    }

                    @Override
                    public V setValue(V value) {
                        V oldVal = this.value;
                        this.value = value;
                        return oldVal;
                    }

                    public String toString(){
                        String str = key + " - " + value;
                        return str;
                    }
                };
                entry.setValue(values.get(i).get(j));

                set.add(entry);
            }
        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        return (java.util.Set<Entry<K, V>>) set;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Map<?, ?> map = (Map<?, ?>) o;
        return Objects.equals(keys, map.keys) &&
                Objects.equals(values, map.values);
    }

    public int hash(K key){
        return Objects.hash(key) % INITIAL_CAPACITY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keys);
    }

    @Override
    public void clear() {
        this.keys.clear();
        this.values.clear();
    }

    @Override
    public java.util.Set<K> keySet() {
        Set<K> set = new Set<>();

        for(int i = 0;i < keys.size();i++){
            ArrayList<K> arr = keys.get(i);
            for(int j = 0;j < arr.size();j++){
                set.add(arr.get(j));
            }
        }

        return (java.util.Set<K>) set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> set = (Collection<V>) new Collection<K>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<K> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(K k) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends K> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        for(int i = 0;i < values.size();i++){
            ArrayList<V> arr = values.get(i);
            for(int j = 0;j < arr.size();j++){
                set.add(arr.get(j));
            }
        }

        return set;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        if(false){
            throw new CloneNotSupportedException();
        }

        Map<K,V> map = new Map<>();
        map.keys = (ArrayList<ArrayList<K>>) this.keys.clone();
        map.values = (ArrayList<ArrayList<V>>) this.values.clone();

        return map;
    }

    @Override
    public String toString() {
        String str = "{ ";
        for(int i = 0;i < keys.size();i++){
            String subStr = "[ ";
            for(int j = 0;j < keys.get(i).size();j++){
                subStr += "( " + keys.get(i).get(j) + " " + values.get(i).get(j) + " ), ";
            }
            subStr += "], ";
            str += subStr;
        }

        return str+"}";
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Map<Integer,Integer> map = new Map<>();

        map.put(1,5);
        map.put(2,6);
        map.put(3,7);
        map.put(4,8);
        map.put(5,9);

        System.out.println(map);

        System.out.println(map.replace(5,8,4));
        System.out.println(map);

        System.out.println(map.clone());
    }
}
