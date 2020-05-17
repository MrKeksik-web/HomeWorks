package TenthHomeWorks.DataWriter;

import SecondHomeWorks.First.Student;

import java.io.*;
import java.nio.ByteBuffer;

public class DataStudentInputStreamDecorator extends InputStream {
    DataInputStream inputStream;

    public DataStudentInputStreamDecorator(InputStream inputStream) {
        this.inputStream = new DataInputStream(inputStream);
    }

    public Student readStudent() throws IOException{
        int point = inputStream.readInt();
        byte nameLength = inputStream.readByte();
        String name = "";
        for(int j = 0;j < nameLength;j++){
            name += inputStream.readChar();
        }
        char gender = inputStream.readChar();
        short date = inputStream.readShort();

        return new Student(point,name,gender,date);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public void readFully(byte[] b) throws IOException {
        inputStream.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        inputStream.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return inputStream.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return inputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return inputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return inputStream.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return inputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return inputStream.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return inputStream.readChar();
    }

    public int readInt() throws IOException {
        return inputStream.readInt();
    }

    public long readLong() throws IOException {
        return inputStream.readLong();
    }

    public float readFloat() throws IOException {
        return inputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return inputStream.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return inputStream.readLine();
    }

    public String readUTF() throws IOException {
        return inputStream.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }

    public static void main(String[] args) {
        try(DataStudentInputStreamDecorator in = new DataStudentInputStreamDecorator(new FileInputStream("D:\\input.txt"));) {
            Student st = in.readStudent();
            System.out.println(st.getPoints());
            System.out.println(st.getName());
            System.out.println(st.getGender());
            System.out.println(st.getBithDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
