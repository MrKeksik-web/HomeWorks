package TenthHomeWorks.ObjectWriter;

import SecondHomeWorks.First.Student;
import TenthHomeWorks.DataWriter.DataStudentInputStreamDecorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectStudentInputStreamDecorator extends InputStream {
    ObjectInputStream inputStream;

    public ObjectStudentInputStreamDecorator(InputStream inputStream) throws IOException {
        this.inputStream = new ObjectInputStream(inputStream);
    }

    public Student readStudent() throws IOException, ClassNotFoundException {
        return (Student) inputStream.readObject();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public static void main(String[] args) {
        try(ObjectStudentInputStreamDecorator in = new ObjectStudentInputStreamDecorator(new FileInputStream("D:\\input.txt"));) {
            Student student = in.readStudent();

            System.out.println(student.getPoints());
            System.out.println(student.getName());
            System.out.println(student.getGender());
            System.out.println(student.getBithDate());

            Student student1 = in.readStudent();

            System.out.println(student1.getPoints());
            System.out.println(student1.getName());
            System.out.println(student1.getGender());
            System.out.println(student1.getBithDate());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
