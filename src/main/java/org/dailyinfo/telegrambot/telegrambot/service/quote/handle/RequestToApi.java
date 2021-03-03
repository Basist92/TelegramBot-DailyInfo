package org.dailyinfo.telegrambot.telegrambot.service.quote.handle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.dailyinfo.telegrambot.telegrambot.service.quote.model.UpdateQuote;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@JsonIgnoreProperties
public class RequestToApi {

    private final String URL_API = "https://favqs.com/api/";
    private final String BODY_OF_REQUEST_API_FOR_RANDOM_QUOTE = "qotd";

    protected static HttpURLConnection connection;

    public static void createConnectionToApi() throws IOException {

        URL url = new URL(createUrlForRequest("https://favqs.com/api/", "qotd"));
        connection = (HttpURLConnection) url.openConnection();
        connection.connect();
    }

    public static void createConnectionToApi(String urlApi, String urlApiRequest) throws IOException {

        URL url = new URL(createUrlForRequest(urlApi, urlApiRequest));
        connection = (HttpURLConnection) url.openConnection();
        connection.connect();
    }

    protected static int connectionStatus() throws IOException {
        return connection.getResponseCode();
    }

    private static String createUrlForRequest(String urlApi, String urlApiRequest) {
        StringBuilder url = new StringBuilder(urlApi);
        url = url.append(urlApiRequest);
        return url.toString();
    }
}


