package EleventhHomeWorks;

import SixthHomeWorks.MapSecondVersion;

import java.io.*;

public class BufferedReaderInputStramDecoratorIniFiles extends InputStream {
    private BufferedReader bufferedReader;
    protected String sectionName;
    protected String sectionNameNext;

    public BufferedReaderInputStramDecoratorIniFiles(InputStream inputStream) throws IOException {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        sectionName = bufferedReader.readLine();
        sectionNameNext = sectionName;
    }

    public MapSecondVersion<String,MapSecondVersion<String,String>> readIniFile() throws IOException {
        MapSecondVersion<String,MapSecondVersion<String,String>> map = new MapSecondVersion<>();

        MapSecondVersion<String,String> section = readIniSection();
        while(section != null) {
            map.put(sectionName,section);
            section = readIniSection();
        }
        return map;
    }

    public MapSecondVersion<String,String> readIniSection() throws IOException {
        MapSecondVersion<String,String> map = new MapSecondVersion<>();

        String str = bufferedReader.readLine();

        sectionName = sectionNameNext;

        if(str == null) {
            return null;
        }

        while(str.charAt(0) != '['){
            String key = "";
            String val = "";
            for(int i = 0;i < str.length();i++) {
                if(str.charAt(i) == '='){
                    val = str.substring(i + 1);
                    break;
                }
                key += str.charAt(i);
            }
            map.put(key,val);
            str= bufferedReader.readLine();
            if(str == null) {
                return map;
            }
        }

        sectionNameNext = str;
        return map;
    }

    @Override
    public int read() throws IOException {
        return bufferedReader.read();
    }

    public static void main(String[] args) throws IOException {
        BufferedReaderInputStramDecoratorIniFiles in = new BufferedReaderInputStramDecoratorIniFiles(new FileInputStream("input.ini"));

        MapSecondVersion<String,MapSecondVersion<String,String>> map = in.readIniFile();
        System.out.println(map);
    }
}
