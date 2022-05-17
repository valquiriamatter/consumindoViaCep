import com.google.gson.Gson;
import models.Temperatura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicoTemperatura {

    static int codigoSucesso = 200;

    static String webService = "https://api.openweathermap.org/data/2.5/weather?q=";
    static String apiKey = "b77e07f479efe92156376a8b07640ced";

    public static Temperatura buscarTemperaturaPorCidade(String nomeCidade)throws Exception{

        String urlChamada = webService + nomeCidade + "&appid=" + apiKey + "&units=metric";
        System.out.println(urlChamada);

        try{
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if(conexao.getResponseCode()!= codigoSucesso)
                throw new RuntimeException("Http error code:" + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Temperatura temperatura = gson.fromJson(jsonEmString, Temperatura.class);

            return temperatura;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}

