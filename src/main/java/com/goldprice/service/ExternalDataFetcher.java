package com.goldprice.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExternalDataFetcher {

    public double fetchUSDIndex() throws Exception {
        return fetchData("https://api.example.com/usd-index");
    }

    public double fetchSP500() throws Exception {
        return fetchData("https://api.example.com/sp500");
    }

    public double fetchOilPrices() throws Exception {
        return fetchData("https://api.example.com/oil-prices");
    }

    public double fetchVIXIndex() throws Exception {
        return fetchData("https://api.example.com/vix");
    }

    private double fetchData(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        // Assuming the response contains a JSON object with a "value" field
        return parseJsonValue(content.toString());
    }

    private double parseJsonValue(String jsonResponse) {
        // Dummy implementation, should parse the JSON response to extract the value
        return 0.0;
    }
}