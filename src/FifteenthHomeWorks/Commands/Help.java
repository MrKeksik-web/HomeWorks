package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.IOException;

public class Help implements Command{
    @Override
    public File run(String absPath, String path) throws IOException {
        System.out.println("\'help\' - reference");
        System.out.println("\'end\' - completion of work'");
        System.out.println("\'cd relative_or_absolute_path\' - change directory");
        System.out.println("\'dir\' - view catalog files");
        System.out.println("\'start\' - run executable file");
        System.out.println("\'rm\' - delete files or directory");
        System.out.println("\'copy\' - copies the directory to the specified path(copy source out)");
        System.out.println("\'cat relative_or_absolute_path encoding\' - \n" +
                "displays the contents of the text file in the specified encoding; if no encoding is specified, UTF-8 is used)");
        return new File(absPath);
    }
}
