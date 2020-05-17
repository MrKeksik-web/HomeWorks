package TwentiethHomeWorks.UserInterface;

import java.io.File;
import java.io.IOException;

public class HowLeft {
    public void run() throws IOException {
        File file = new File("output20.txt");
        System.out.println((file.length()/(float)(16988 * 1024)) * 100 + "%");
    }
}
