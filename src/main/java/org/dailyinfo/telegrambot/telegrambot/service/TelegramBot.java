package org.dailyinfo.telegrambot.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUserName;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Override
    public void onUpdateReceived(Update update) {

//      this is method will need for covering by test (he saves JSON)
//        saveJSON(update);

        SendMessage sendMessage = messageService.onUpdateReceived(update);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private void saveJSON(Update update) {
        try {
            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
