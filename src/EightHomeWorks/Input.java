package EightHomeWorks;

import java.io.*;
import java.util.ArrayList;

public class Input {
    public static void main(String[] args) {

        try(FileInputStream in = new FileInputStream(new File("D:/input.txt"))) {
            int i = 0;
            char c = 0;

            i |=in.read()<<24;
            i |=in.read()<<16;
            i |=in.read()<<8;
            i |=in.read()<<0;

            c |=in.read()<<8;
            c |=in.read()<<0;

            System.out.println(i);
            System.out.println(c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
