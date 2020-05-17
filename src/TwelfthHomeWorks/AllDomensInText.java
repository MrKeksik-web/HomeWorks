package TwelfthHomeWorks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllDomensInText {
    public static void main(String[] args) {
        String text = "asdsadasd#dsaDasdasd$adsdasdas.asdasdasdASD8a8sdas&sada.asdasd.asdasd";
        Pattern pattern = Pattern.compile("([A-z0-9-]+[\\\\.])+?[A-z0-9-]+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
