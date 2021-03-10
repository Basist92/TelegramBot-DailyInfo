package org.dailyinfo.telegrambot.telegrambot.service.weather;

import org.json.JSONArray;
import org.json.JSONObject;

public class DailyWeather {

    private final String skyState;
    private final int temp;
    private final int humidity;
    private final int visibility;
    private final String cityName;
    private final int tempFelt;
    private final int pressure;
    private final int windSpeed;
    private final String country;


    public DailyWeather(JSONObject weatherToday) {
        this.cityName = weatherToday.getString("name");
        JSONArray weather = weatherToday.getJSONArray("weather");
        this.skyState = weather.getJSONObject(0).getString("description");
        JSONObject main = weatherToday.getJSONObject("main");
        this.temp = main.getInt("temp");
        this.humidity = main.getInt("humidity");
        this.visibility = weatherToday.getInt("visibility");
        this.pressure = main.getInt("pressure");
        this.tempFelt = main.getInt("feels_like");
        JSONObject wind = weatherToday.getJSONObject("wind");
        this.windSpeed = wind.getInt("speed");
        JSONObject sys = weatherToday.getJSONObject("sys");
        this.country = sys.getString("country");
    }

    @Override
    public String toString() {
        return "Погода в локации" + " " + cityName + "," + country + " " + "на данный момент:" + "\n" +
                skyState + ", температура наружного воздуха: " + temp + "°С," +
                " по ощущениям " + tempFelt + "°С," + "\n" +
                "Относительная влажность воздуха: " + humidity + "%" + "\n" +
                "Атмосферное давление: " + pressure + "мбар" + "\n" +
                "Скорость ветра: " + windSpeed + "м/с" + "\n" +
                "Дальность видимости: " + visibility + "м";

    }
}
