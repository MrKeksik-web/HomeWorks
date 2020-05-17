package TwentiethHomeWorks.UserInterface;

import TwentiethHomeWorks.Loader.Loader;

import java.io.IOException;

public class End {
    public void run(Thread thread) throws IOException {
        thread.interrupt();
    }
}
