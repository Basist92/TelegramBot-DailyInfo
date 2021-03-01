package org.dailyinfo.telegrambot.telegrambot.service;

import org.dailyinfo.telegrambot.telegrambot.service.weather.Weather;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        Weather weather = new Weather();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message != null && message.hasText()) {
                String messageText = message.getText();
                if (messageText.equals("/start")) {
                    return sendMessage.setText("Hi! I am your bot for every day =)");
                } else if (messageText.equals("/settings")) {
                    return sendMessage.setText("currently no settings");
                } else if (messageText.equals("/help")) {
                    return sendMessage.setText("assistance at the development stage");
                }else if (messageText.equals("/weather")) {
                    try {
                        return sendMessage.setText(weather.connection());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sendMessage.setText("sorry, i don`t understand you");
    }

}
