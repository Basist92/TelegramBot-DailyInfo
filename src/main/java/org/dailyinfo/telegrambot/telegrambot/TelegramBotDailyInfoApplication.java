package org.dailyinfo.telegrambot.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TelegramBotDailyInfoApplication {

	public static void main(String[] args) {

		ApiContextInitializer.init();
		SpringApplication.run(TelegramBotDailyInfoApplication.class, args);
	}

}
