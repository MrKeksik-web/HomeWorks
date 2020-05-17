package FirstHomeWorks.Third;

public class Man implements Comparable<Man>{
    private Integer age;

    public Integer getAge(){
        return age;
    }

    @Override
    public int compareTo(Man o) {
        return this.getAge().compareTo(o.getAge());
    }
}
