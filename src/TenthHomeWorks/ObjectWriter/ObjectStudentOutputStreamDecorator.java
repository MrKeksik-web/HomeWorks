package TenthHomeWorks.ObjectWriter;

import SecondHomeWorks.First.Student;
import TenthHomeWorks.DataWriter.DataStudentOutputStreamDecorator;

import java.io.*;

public class ObjectStudentOutputStreamDecorator extends OutputStream {
    ObjectOutputStream outputStream;

    public ObjectStudentOutputStreamDecorator(FileOutputStream outputStream) throws IOException {
        this.outputStream = new ObjectOutputStream(outputStream);
    }

    public void studentWrite(Student student) throws IOException{
        outputStream.writeObject(student);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public static void main(String[] args) {
        try(ObjectStudentOutputStreamDecorator out = new ObjectStudentOutputStreamDecorator(new FileOutputStream("D:\\input.txt"))) {
            Student student = new Student(98,"Dima",'M', (short) 2001);
            out.studentWrite(student);
            Student student1 = new Student(100,"Valeria",'F', (short) 1999);
            out.studentWrite(student1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
