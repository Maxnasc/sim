package io.sim;

import java.time.Instant;

import org.json.JSONObject;

public class FuelSatation {

    private boolean isAlive = false;
    private JsonManager jsonMaker = new JsonManager();
    private Cryptographer encriptador = new Cryptographer();
    private SharedMemory memoriaCompartilhada = new SharedMemory();
    private JSONObject json = new JSONObject();
    private Instant timestamp;
    private Long timestampDriver;

    private Car carro = new Car();

    //Dados da conta alphabank
    private String idConta;
    private double valorInicialDaConta; 

    public FuelSatation() {
        this.isAlive = true;
        this.idConta = ("Fuel_Station");
        this.valorInicialDaConta = 0;
        criarConta();

        run();
    }

    public void run() {
        while (isAlive){
            try {
                System.out.println("Fuel Station");
                // funções a serem processadas
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            // throw new UnsupportedOperationException("Unimplemented method 'run'"); -> diz q o run n foi implementado
    }}

    private void criarConta() {
        timestamp = Instant.now();
        long timestampNanos = timestamp.getNano() + timestamp.getEpochSecond() * 1_000_000_000L;
        json = jsonMaker.JsonCriarConta(encriptador.criptografarString(idConta), encriptador.criptografarDouble(valorInicialDaConta), encriptador.criptografarTimestamp(timestampNanos));
        memoriaCompartilhada.write(json, "CriarConta");
    }

    public void abastecer() {
    }

}
