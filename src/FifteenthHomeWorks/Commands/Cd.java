package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cd implements Command{
    public File cd(String absPath,String relativvePath) throws IOException {
        String path = "";
        File file = new File("C:\\");

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9.]+");
        Matcher matcher = pattern.matcher(relativvePath.substring(3));
        while(matcher.find()){
            path = matcher.group();
            if(path.equals("..")){
                file = (new Back()).run(absPath,"..");
                absPath = file.getAbsolutePath();
            } else {
                file = new File(absPath + "\\" + path);
                absPath = file.getAbsolutePath();
            }
        }
        if(file.exists() && file.isDirectory()){
            return file;
        }
        throw new FileNotFoundException();
    }

    @Override
    public File run(String absPath,String path) throws IOException {
        try {
            return this.cd(absPath,path);
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath);
        }
    }
}
