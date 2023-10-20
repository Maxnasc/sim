package io.sim;

import java.time.Instant;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Driver implements Runnable {
    
    private boolean isAlive = false;

    private ArrayList <Route> rotasAseremExecutadas;
    private ArrayList <Route> rotasEmExecucao;
    private ArrayList <Route> rotasExecutadas;

    private JsonManager jsonMaker = new JsonManager();
    private Cryptographer encriptador = new Cryptographer();
    private SharedMemory memoriaCompartilhada = new SharedMemory();
    private JSONObject json = new JSONObject();
    private Instant timestamp;
    private Long timestampDriver;
    private AlphaBank banco = new AlphaBank();

    private Car carro = new Car();
    private final int cadastroDriver; 

    //Dados da conta alphabank
    private String idConta;
    private double valorInicialDaConta;
    private double saldo; 

    public Driver(int cadastroDriver) {
        this.isAlive = true;
        this.idConta = ("Driver_" + cadastroDriver);
        this.valorInicialDaConta = 0;
        this.saldo = 0;
        this.cadastroDriver = cadastroDriver;
        criarConta();

        run();
    }

    public void run() {
        rotasAseremExecutadas = getRoutes();
        while (isAlive){
            try {
                System.out.println("Driver");
                // funções a serem processadas
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            // throw new UnsupportedOperationException("Unimplemented method 'run'"); -> diz q o run n foi implementado
    }}

    

    private void abastecer() {
        // Parar o carro
        this.saldo = getSaldo();
        if (saldo > 5.87){
            carro.abastecer();
        }else{
            System.out.println("Carro_" + cadastroDriver + ": Sem saldo suficiente");
        }
        // Liberar o carro
    }

    private ArrayList<Route> getRoutes() {
        // Faz um json solicitando as rotas, espera elas chegarem e dps retorna
        return null;
    }

    private void criarConta() {
        timestamp = Instant.now();
        long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
        json = jsonMaker.JsonCriarConta(encriptador.criptografarString(idConta), encriptador.criptografarDouble(valorInicialDaConta), encriptador.criptografarTimestamp(timestampNanos));
        memoriaCompartilhada.write(json, "CriarConta");
    }

    private double getSaldo(){
        double saldoNovo = banco.getSaldo(idConta);
        return saldoNovo;
    }

    class BotPayment {

        private boolean isAlive = false;
        private Instant timestamp;
        private JsonManager jsonMaker = new JsonManager();
        private Cryptographer encriptador = new Cryptographer();
        private JSONObject json = new JSONObject();
        private SharedMemory memoriaCompartilhada = new SharedMemory();
        private float kmEmMemoria;
        //public static float kmAtual = 0;;

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
                    pay();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
        }}

        public void pay() {
            timestamp = Instant.now();
            long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
            json = jsonMaker.JsonTransferencia(encriptador.criptografarString(idConta), encriptador.criptografarString("Fuel Station"), encriptador.criptografarDouble(5.87), encriptador.criptografarTimestamp(timestampNanos));
            memoriaCompartilhada.write(json, "6");
        }
}}
