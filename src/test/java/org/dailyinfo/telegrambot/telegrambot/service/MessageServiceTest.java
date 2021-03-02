package org.dailyinfo.telegrambot.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dailyinfo.telegrambot.telegrambot.config.Mapper;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = createMessage("sorry, i don`t understand you");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onStartReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/start.json"), Update.class);

        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = createMessage("Hi! I am your bot for every day =)");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onHelpReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/help.json"), Update.class);

        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = createMessage("assistance at the development stage");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onSettingsReceived() throws IOException {

        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/settings.json"), Update.class);

        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = createMessage("currently no settings");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onUSDReceived() throws IOException {
        Update update = objectMapper.readValue(
                new File("src/test/resources/botCommand/USDTest.json"), Update.class);

        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = createMessage(exampleWithUSD());
        String strExpected = expectedResult.toString().replaceAll("\\s+","");
        String strActual = actualResult.toString().replaceAll("\\s+","");
        assertEquals(strExpected, strActual);

    }


    private String exampleWithUSD() {
        String usdExample = String.format("ОФИЦИАЛЬНЫЕ КУРСЫ ВАЛЮТ ПО НБРБ на сегодня \n%s\n\n",
                LocalDate.of(2020, 7, 6).format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))) + "\n" +
                "\n" +
                " Код   Кол. Ед.   Валюта                                  Курс   \n" +
                "======================================================== USD   1     " +
                "     Доллар США                                2.4214\n";
        return usdExample;
    }


    private SendMessage createMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(763001640L);
        sendMessage.setText(text);
        return sendMessage;
    }
}