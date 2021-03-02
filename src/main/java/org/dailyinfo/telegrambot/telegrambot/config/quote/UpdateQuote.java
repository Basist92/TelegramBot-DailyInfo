package org.dailyinfo.telegrambot.telegrambot.config.quote;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

public class UpdateQuote {

    @JsonProperty("qotd_date")
    private String qotd_date;
    @JsonProperty("quote")
    private Quote quote;

    public UpdateQuote() {
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
}
