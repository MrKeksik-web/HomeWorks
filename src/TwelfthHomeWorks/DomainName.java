package TwelfthHomeWorks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainName {
    public static void main(String[] args) {
        String text = "aaaaa.asdsad#";
        Pattern pattern = Pattern.compile("^([A-z0-9-]+[\\\\.])+[A-z0-9-]+$");
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.find());
    }
}
