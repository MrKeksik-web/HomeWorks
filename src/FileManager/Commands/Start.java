package FifteenthHomeWorks.Commands;

import java.awt.*;
import java.awt.color.CMMException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start implements Command {
    public File start(String absPath, String relaltivePath) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File("C:\\");
        String path;

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9.:]+");
        Matcher matcher = pattern.matcher(relaltivePath.substring(6));

        Pattern patternToAbs = Pattern.compile("^[A-Z]+[:]{1}");
        Matcher matcherToAbs = patternToAbs.matcher(relaltivePath.substring(6));

        if(!matcherToAbs.find()) {
            while (matcher.find()) {
                path = matcher.group();
                if (path.equals("..")) {
                    file = (new Back()).run(absPath, "..");
                    absPath = file.getAbsolutePath();
                } else {
                    file = new File(absPath + "\\" + path);
                    absPath = file.getAbsolutePath();
                }
            }
        } else{
            file = new File(relaltivePath.substring(6));
        }

        if(file.exists()){
            desktop.open(file);
            return new File(absPath);
        }
        throw new FileNotFoundException();
    }

    @Override
    public File run(String absPath, String path) throws IOException {
        try {
            return this.start(absPath,path);
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath);
        }
    }
}
