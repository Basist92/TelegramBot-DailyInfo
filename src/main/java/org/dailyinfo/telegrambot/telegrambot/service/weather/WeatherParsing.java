package org.dailyinfo.telegrambot.telegrambot.service.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dailyinfo.telegrambot.telegrambot.service.weather.bean.WeatherBean;
import java.io.IOException;
public class WeatherParsing {
    ObjectMapper mapper = new ObjectMapper();
    Weather weather = new Weather();


        String jsonString;

    {
        try {
            jsonString = weather.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    WeatherBean weatherBean;

    {
        try {
            weatherBean = mapper.readValue(jsonString, WeatherBean.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    public String getWeather (){

        return ("погода" + " " + "сегодня такая" + " " + weatherBean.name + " " + weatherBean.visibility + " " + weatherBean.main);
    }

}