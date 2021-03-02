package org.dailyinfo.telegrambot.telegrambot.service.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dailyinfo.telegrambot.telegrambot.service.weather.bean.WeatherBean;

import java.io.IOException;

public class WeatherParsing {

    ObjectMapper mapper = new ObjectMapper();
    Weather weather = new Weather();
    WeatherBean weatherBean;

    public String getWeather() throws IOException {
       // weatherBean = mapper.readValue(weather.connection(), WeatherBean.class);
        return ("погода" + " " + "сегодня такая" + weather.connection());
    }
}