package io.sim;

import org.jasypt.util.text.BasicTextEncryptor;

public class Cryptographer {
    // Classe para criptografar e desencriptografar dados de mensagens trocadas entre as classes
    
    private BasicTextEncryptor texto = new BasicTextEncryptor();
    
    public String cripyografar(String dados){
        texto.setPasswordCharArray("tradutor".toCharArray());
        String dadoCriptografado = texto.encrypt(dados);
        return dadoCriptografado;
    }
    
    public String descripyografar(String dados){
        texto.setPasswordCharArray("tradutor".toCharArray());
        String dadoDescriptografado = texto.decrypt(dados);
        return dadoDescriptografado;
    }
    
}
