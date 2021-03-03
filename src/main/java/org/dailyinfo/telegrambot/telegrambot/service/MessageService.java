package org.dailyinfo.telegrambot.telegrambot.service;


import org.dailyinfo.telegrambot.telegrambot.service.weather.Weather;
import org.dailyinfo.telegrambot.telegrambot.service.weather.WeatherParsing;
import org.dailyinfo.telegrambot.telegrambot.service.quote.RandomQuote;
import org.dailyinfo.telegrambot.telegrambot.service.horoscope.*;
import org.dailyinfo.telegrambot.telegrambot.service.horoscope.Horoscope.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

@Service
public class MessageService{
@Autowired
        Aquarius aquarius;
    @Autowired
        Aries aries;
    @Autowired
        Cancer cancer;
    @Autowired
        Capricorn capricorn;
    @Autowired
        Gemini gemini;
        Leo leo;
    @Autowired
        Libra libra;
    @Autowired
        Pisces pisces;
    @Autowired
        Saggittarius saggittarius;
    @Autowired
        Scorpio scorpio;
    @Autowired
        Taurus taurus;
    @Autowired
        Virgo virgo;

    public SendMessage onUpdateReceived(Update update) throws IOException {

      Aquarius aquarius = new Aquarius();

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
                    return sendMessage.setText(weather.connection());
                } else if (messageText.equals("/quote")) {
                    try {
                        return sendMessage.setText(RandomQuote.randomQuote());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return sendMessage.setText("Sorry, no server is available to handle this request.");
                    }
			    }
			  
			  if (messageText.equals("/horoscope")) {
                    return sendMessage.setText("Знаки зодиака:  " + "\n" + "/leo" + "\n" + "/aquarius" + "\n" + "/aries"
                            + "\n" + "/cancer" + "\n" + "/capricorn" + "\n" + "/gemini" + "\n" + "/libra" +
                            "\n" + "/pisces" + "\n" + "/saggitarius" + "\n" + "/scorpio" + "\n" + "/taurus" + "\n" + "/virgo");

                }  if (messageText.equals("/leo")) {

                    return sendMessage.setText(leo.forLeo("Лев", 0) + leo.forLeo("Лев", 1)
                            + leo.forLeo("Лев", 2) + leo.forLeo("Лев", 3));
                }
                if (messageText.equals("/aquarius")) {

                        return sendMessage.setText(aquarius.forAquarius("Водолей", 0) + aquarius.forAquarius("Водолей", 1)
                                + aquarius.forAquarius("Водолей", 2) +aquarius.forAquarius("Водолей", 3));
                    }
                if (messageText.equals("/aries")) {

                    return sendMessage.setText(aries.forAries("Овен", 0) + aries.forAries("Овен",1)
                            + aries.forAries("Овен",2) + aries.forAries("Овен",3));
                }


                if (messageText.equals("/cancer")) {
                    return sendMessage.setText(cancer.forCancer("Рак", 0) + cancer.forCancer("Рак", 1) +
                            cancer.forCancer("Рак", 2) + cancer.forCancer("Рак", 3));

                }
                if (messageText.equals("/capricorn")) {
                    return sendMessage.setText(capricorn.forCapricorn("Козерог", 0) + capricorn.forCapricorn("Козерог", 1) +
                            capricorn.forCapricorn("Козерог", 2) + capricorn.forCapricorn("Козерог", 3));
                }
                if (messageText.equals("/gemini")) {
                    return sendMessage.setText(gemini.forGemini("Близнецы", 0) + gemini.forGemini("Близнецы", 1)
                            + gemini.forGemini("Близнецы", 2) + gemini.forGemini("Близнецы", 3));
                }

                if (messageText.equals("/libra")) {
                    return sendMessage.setText(libra.forLibra("Весы", 0) + libra.forLibra("Весы", 1) +
                            libra.forLibra("Весы", 2) + libra.forLibra("Весы", 3));
                }
                if (messageText.equals("/pisces")) {
                    return sendMessage.setText(pisces.forPisces("Рыбы", 0) + pisces.forPisces("Рыбы", 1)
                            + pisces.forPisces("Рыбы", 2) + pisces.forPisces("Рыбы", 3));
                }
                if (messageText.equals("/saggitarius")) {
                    return sendMessage.setText(saggittarius.forSaggitarius("Стрелец", 0) + saggittarius.forSaggitarius("Стрелец", 1)
                            + saggittarius.forSaggitarius("Стрелец", 2) + saggittarius.forSaggitarius("Стрелец", 3));
                }

                if (messageText.equals("/scorpio")) {
                    return sendMessage.setText(scorpio.forScorpio("Скорпион", 0) + scorpio.forScorpio("Скорпион", 1)
                            + scorpio.forScorpio("Скорпион", 2) + scorpio.forScorpio("Скорпион", 3));
                }
                if (messageText.equals("/taurus")) {
                    return sendMessage.setText(taurus.forTaurus("Телец", 0) + taurus.forTaurus("Телец", 1)
                            + taurus.forTaurus("Телец", 2) + taurus.forTaurus("Телец", 3));
                }
                if (messageText.equals("/virgo")) {
                    return sendMessage.setText(virgo.forVirgo("Дева", 0) + virgo.forVirgo("Дева", 1) +
                            virgo.forVirgo("Дева", 2) + virgo.forVirgo("Дева", 3));
                }

            }
        }
        return sendMessage.setText("sorry, i don`t understand you");
    }

}