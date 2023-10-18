package io.sim;

import java.util.ArrayList;

public class Company extends Thread{
    // Deve ser uma thread
    // deve conter um conjunto de rotas -> FEITO
    // Deve ser um servidor para carros
    // Deve ser um cliente de alphaBank -> deve ter uma conta no alphaBank
    // Criar uma Classe BotPayment (Thread)
    // gerar xlsl de relatório (xlsl é sugestão minha)

    private double precoPkm;
    private ArrayList <Route> rotasAseremExecutadas;
    private ArrayList <Route> rotasEmExecucao;
    private ArrayList <Route> rotasExecutadas;

    //objeto de comunicação alphabank
    private AlphaBank conta; 

    public Company() {
        this.precoPkm = 3.25;
        conta = new AlphaBank();
        conta.criarConta("Company", 100); // conta da empresa
    }

    public void run() {
        while (isAlive()){
            try {
                System.out.println("Thread Company");
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }}

    public void addRoute (Route route){
        this.rotasAseremExecutadas.add(route);
    }

    public ArrayList<Route> getCurrentRoute () {
        return rotasEmExecucao;
    }

    public ArrayList<Route> getExecutedRoutes () {
        return rotasExecutadas;
    }

    public class BotPayment {

        public BotPayment() {}

        public void pay() {}
    }


}
