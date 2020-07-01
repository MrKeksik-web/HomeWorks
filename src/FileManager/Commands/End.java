package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.IOException;

public class End implements Command{
    @Override
    public File run(String absPath,String path) throws IOException {
        System.exit(0);
        return null;
    }
}
