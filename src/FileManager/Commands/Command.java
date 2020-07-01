package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.IOException;

public interface Command {
    public File run(String absPath,String path) throws IOException;
}
