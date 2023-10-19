package io.sim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

public class JsonManager {

    private JSONObject obj = new JSONObject();

    public JsonManager (){} // Construtor padrão

    public JSONObject JsonTransferencia (String idPagador, String idRecebedor, String quantia) {
        obj.put("idPagador", idPagador);
        obj.put("idRecebedor", idRecebedor);
        obj.put("quantia", quantia);
        // adcionar timestamp
        return obj;
    }

    public JSONObject JsonCriarConta (String idConta, String quantia, String timestamp) {
        obj.put("tipo_de_requisicao", "CriarConta");
        obj.put("idConta", idConta);
        obj.put("quantia", quantia);
        obj.put("timestamp", timestamp);
        return obj;
    }

}
