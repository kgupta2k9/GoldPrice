package com.goldprice.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataFetcher {

    private static final String API_URL = "https://api.goldapi.io/v1/latest/price";
    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your actual API key

    public List<Double> fetchGoldPrices() throws IOException {
        List<Double> goldPrices = new ArrayList<>();
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("x-access-token", API_KEY);
            
            if (conn.getResponseCode() == 200) {
                // Process the response (Assuming JSON response parsing here)
                // ...
            } else {
                throw new IOException("Failed to fetch data from GoldAPI");
            }
        } finally {
            // Cleanup resources if needed
        }
        return goldPrices;
    }

    public List<String[]> loadPricesFromCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming CSV values are comma separated
                data.add(values);
            }
        }
        return data;
    }
}