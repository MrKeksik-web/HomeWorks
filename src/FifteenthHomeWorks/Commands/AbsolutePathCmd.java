package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class AbsolutePathCmd implements Command{
    private File file;

    public AbsolutePathCmd(String path) {
        this.file = new File(path.substring(3));
    }

    public File cdByAbsolute() throws IOException {
        if(file.exists()){
            return file;
        }
        throw new FileNotFoundException();
    }

    @Override
    public File run(String absPath,String path) throws IOException {
        try {
            return this.cdByAbsolute();
        } catch (FileNotFoundException e){
            System.out.print("The system cannot find the specified file.." + "\n\n");
            return new File(absPath);
        }
    }
}
