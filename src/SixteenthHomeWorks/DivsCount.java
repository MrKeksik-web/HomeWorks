package SixteenthHomeWorks;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DivsCount {
    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String str = inn.nextLine();
        Pattern pattern = Pattern.compile("<div(\\s[\\sa-zA-Z-\\-\\_]+[=][\"][\\sa-zA-Z\\-\\_]+[\"])*>");
        URLConnection conn;
        str = "https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html";
        try {
            URL url = new URL(str);
            conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String ans = "";
            String s = "";
            while((s = br.readLine()) != null){
                ans += s;
            }
            Matcher matcher = pattern.matcher(ans);
            int count = 0;
            while(matcher.find()){
                count++;
            }
            System.out.println(count);
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
