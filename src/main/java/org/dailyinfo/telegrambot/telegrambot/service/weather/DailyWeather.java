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
    }

    @Override
    public String toString() {
        return "dailyWeather{" +
                "skyState = '" + skyState + '\'' +
                " , temp = " + temp +
                " , humidity = " + humidity +
                " , visibility = " + visibility +
                " , cloudsAtAllInPercents = " + cloudsAtAll +
                " , cityName = '" + cityName + '\'' +
                '}';
    }
}
