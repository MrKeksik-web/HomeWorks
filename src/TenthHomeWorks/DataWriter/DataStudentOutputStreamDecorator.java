package TenthHomeWorks.DataWriter;

import SecondHomeWorks.First.Student;

import java.io.*;

public class DataStudentOutputStreamDecorator extends OutputStream {
    DataOutputStream outputStream;

    public DataStudentOutputStreamDecorator(OutputStream inputStream) {
        this.outputStream = new DataOutputStream(inputStream);
    }

    public void studentWrite(Student student) throws IOException{
        outputStream.writeInt(student.getPoints());
        outputStream.writeByte(student.getName().length());
        outputStream.writeChars(student.getName());
        outputStream.writeChar(student.getGender());
        outputStream.writeShort(student.getBithDate());
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public static void main(String[] args) {
        try(DataStudentOutputStreamDecorator out = new DataStudentOutputStreamDecorator(new FileOutputStream("D:\\input.txt"))) {
            Student student = new Student(98,"Dima",'M', (short) 2001);
            out.studentWrite(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
