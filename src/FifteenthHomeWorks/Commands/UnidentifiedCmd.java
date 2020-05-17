package FifteenthHomeWorks.Commands;

import java.io.File;
import java.io.IOException;

public class UnidentifiedCmd implements Command{
    @Override
    public File run(String absPath, String path) throws IOException {
        return new File(absPath);
    }
}
