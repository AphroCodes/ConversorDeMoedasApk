package br.com.conversor.models;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    Gson gson = new GsonBuilder().create();



    public String convert(double valor, String inputCurrency, String outputCurrency) throws IOException, InterruptedException {

        String convertedValue = String.valueOf(valor);
        String key = "7b3a7a81f5d8548d4c8e16d7";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + inputCurrency +"/" + outputCurrency +"/" + convertedValue;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        ExchangeRate convert = gson.fromJson(json, ExchangeRate.class);
        String result = convert.conversion_result();


    return result;
    }
}
