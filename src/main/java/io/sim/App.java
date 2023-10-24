package io.sim;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        EnvSimulator ev = new EnvSimulator();
        ev.start();
        Company companhia = new Company(ev);
        AlphaBank alpha = new AlphaBank();
        FuelSatation postoDeGasolina = new FuelSatation();

        // Iniciando threads
        alpha.run();
        companhia.run();
        postoDeGasolina.run();
        // B:\UFLA\Matérias\Matérias_2023_02_FINAL\Automação
        // Avançada\sim\src\main\java\io\sim\App.java
    }
}
