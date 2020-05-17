package SecondHomeWorks.Second;

import java.util.ArrayList;
import java.util.List;

public class Man{
    private String name;
    private int age;

    public Man(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return getAge()+"";
    }

    public void setAge(int age) {
        this.age = age;
    }
}
