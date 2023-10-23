package io.sim;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        EnvSimulator ev = new EnvSimulator();
        AlphaBank alpha = new AlphaBank();
        Company companhia = new Company(ev);
        FuelSatation postoDeGasolina = new FuelSatation();

        // Iniciando threads
        alpha.run();
        companhia.run();
        postoDeGasolina.run();
        // B:\UFLA\Matérias\Matérias_2023_02_FINAL\Automação
        // Avançada\sim\src\main\java\io\sim\App.java
    }
}
