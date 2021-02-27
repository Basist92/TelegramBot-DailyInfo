package org.dailyinfo.telegrambot.telegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    public String onUpdateReceived(Update update) {
        if (update != null) {
            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                String messageText = message.getText();
                if (messageText.equals("/start")) {
                    return "Hi! I am your bot for every day =)";
                } else if (messageText.equals("/settings")) {
                    return "currently no settings";
                } else if (messageText.equals("/help")) {
                    return "assistance at the development stage";
                }
            }
        }
        return "sorry, i don`t understand you";
    }

}
