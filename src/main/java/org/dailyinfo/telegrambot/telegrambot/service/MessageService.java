package org.dailyinfo.telegrambot.telegrambot.service;


import org.dailyinfo.telegrambot.telegrambot.service.currencyRates.View;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.io.IOException;


@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) throws IOException {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message.hasText()) {
                String messageText = message.getText();
                switch (messageText) {
                    case "/start":
                        return sendMessage.setText("Hi! I am your bot for every day =)");
                    case "/settings":
                        return sendMessage.setText("currently no settings");
                    case "/help":
                        return sendMessage.setText("assistance at the development stage");
                    case "/rates":
                            return sendMessage.setText(new View().present());
                }
            }
        }
        return sendMessage.setText("sorry, i don`t understand you");
    }

}
