package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Remove implements Command{
    public File end(String absPath, String relaltivePath) throws IOException {
        File file = new File("C:\\");
        String path;

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9.]+");
        Matcher matcher = pattern.matcher(relaltivePath.substring(3));

        Pattern patternToAbs = Pattern.compile("^[A-Z]+[:]{1}");
        Matcher matcherToAbs = patternToAbs.matcher(relaltivePath.substring(3));

        if(!matcherToAbs.find()){
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
        } else {
            file = new File(relaltivePath.substring(3));
        }

        if(file.exists()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (int i = 0; i < list.length; i++) {
                    run(list[i].getAbsolutePath(), "rm " + list[i].getAbsolutePath());
                }
            } else {
                try {
                    file.delete();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
            try {
                file.delete();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            return file;
        } else {
            throw new FileNotFoundException();
        }
    }

    private boolean delete(File file){
        return file.delete();
    }

    @Override
    public File run(String absPath, String path) throws IOException {
        try {
            return this.end(absPath,path);
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath + "\\qwerty");
        }
    }
}
