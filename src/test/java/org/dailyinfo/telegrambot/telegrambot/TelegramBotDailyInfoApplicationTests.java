package org.dailyinfo.telegrambot.telegrambot;

import org.dailyinfo.telegrambot.telegrambot.config.Mapper;
import org.dailyinfo.telegrambot.telegrambot.service.MessageService;
import org.dailyinfo.telegrambot.telegrambot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
class TelegramBotDailyInfoApplicationTests {

	@Test
	void contextLoads() {
	}

}
