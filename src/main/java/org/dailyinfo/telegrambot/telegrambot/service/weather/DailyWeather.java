package org.dailyinfo.telegrambot.telegrambot.service.weather;

import org.json.JSONArray;
import org.json.JSONObject;

public class DailyWeather {

    private String skyState;
    private int temp;
    private int humidity;
    private int visibility;
    private int cloudsAtAll;
    private String cityName;
    private int tempFeeled;
    private int pressure;
    private int windSpeed;
    private String country;


    public DailyWeather(JSONObject weatherToday) {
        this.cityName = weatherToday.getString("name");
        JSONArray weather = weatherToday.getJSONArray("weather");
        this.skyState = weather.getJSONObject(0).getString("description");
        JSONObject main = weatherToday.getJSONObject("main");
        JSONObject clouds = weatherToday.getJSONObject("clouds");
        this.cloudsAtAll = clouds.getInt("all");
        this.temp = main.getInt("temp");
        this.humidity = main.getInt("humidity");
        this.visibility = weatherToday.getInt("visibility");
        this.pressure = main.getInt("pressure");
        this.tempFeeled = main.getInt("feels_like");
        JSONObject wind = weatherToday.getJSONObject("wind");
        this.windSpeed = wind.getInt("speed");
        JSONObject sys = weatherToday.getJSONObject("sys");
        this.country = sys.getString("country");
    }

    @Override
    public String toString() {
        return "Погода в локации" + " " + cityName + "," + country + " " + "на данный момент:" + "\n" +
                skyState + ", температура наружного воздуха: " + temp + "°С," +
                " по ощущениям " + tempFeeled + "°С," + "\n" +
                "Относительная влажность воздуха: " + humidity + "%" + "\n" +
                "Атмосферное давление: " + pressure + "мбар" + "\n" +
                "Скорость ветра: " + windSpeed + "м/с" + "\n" +
                "Дальность видимости: " + visibility + "м";

    }
}
