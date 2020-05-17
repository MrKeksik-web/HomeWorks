package FifteenthHomeWorks;

import FifteenthHomeWorks.Commands.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    private final Scanner IN = new Scanner(System.in);
    private final Pattern PATTERN_TO_END = Pattern.compile("^end");
    private final Pattern PATTERN_TO_CDABS = Pattern.compile("^cd\\s[A-Z]+[:]{1}");
    private final Pattern PATTERN_TO_CD = Pattern.compile("^cd");
    private final Pattern PATTERN_TO_DIR = Pattern.compile("^dir");
    private final Pattern PATTERN_TO_HELP = Pattern.compile("^help");
    private final Pattern PATTERN_TO_START = Pattern.compile("^start");
    private final Pattern PATTERN_TO_RM = Pattern.compile("^rm");
    private final Pattern PATTERN_TO_COPY = Pattern.compile("^copy");
    private final Pattern PATTERN_TO_CAT = Pattern.compile("^cat");
    private File file;

    public FileManager() {
        this.file = new File("src");
    }

    public void start() throws IOException {
        file = (new Help()).run(file.getAbsolutePath(),"");
        System.out.print(file + ">");
        reading();
    }

    private void reading() throws IOException {
        String line = IN.nextLine();
        Matcher matcher = PATTERN_TO_END.matcher(line);
        while(!matcher.find()){
            Command cmd = cmdFinding(line);
            file = cmd.run(file.getAbsolutePath(),line);
            if(cmd.getClass().equals(Remove.class)){
                file = (new Back()).run(file.getAbsolutePath(),"");
            }
            System.out.print(file + ">");
            line = IN.nextLine();
            matcher = PATTERN_TO_END.matcher(line);
        }
    }

    private Command cmdFinding(String cmd){
        if(PATTERN_TO_END.matcher(cmd).find()){
            return new End();
        }
        if(PATTERN_TO_CDABS.matcher(cmd).find()){
            return new AbsolutePathCmd(cmd);
        }
        if(PATTERN_TO_DIR.matcher(cmd).find()){
            return new Dir();
        }
        if(PATTERN_TO_CD.matcher(cmd).find()){
            return new Cd();
        }
        if(PATTERN_TO_HELP.matcher(cmd).find()){
            return new Help();
        }
        if(PATTERN_TO_START.matcher(cmd).find()){
            return new Start();
        }
        if(PATTERN_TO_RM.matcher(cmd).find()){
            return new Remove();
        }
        if(PATTERN_TO_COPY.matcher(cmd).find()){
            return new Copy();
        }
        if(PATTERN_TO_CAT.matcher(cmd).find()){
            return new Cat();
        }
        System.out.println("\'" + cmd +  "\'" + " not a command, executable program, or batch file");
        return new UnidentifiedCmd();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileManager fm = new FileManager();
        fm.start();
    }
}
