import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {
    private String apiKey = "302ebc743d22a50aaf348f23";
    private String currencyToBeExchanged;
    private String finalCurrency;
    private double amount;
    private double conversionResult;

    public Currency currencyExchange(String currencyToBeExchanged, String finalCurrency, double amount) {
        this.currencyToBeExchanged = currencyToBeExchanged;
        this.finalCurrency = finalCurrency;
        this.amount = amount;
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + currencyToBeExchanged + "/" + finalCurrency + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Currency currency = new Gson().fromJson(response.body(), Currency.class);
            this.conversionResult = currency.conversion_result();
            return currency;
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la divisa ingresada");
        }
    }

    @Override
    public String toString() {
        return "La conversión de " + amount
                + " [" + currencyToBeExchanged
                + "] a [" + finalCurrency
                + "] es igual a: "+conversionResult+" ["+finalCurrency+"]\n";
    }
}
