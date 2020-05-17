package NinethHomeWorks;

import SecondHomeWorks.First.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ReadStudent {
    public static void readStudent(){
        try(FileInputStream in = new FileInputStream("D:\\students.txt")){
            ArrayList<Student> students = new ArrayList<>();
            int bytes = in.available();
            ByteBuffer bb = ByteBuffer.allocate(bytes);
            int b = 0;
            while((b = in.read()) != -1){
                bb.put((byte)b);
            }

            bb.rewind();

            for(int i = 0;i < bytes;i++){
                int point = bb.getInt();
                byte nameLength = bb.get();
                String name = "";
                for(int j = 0;j < nameLength;j++){
                    name += bb.getChar();
                }
                char gender = bb.getChar();
                short date = bb.getShort();
                students.add(new Student(point,name,gender,date));
                bytes -= (4 + 1 + nameLength*2 + 2 + 2);
            }
            System.out.println(students.get(0).getPoints());
            System.out.println(students.get(0).getName());
            System.out.println(students.get(0).getGender());
            System.out.println(students.get(0).getBithDate());
            System.out.println(students.get(1).getPoints());
            System.out.println(students.get(1).getName());
            System.out.println(students.get(1).getGender());
            System.out.println(students.get(1).getBithDate());
            System.out.println(students.get(2).getPoints());
            System.out.println(students.get(2).getName());
            System.out.println(students.get(2).getGender());
            System.out.println(students.get(2).getBithDate());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readStudent();
    }
}
