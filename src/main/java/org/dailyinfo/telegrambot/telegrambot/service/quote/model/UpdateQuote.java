package org.dailyinfo.telegrambot.telegrambot.service.quote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateQuote {

    @JsonProperty("qotd_date")
    private String qotd_date;
    @JsonProperty("quote")
    private Quote quote;

    public UpdateQuote() {
    }

    public UpdateQuote(String qotd_date, Quote quote) {
        this.qotd_date = qotd_date;
        this.quote = quote;
    }

    public String getQotd_date() {
        return qotd_date;
    }
    public Quote getQuote() {
        return quote;
    }

    public boolean hasQuote(UpdateQuote quote) {
        return this.quote != null;
    }

    @Override
    public String toString() {
        return "UpdateQuote{" +
                "qotd_date='" + qotd_date + '\'' +
                quote.toString() +
                '}';
    }
}
