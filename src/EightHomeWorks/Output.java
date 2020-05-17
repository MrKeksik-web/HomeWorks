package EightHomeWorks;

import java.io.*;

public class Output {
    public static void main(String[] args) {

        try(FileOutputStream in = new FileOutputStream(new File("D:/input.txt"))) {
            int i = 567;
            char c = 'Б';

            in.write(i>>24);
            in.write(i>>16);
            in.write(i>>8);
            in.write(i>>0);

            in.write(c>>8);
            in.write(c>>0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
