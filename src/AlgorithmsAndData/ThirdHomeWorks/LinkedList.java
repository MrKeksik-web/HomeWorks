package AlgorithmsAndData.ThirdHomeWorks;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Objects;

public class LinkedList<T> {
    private Node head;
    private int size;

    public LinkedList() {
    }

    public LinkedList(T elem) {
        this.head = new Node(elem);
        size = 0;
    }

    public void addFirst(T elem){
        Node<T> node = new Node<>(elem,this.head);
        this.head = node;
        size++;
    }

    public void addLast(T elem){
        Node<T> node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new Node(elem);
        size++;
    }

    public void add(T elem){
        addLast(elem);
        size++;
    }

    public void addAfter(T elem,int index) throws IndexOutOfBoundsException{
        int counter = 0;
        Node node = head;

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        while (node.next != null && counter < index) {
            counter++;
            node = node.next;
        }

        if (node.next == null && index > size){
            throw new IndexOutOfBoundsException();
        } else {
            Node nextNode = node.next;
            node.next = new Node(elem);
            node.next.next = nextNode;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        int counter = 0;
        Node node = head;

        if (index > size){
            return null;
        }

        while(node.next != null && counter < index) {
            counter++;
            node = node.next;
        }

        return (T)node.value;
    }

    public boolean remove(T elem) {
        Node node = head;
        Node prev = node;
        int count = 0;

        while(node.next != null && node.value != elem) {
            prev = node;
            node = node.next;
            count++;
        }

        if (count == 0) {
            head = node.next;
        }

        if (node.next == null && node.value != elem) {
            return false;
        }

        Node nextNode = node.next;
        prev.next = nextNode;
        return true;
    }

    public boolean remove(int index){
        if (index > size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        Node node = head;
        Node prev = node;
        int count = 0;

        while(node.next != null && count < index) {
            prev = node;
            node = node.next;
            count++;
        }

        if (node.next == null && count != size) {
            return false;
        }

        Node nextNode = node.next;
        prev.next = nextNode;
        return true;
    }

    public LinkedList<T> merge(LinkedList<T> list){
        Node node = head;

        while(node.next != null) {
            node = node.next;
        }

        node.next = list.head;

        return this;
    }

    public String toString(){
        String str = "";
        Node<T> node = head;

        while (node.next != null) {
            str += node.value + " ";
            node = node.next;
        }

        return str + node.value;
    }

    public int indexOf(T elem){
        Node node = head;
        int count = 0;

        while(node.next != null && node.value != elem){
            node = node.next;
            count++;
        }

        if(node.next == null && node.value != elem){
            return -1;
        }

        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;

        if (this.size != that.size) {
            return false;
        }

        for(int i = 0;i < this.size;i++){
            if (this.get(i) != that.get(i)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> arr = new LinkedList<>(3);

        arr.addFirst(2);
        arr.addLast(4);
        arr.addFirst(1);

        System.out.println(arr);

        System.out.println(arr.size() + "s");

        arr.addAfter(5,0);

        System.out.println(arr);

        arr.addAfter(6,arr.size());

        System.out.println(arr);

        System.out.println(arr.get(arr.size()));

        System.out.println(arr.remove(6));
        System.out.println(arr);

        LinkedList<Integer> arr2 = new LinkedList<>();
        arr2.addFirst(7);
        arr2.add(8);

        LinkedList<Integer> ans = arr.merge(arr2);

        System.out.println(ans);

        System.out.println(ans.indexOf(9));

        System.out.println(ans.equals(arr2));

        LinkedList<Integer> arr3 = new LinkedList<Integer>();
        arr3.addFirst(7);
        arr3.add(8);

        System.out.println(arr3.equals(arr2));
    }
}
