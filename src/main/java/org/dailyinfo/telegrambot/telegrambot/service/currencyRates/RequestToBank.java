package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RequestToBank {

    private final StringBuilder requestUrl = new StringBuilder("https://www.nbrb.by/api/exrates/rates?periodicity=0&ondate=");

    private final JsonParser jsonParser;

    public RequestToBank(){
        jsonParser = new JsonParser();
    }

    public List<Rate> connection() throws IOException {

        URL url = new URL(requestUrl.toString());

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        InputStream in;
        int status = connection.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) in = connection.getInputStream();
        else in = connection.getErrorStream();

        String response = convertStreamToString(in);

        return jsonParser.getRates(response);
    }

    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();

        return sb.toString();
    }

}
