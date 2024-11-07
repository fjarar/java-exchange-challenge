import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {
    private String apiKey = "302ebc743d22a50aaf348f23";
    public Currency currencyExchange(String currencyToBeExchanged, String finalCurrency, double amount){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+currencyToBeExchanged+"/"+finalCurrency+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la divisa ingresada");
        }
    }
}
