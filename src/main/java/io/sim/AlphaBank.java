package io.sim;

import java.util.ArrayList;

public class AlphaBank extends Thread {
    
    private ArrayList <Account> contas;

    public AlphaBank (){
        this.contas =  new ArrayList<Account>();
    }

    public void criarConta(String id, double saldoInicial) { // adicionar prefixo identificando qual tipo de conta, driver, company ou fuel station
        Account conta = new Account(id, saldoInicial);
        contas.add(conta);
    }

    public void transferencia(String idPagador, String idRecebedor, double quantia) {
        saque(idPagador, quantia);
        deposito(idRecebedor, quantia);
    }

    private void deposito(String id, double valor) {
       int index = findAccountById(id);
       contas.get(index).deposito(valor);
    }

    private void saque(String id, double valor) {
        int index = findAccountById(id);
        contas.get(index).saque(valor);
    }

    public double getSaldo(String id, double valor) { 
        int index = findAccountById(id);
        return contas.get(index).getSaldo();
    }

    private int findAccountById(String id) { //ADICIONAR EXCEPTION
        boolean existe = false;
        int i;
        for (i=0; i<contas.size(); i++){
            if (contas.get(i).getAccount() == id){
                existe = true;
            }
        }
        if (existe == false) {
            System.out.println("Conta não encontrada");
        }
        return i;
    }

    public void run() {
        // TODO Auto-generated method stub
        while (isAlive()){
            try {
                System.out.println("Thread Alphabank");
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
            // throw new UnsupportedOperationException("Unimplemented method 'run'"); -> diz q o run n foi implementado
    }}
}
