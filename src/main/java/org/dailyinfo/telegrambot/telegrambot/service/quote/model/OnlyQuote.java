package org.dailyinfo.telegrambot.telegrambot.service.quote.model;

public class OnlyQuote {

    private String body;

    public String getBody() {
        return body;
    }

    public OnlyQuote(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "OnlyQuote{" +
                "body='" + body + '\'' +
                '}';
    }
}
