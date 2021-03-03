package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RequestToBank {

    private final String RATES_URL = "?periodicity=0&ondate=";
    private final String USDTest_URL = "/840?parammode=1&ondate=2020-7-6&periodicity=0";
    private final String USD_URL = "/840?parammode=1";
    private final String BASE_URL = "https://www.nbrb.by/api/exrates/rates";


    private final JsonParser jsonParser;

    public RequestToBank(){
        jsonParser = new JsonParser();
    }

    public List<Rate> connection(String currencyRate) throws IOException {

        URL url = new URL(makeUrlForRateRequest(currencyRate));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        InputStream in;
        int status = connection.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) in = connection.getInputStream();
        else in = connection.getErrorStream();

        String response = convertStreamToString(in);

        return jsonParser.getRates(response);
    }

    private String makeUrlForRateRequest(String currencyRate) {
        StringBuilder ratesUrl = new StringBuilder(BASE_URL);
        switch (currencyRate) {
            default:
            case "/rates":
                ratesUrl.append(RATES_URL);
                break;
            case "/USDTest":
                ratesUrl.append(USDTest_URL);
                break;
            case "/USD":
                ratesUrl.append(USD_URL);
                break;
        }
        return ratesUrl.toString();
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
