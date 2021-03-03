package org.dailyinfo.telegrambot.telegrambot.service.quote.handle;

import org.dailyinfo.telegrambot.telegrambot.service.quote.model.UpdateQuote;

import java.io.IOException;

public class Handler {

    public static UpdateQuote getRandomQuote() throws IOException {

        RequestToApi.createConnectionToApi();
        String response = Response.getResponse();

        return ResponseParser.getUpdateQuote(response);
    }

}
