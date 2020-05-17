package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Back implements Command{
    public File back(String absPath) throws IOException {
        File file = new File(absPath);
        if(file.getParentFile() == null){
            return file;
        }
        return file.getParentFile();
    }

    @Override
    public File run(String absPath,String path) throws IOException {
        return this.back(absPath);
    }
}
