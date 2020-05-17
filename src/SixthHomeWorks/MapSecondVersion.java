package SixthHomeWorks;

import java.util.*;

public class MapSecondVersion<K,V> extends AbstractMap<K,V> implements java.util.Map<K,V>{
    private ArrayList<K> keys;
    private ArrayList<V> values;
    private int size;

    public MapSecondVersion() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.size = 0;
    }

    public MapSecondVersion(MapSecondVersion map) {
        for(int i = 0;i < this.keys.size();i++){
            this.keys.add((K) map.keys.get(i));
            this.values.add((V) map.values.get(i));
        }
        this.size = map.size;
    }

    @Override
    public V put(K key, V value) throws NullPointerException{
        if(key == null || value == null){
            throw new NullPointerException();
        }
        if(keys.indexOf(key) == -1){
            keys.add(key);
            values.add(value);
            size++;
            return null;
        }

        int index = keys.indexOf(key);
        V oldVal = values.get(index);
        keys.add(index,key);
        values.add(index,value);
        return oldVal;
    }

    @Override
    public V remove(Object key) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        int index = keys.indexOf(key);

        if(index != -1){
            V oldVal = values.get(index);
            keys.remove(index);
            values.remove(index);
            size--;
            return oldVal;
        }

        return null;
    }

    @Override
    public boolean remove(Object key, Object value) throws NullPointerException{
        if(key == null){
            throw new NullPointerException();
        }

        int index = keys.indexOf(key);

        if(index != -1){
            if(keys.get(index) == key && values.get(index) == value){
                keys.remove(index);
                values.remove(index);
                size--;
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
        int index = keys.indexOf(key);
        if(index != -1){
            return values.get(index);
        }
        return null;
    }

    @Override
    public V replace(K key, V value) throws NullPointerException{
        if(key == null || value == null){
            throw new NullPointerException();
        }
        int index = keys.indexOf(key);
        if(index != -1){
            V oldVal = values.get(index);
            values.set(index,value);
            return oldVal;
        }
        return null;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) throws NullPointerException{
        if(key == null || oldValue == null || newValue == null){
            throw new NullPointerException();
        }
        int index = keys.indexOf(key);
        if(index != -1){
            if(values.get(index) == oldValue){
                values.set(index,newValue);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(Object key) throws NullPointerException, NoSuchElementException{
        if(size() == 0){
            throw new NoSuchElementException();
        }
        if(key == null){
            throw new NullPointerException();
        }
        if(keys.indexOf(key) != -1){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) throws NullPointerException, NoSuchElementException{
        if(size() == 0){
            throw new NoSuchElementException();
        }
        if(value == null){
            throw new NullPointerException();
        }
        if(values.indexOf(value) != -1){
            return true;
        }
        return false;
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
    public void clear() {
        this.keys.clear();
        this.values.clear();
        this.size = 0;
    }

    @Override
    public java.util.Set<K> keySet() {
        AlgorithmsAndData.SecondHomeWorks.First.Set<K> set = new AlgorithmsAndData.SecondHomeWorks.First.Set<>();

        for(int i = 0;i < keys.size();i++){
            set.add(keys.get(i));
        }

        return (java.util.Set<K>) set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> set = new Collection<V>() {
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
            public Iterator<V> iterator() {
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
            public boolean add(V v) {
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
            public boolean addAll(Collection<? extends V> c) {
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
            set.add(values.get(i));
        }

        return set;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MapSecondVersion<K,V> map = new MapSecondVersion<K,V>();
        map.keys =  this.keys;
        map.values =  this.values;

        return map;
    }

    @Override
    public String toString() {
        String str = "[";
        for(int i = 0;i < keys.size();i++){
            str += keys.get(i) + " - " + values.get(i) + ", ";
        }
        return str + " ]";
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MapSecondVersion<Integer,Integer> map = new MapSecondVersion<>();

        map.put(1,5);
        map.put(2,6);
        map.put(3,7);
        map.put(4,8);
        map.put(5,9);

        System.out.println(map);

        System.out.println(map.replace(5,9,4));
        System.out.println(map);

        map.remove(3);
        System.out.println(map);

        System.out.println(map.clone());
    }
}
