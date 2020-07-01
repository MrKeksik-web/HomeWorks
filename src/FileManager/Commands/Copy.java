package FifteenthHomeWorks.Commands;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Copy implements Command{
    public File toFile(String absPath,String src) throws IOException {
        File file = new File("C:\\");
        String path;

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9.:]+");
        Matcher matcher = pattern.matcher(src);

        Pattern patternToAbs = Pattern.compile("^[A-Z]+[:]{1}");
        Matcher matcherToAbs = patternToAbs.matcher(src);

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
            file = new File(src);
        }

        return file;
    }

    public File copyFromTo(String absPath, String src,String out) throws IOException {
        File srcFile = toFile(absPath, src);
        File outFile = toFile(absPath, out);
        if (srcFile.isDirectory()) {
            Files.createDirectories(Paths.get(outFile.getAbsolutePath()));
            File[] list = srcFile.listFiles();
            for (int i = 0; i < list.length; i++) {
                copyFromTo(absPath, list[i].getAbsolutePath(), outFile.getAbsolutePath() + "\\" + list[i].getName());
            }
        } else{
            Files.copy(Paths.get(srcFile.getAbsolutePath()),new FileOutputStream(outFile));
        }

        return srcFile;
    }

    public File copy(String absPath, String relaltivePath) throws IOException{
        File file = new File(absPath);
        String path;

        int index = relaltivePath.substring(5).indexOf(" ");
        String src = relaltivePath.substring(5).substring(0,index);
        String out = relaltivePath.substring(5).substring(index + 1);

        copyFromTo(absPath, src,out);

        return file;
    }

    @Override
    public File run(String absPath, String path) throws IOException {
        try {
            return this.copy(absPath,path);
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath);
        }
    }
}
