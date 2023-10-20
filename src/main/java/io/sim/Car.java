package io.sim;

import de.tudresden.sumo.cmd.Vehicle;

public class Car extends Vehicle{
    // Deve ser cliente de Company
    // Sumo deve retornar a quantidade de litros gastos e o valor de Fuel Tank deve ser alterado
    private double FuelTank;
    private boolean isAlive = false;
    private FuelSatation posto = new FuelSatation();

    public Car (){
        this.isAlive = true;
        this.FuelTank = 10;
        run();
    }
    
    public void run() {
        // Processos iniciais...
        while (isAlive){
            try {
                if (FuelTank <= 3) { // Verificando a quantidade de combustível
                    abastecer();
                }
                //System.out.println("Thread botpayment");
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }}

    public void abastecer() {
        // Parar o carro
        
        posto.abastecer();

        // Liberar o carro
    }

    public void adicinaGasolina(double gasolina) {
        this.FuelTank += gasolina;
    }
}
