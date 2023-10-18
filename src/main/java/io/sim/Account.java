package io.sim;

public class Account {
    private String idAccount = new String();
    private double saldo;

    public Account (String conta, double saldoInicial){
        this.idAccount = conta;
        this.saldo = saldoInicial;
    }

    public String getAccount() {
        return this.idAccount;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public void saque(double valor) {
        if (valor > saldo) {
            System.out.println("A conta " + idAccount + "não possui o valor desejado para sacar!\nSaldo disponível para retirada: " + getSaldo());
        }else{
            this.saldo-=valor;            
        } 
    }   
}
