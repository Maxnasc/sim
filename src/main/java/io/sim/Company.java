package io.sim;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private BotPayment botDePagamentos;

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

        botDePagamentos = new BotPayment();
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
        private float kmPago;
        private float kmRodado;
        private boolean pagarPosto;
        private Map<String, Double> pagamentosPendentes = new HashMap<String, Double>();
        //public static float kmAtual = 0;;

        private String idConta;
        private double valorAPagar;

        public BotPayment() {
            this.isAlive = true;
            this.idConta = "Company";
            this.pagarPosto = false;
            run();
        }

        // Fazer fila de pagamentos para os drivers
        
        public void run() {
            // Processos iniciais...
            while (isAlive){
                try {
                    //System.out.println("Thread botpayment");
                    // adicionar verificação de km percorrido 
                    if (pagamentosPendentes.size() > 0){
                        pay();
                        kmPago = kmRodado;
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
        }}

        public void setPagarPosto(boolean pagarPosto, double quantia) {
            this.pagarPosto = pagarPosto;
            this.valorAPagar = quantia;
        }

        public void pay() {
            timestamp = Instant.now();
            long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
            json = jsonMaker.JsonTransferencia(encriptador.criptografarString(idConta), encriptador.criptografarString("idCarro"), encriptador.criptografarDouble(valorAPagar), encriptador.criptografarTimestamp(timestampNanos));
            memoriaCompartilhada.write(json, "6");
            pagarPosto = false;
            valorAPagar = 0;
        }
        }

        
}
