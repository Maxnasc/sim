package io.sim;

import org.json.JSONObject;

public class JsonManager {

    private JSONObject obj = new JSONObject();

    public JsonManager (){} // Construtor padrão

    public JSONObject JsonTransferencia (String idPagador, String idRecebedor, double quantia) {
        obj.put("idPagador", idPagador);
        obj.put("idRecebedor", idRecebedor);
        obj.put("quantia", quantia);
        // adcionar timestamp
        return obj;
    }

    public JSONObject JsonCriarConta (String idConta, double quantia) {
        obj.put("idConta", idConta);
        obj.put("quantia", quantia);
        return obj;
    }

}
