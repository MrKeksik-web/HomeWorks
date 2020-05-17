package FirstHomeWorks.Third;

public class Student implements Comparable<Student> {
    private Integer points;

    public Integer getPoints(){
        return points;
    }

    @Override
    public int compareTo(Student o) {
        return this.getPoints().compareTo(o.getPoints());
    }
}
