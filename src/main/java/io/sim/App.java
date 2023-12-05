package io.sim;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Fuel Station");
        EnvSimulator ev = new EnvSimulator();
        ev.start();
        try {
            ev.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
