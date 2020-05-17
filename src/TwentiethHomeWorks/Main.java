package TwentiethHomeWorks;

import TwentiethHomeWorks.Loader.Loader;
import TwentiethHomeWorks.UserInterface.UserInterface;

public class Main {
    public static void main(String[] args) {
        Thread ui = new Thread(new UserInterface());
        ui.start();
    }
}
