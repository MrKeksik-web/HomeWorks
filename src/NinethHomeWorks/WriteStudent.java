package NinethHomeWorks;

import SecondHomeWorks.First.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class WriteStudent {
    public static void writeStudent(ArrayList<Student> students){
        try(FileOutputStream out = new FileOutputStream("D:\\students.txt")){
            for(int i = 0;i < students.size();i++){
                ByteBuffer bb = ByteBuffer.allocate(4+1+students.get(i).getName().length()*2+2+2);

                bb.putInt(students.get(i).getPoints());
                bb.put((byte) students.get(i).getName().length());
                for(int j = 0;j < students.get(i).getName().length();j++){
                    bb.putChar(students.get(i).getName().charAt(j));
                }
                bb.putChar(students.get(i).getGender());
                bb.putShort(students.get(i).getBithDate());
                out.write(bb.array());
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        Student st1 = new Student(98,"Dima",'M', (short) 2001);
        Student st2 = new Student(94,"Alexander",'M', (short) 2005);
        Student st3 = new Student(100,"Lena",'F', (short) 1999);
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);

        writeStudent(arr);
    }
}
