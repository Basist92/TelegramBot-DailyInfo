package org.dailyinfo.telegrambot.telegrambot.service.quote.handle;

import org.dailyinfo.telegrambot.telegrambot.service.quote.model.UpdateQuote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class Response {

    public static String getResponse() throws IOException {

        int connectionStatus = RequestToApi.connectionStatus();

        InputStream inputStream;
        if (connectionStatus == HttpURLConnection.HTTP_OK) {
            inputStream = RequestToApi.connection.getInputStream();
        } else
            inputStream = RequestToApi.connection.getErrorStream();

        return convertStreamToString(inputStream);
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {

        BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilderResponse = new StringBuilder();

        String line;
        while ((line = streamReader.readLine()) != null) {
            stringBuilderResponse.append(line).append("\n");
        }
        inputStream.close();

        return stringBuilderResponse.toString();
    }
}

