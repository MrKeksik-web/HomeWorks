package SixteenthHomeWorks;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataDownload {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String str = inn.nextLine();
        final Pattern PATTERN_TO_IMAGE = Pattern.compile("(.jpg|.png|.jpeg|.gif)$");
        URLConnection conn;
        try {
            URL url = new URL(str);
            conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            Matcher matcher = PATTERN_TO_IMAGE.matcher(str);
            FileOutputStream out;
            if(matcher.find()){
                out = new FileOutputStream("output" + matcher.group());
            } else {
                out = new FileOutputStream("output.txt");
            }

            int ch ;
            while((ch = bis.read()) != -1) {
                out.write(ch);
            }
            bis.close();
            out.flush();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
