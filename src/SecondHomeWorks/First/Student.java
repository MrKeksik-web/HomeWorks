package SecondHomeWorks.First;

import java.io.Serializable;

public class Student implements Serializable {
    private int points;
    private String name;
    private char gender;
    private short bithDate;

    public Student(int points) {
        this.points = points;
    }

    public Student(int points, String name, char gender, short bithDate) {
        this.points = points;
        this.name = name;
        this.gender = gender;
        this.bithDate = bithDate;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public short getBithDate() {
        return bithDate;
    }

    public void setBithDate(short bithDate) {
        this.bithDate = bithDate;
    }

    public int getPoints(){
        return points;
    }

    public String toString(){
        return "Student pints is " + points;
    }
}
