package TwentiethHomeWorks.UserInterface;

import TwentiethHomeWorks.Loader.Loader;

import java.io.File;
import java.io.IOException;

public class Start{
    Thread loaderThread;

    public Thread getLoaderThread() {
        return loaderThread;
    }

    public void setLoaderThread(Thread loaderThread) {
        this.loaderThread = loaderThread;
    }

    public Thread run() throws IOException {
        Thread loader = new Thread(new Loader());
        setLoaderThread(loader);
        loaderThread.start();
        return loaderThread;
    }
}
