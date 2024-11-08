package com.flaviojara.exchangeproject.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExchangeLog {
    public void exchangeCurrencyLog(CurrencyExchange currencyExchange) throws IOException {

        String folderPath = "src/com/flaviojara/exchangeproject/logs";
        File folder = new File(folderPath);

        if(!folder.exists()){
            folder.mkdirs();
        }

        // Create a timestamp string with the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        // Append the timestamp to the filename
        String filename = folderPath + "/exchangeLog_"+timestamp+".txt";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter exchangeLogFile = new FileWriter(filename)) {
            exchangeLogFile.write(gson.toJson(currencyExchange.getExchangeHistory()));
            System.out.println("Historial de cambios guardado!");
        } catch (Exception e) {
            System.out.println("Ocurrio un problema al almacenar el archivo: "+e);;
        }
    }
}
