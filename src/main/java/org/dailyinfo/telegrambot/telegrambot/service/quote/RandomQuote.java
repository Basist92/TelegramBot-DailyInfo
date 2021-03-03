package org.dailyinfo.telegrambot.telegrambot.service.quote;

import org.dailyinfo.telegrambot.telegrambot.service.quote.handle.Handler;
import org.dailyinfo.telegrambot.telegrambot.service.quote.handle.RequestToApi;
import org.dailyinfo.telegrambot.telegrambot.service.quote.model.UpdateQuote;

import java.io.IOException;

public class RandomQuote {

    public static String randomQuote() throws IOException {
        UpdateQuote quote = Handler.getRandomQuote();
        return quote.toString();
    }
}
