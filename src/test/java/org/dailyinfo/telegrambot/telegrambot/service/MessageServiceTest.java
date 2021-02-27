package org.dailyinfo.telegrambot.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dailyinfo.telegrambot.telegrambot.config.Mapper;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
class MessageServiceTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);

        String actualResult = messageService.onUpdateReceived(update);
        String expectedResult = "sorry, i don`t understand you";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onStartSReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/start.json"), Update.class);

        String actualResult = messageService.onUpdateReceived(update);
        String expectedResult = "Hi! I am your bot for every day =)";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onHelpSReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/help.json"), Update.class);

        String actualResult = messageService.onUpdateReceived(update);
        String expectedResult = "assistance at the development stage";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onSettingsSReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/settings.json"), Update.class);

        String actualResult = messageService.onUpdateReceived(update);
        String expectedResult = "currently no settings";
        assertEquals(expectedResult, actualResult);
    }
}