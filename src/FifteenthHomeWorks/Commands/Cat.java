package FifteenthHomeWorks.Commands;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat implements Command {
    private File cat(String absPath, String relaltivePath) throws IOException {
        File file = new File("C:\\");
        String path;
        String code = relaltivePath.substring(relaltivePath.lastIndexOf(' ') + 1);
        File start = new File(absPath);

        Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9.]+");
        Matcher matcher;
        if(relaltivePath.substring(4).lastIndexOf(' ') == -1){
            matcher = pattern.matcher(relaltivePath.substring(4));
        } else {
            matcher = pattern.matcher(relaltivePath.substring(4, relaltivePath.lastIndexOf(' ')));
        }

        Pattern patternToAbs = Pattern.compile("^[A-Z]+[:]{1}");
        Matcher matcherToAbs;
        if(relaltivePath.substring(4).lastIndexOf(' ') == -1){
            matcherToAbs = patternToAbs.matcher(relaltivePath.substring(4));
        } else{
            matcherToAbs = patternToAbs.matcher(relaltivePath.substring(4, relaltivePath.lastIndexOf(' ')));
        }

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

        if(file.exists()){
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), code));
            }
            catch (UnsupportedEncodingException e){
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "UTF-8"));
            }
            String c;
            while((c = br.readLine()) != null){
//              Для вывода в командной строке
//              String utf8String = new String(c.getBytes("UTF-8"), "windows-1251");
//              System.out.println(utf8String);
                System.out.println(c);
            }
        }

        return start;
    }

    @Override
    public File run(String absPath, String path) throws IOException {
        try {
            return this.cat(absPath,path);
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath + "\\qwerty");
        }
    }
}
