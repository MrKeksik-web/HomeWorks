package SecondHomeWorks.First;

import javax.rmi.CORBA.StubDelegate;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getPoints() - o2.getPoints();
    }

    public static void main(String[] args) {
        Student st1 = new Student(10);
        Student st2 = new Student(8);

        StudentComparator s1  = new StudentComparator();

        System.out.println(s1.compare(st1,st2));
    }
}
