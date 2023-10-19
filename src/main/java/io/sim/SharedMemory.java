package io.sim;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Semaphore;

import org.json.JSONObject;

public class SharedMemory {
    private JSONObject data;
    private Semaphore semaphore;

    public SharedMemory() {
        this.data = null;
        this.semaphore = new Semaphore(1);
    }

    public void write(JSONObject value, String nomeArquivo) {
        try {
            semaphore.acquire();
            // this.data = value;
            saveFile(value, nomeArquivo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public JSONObject read(String requisicao) {
        JSONObject value = null;
        try {
            semaphore.acquire();
            // value = this.data;
            value = getFile(requisicao);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
        return value;
    }

    private void saveFile(JSONObject value, String nomeArquivo) {
        try (FileWriter file = new FileWriter("/jsons/" + nomeArquivo + ".json")) {
            file.write(value.toString());
            // System.out.println("Successfully Copied JSON Object to File...");
            // System.out.println("\nJSON Object: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getFile(String requisicao) {
        JSONObject json = new JSONObject("chave", "Erro ao gerar json");
        try {
            String path = "/jsons/" + requisicao + ".json"; // Substitua pelo caminho do seu arquivo
            String content = new String(Files.readAllBytes(Paths.get(path)));
            json = new JSONObject(content);
            return json;
            //System.out.println(json.toString(4)); // Imprime o JSON formatado com 4 espaços de indentação
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
