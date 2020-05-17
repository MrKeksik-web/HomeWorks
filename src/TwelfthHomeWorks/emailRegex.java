package TwelfthHomeWorks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailRegex {
    public static void main(String[] args) {
        String text = "examples@maps.yandex.google.ru";
        Pattern pattern = Pattern.compile("[@][A-z0-9.]+");
        Matcher matcher = pattern.matcher(text);
        String str = "";
        while(matcher.find()) {
            str = matcher.group();
        }
        String first = "";
        str = str.substring(1);
        pattern = Pattern.compile("^[A-z0-9]+");
        matcher = pattern.matcher(str);
        while(matcher.find()) {
            first = matcher.group();
        }
        System.out.println(first);
        String second = "";
        pattern = Pattern.compile("[A-z0-9]+$");
        matcher = pattern.matcher(str);
        while(matcher.find()) {
            second = matcher.group();
        }
        System.out.println(second);
    }
}
