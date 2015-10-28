package splashscreamtipoadobe;

import Ventanas.SplashScream;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(new SplashScream()).start();

    }
}
