package TwentiethHomeWorks.UserInterface;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface implements Runnable {
    private final Scanner IN = new Scanner(System.in);
    private final Pattern PATTERN_TO_START = Pattern.compile("^start");
    private final Pattern PATTERN_TO_LEFT = Pattern.compile("^howleft");
    private final Pattern PATTERN_TO_END = Pattern.compile("^end");
    private final Pattern PATTERN_TO_EXIT = Pattern.compile("^exit");
    private File file;
    private Thread startThread;

    @Override
    public void run() {
        System.out.print("Введите команду: ");
        String line = IN.nextLine();
        Matcher matcher = PATTERN_TO_END.matcher(line);
        while(true){
            try {
                String cmd = cmdFinding(line);
                if(cmd == "end"){
                    System.out.println("Скачивание досрочно завершено");
                    System.out.print("Введите команду: ");
                } else {
                    System.out.print("Введите команду: ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            line = IN.nextLine();
            matcher = PATTERN_TO_END.matcher(line);
        }
    }

    private String cmdFinding(String cmd) throws IOException {
        if(PATTERN_TO_END.matcher(cmd).find()){
            (new End()).run(startThread);
            return "end";
        }
        if(PATTERN_TO_LEFT.matcher(cmd).find()){
            (new HowLeft()).run();
            return "left";
        }
        if(PATTERN_TO_START.matcher(cmd).find()){
            startThread = (new Start()).run();
            return "start";
        }
        if(PATTERN_TO_EXIT.matcher(cmd).find()){
            System.exit(0);
        }

        System.out.println("\'" + cmd +  "\'" + " not a command, executable program, or batch file");
        return null;
    }
}
