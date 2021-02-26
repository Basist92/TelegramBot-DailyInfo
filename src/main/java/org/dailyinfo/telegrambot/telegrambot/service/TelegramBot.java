package org.dailyinfo.telegrambot.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.userName}")
    private String botUserName;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            objectMapper.writeValue(new File
                    ("src/test/resources/update.json"),update);
//            System.out.println("written");
        } catch (Exception ex) {
            ex.printStackTrace();
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
}
