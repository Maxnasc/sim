package io.sim;

import java.time.Instant;
import java.util.ArrayList;

import org.json.JSONObject;

public class Company implements Runnable {
    // Deve ser uma thread
    // deve conter um conjunto de rotas -> FEITO
    // Deve ser um servidor para carros
    // Deve ser um cliente de alphaBank -> deve ter uma conta no alphaBank
    // Criar uma Classe BotPayment (Thread)
    // gerar xlsl de relatório (xlsl é sugestão minha)

    private boolean isAlive = false;

    private double precoPkm;
    private ArrayList <Route> rotasAseremExecutadas;
    private ArrayList <Route> rotasEmExecucao;
    private ArrayList <Route> rotasExecutadas;
    
    private Instant timestamp;
    private JsonManager jsonMaker = new JsonManager();
    private Cryptographer encriptador = new Cryptographer();
    private JSONObject json = new JSONObject();
    private SharedMemory memoriaCompartilhada = new SharedMemory();

    //Dados da conta alphabank
    private String idConta;
    private double valorInicialDaConta; 

    public Company() {
        this.isAlive = true;
        this.precoPkm = 3.25;
        this.idConta = "Company";
        this.valorInicialDaConta = 100.0;
        // criar conta no banco
        criarConta();

        BotPayment botDePagamentos = new BotPayment(idConta);
        run();
    }

    public void run() {
        // Processos iniciais...
        while (isAlive){
            try {
                //System.out.println("Thread Company");
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }}

    private void criarConta() {
        timestamp = Instant.now();
        long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
        json = jsonMaker.JsonCriarConta(encriptador.criptografarString(idConta), encriptador.criptografarDouble(valorInicialDaConta), encriptador.criptografarTimestamp(timestampNanos));
        memoriaCompartilhada.write(json, "CriarConta");
    }

    public void addRoute (Route route){
        this.rotasAseremExecutadas.add(route);
    }

    public ArrayList<Route> getCurrentRoute () {
        return rotasEmExecucao;
    }

    public ArrayList<Route> getExecutedRoutes () {
        return rotasExecutadas;
    }

    class BotPayment {

        private boolean isAlive = false;
        private Instant timestamp;
        private JsonManager jsonMaker = new JsonManager();
        private Cryptographer encriptador = new Cryptographer();
        private JSONObject json = new JSONObject();
        private SharedMemory memoriaCompartilhada = new SharedMemory();

        private String idConta;

        public BotPayment(String idConta) {
            this.isAlive = true;
            this.idConta = idConta;
            run();
        }
        
        public void run() {
            // Processos iniciais...
            while (isAlive){
                try {
                    //System.out.println("Thread botpayment");
                    // adicionar verificação de km percorrido 
                    //pay(idDriver);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
        }}

        public void pay(String idDriver) {
            timestamp = Instant.now();
            long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
            json = jsonMaker.JsonTransferencia(encriptador.criptografarString(idConta), encriptador.criptografarString("Fuel Station"), encriptador.criptografarDouble(5.87), encriptador.criptografarTimestamp(timestampNanos));
            memoriaCompartilhada.write(json, "6");
        }
    }

        
}
