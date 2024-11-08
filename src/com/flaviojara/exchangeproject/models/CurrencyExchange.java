package com.flaviojara.exchangeproject.models;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CurrencyExchange {
    private final String apiKey;
    private String currencyToBeExchanged;
    private String finalCurrency;
    private double amount;
    private double conversionResult;

    private final List<String> exchangeHistory = new ArrayList<>();

    public CurrencyExchange() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            apiKey = properties.getProperty("api_key");
        } catch (IOException e) {
            throw new RuntimeException("Could not load API key", e);
        }
    }

    public Currency currencyExchange(String currencyToBeExchanged, String finalCurrency, double amount) {
        this.currencyToBeExchanged = currencyToBeExchanged;
        this.finalCurrency = finalCurrency;
        this.amount = amount;

        // Create a timestamp string with the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + currencyToBeExchanged + "/" + finalCurrency + "/" + amount);

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Currency currency = new Gson().fromJson(response.body(), Currency.class);
            this.conversionResult = currency.conversion_result();

            exchangeHistory.add(this.toString()+" realizada con fecha: "+timestamp);
            return currency;
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la divisa ingresada");
        }
    }

    public List<String> getExchangeHistory() {
        return exchangeHistory;
    }

    @Override
    public String toString() {
        return "La conversión de " + amount
                + " [" + currencyToBeExchanged
                + "] a [" + finalCurrency
                + "] es igual a: "+conversionResult+" ["+finalCurrency+"]\n";
    }
}
