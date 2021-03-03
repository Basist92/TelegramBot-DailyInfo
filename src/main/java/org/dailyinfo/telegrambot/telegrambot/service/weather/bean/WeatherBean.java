package org.dailyinfo.telegrambot.telegrambot.service.weather.bean;

import java.util.List;

public class WeatherBean {
    public Coord coord;
    public List<WeatherTypes> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public String dt;
    public Sys sys;
    public String timezone;
    public String id;
    public String name;
    public String cod;





}
class Coord{
    public String lon;
    public String lat;
}
class WeatherTypes {
    public String id;
    public String main;
    public String description;
    public String icon;
}
class Main {
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public double pressure;
    public double humidity;
}
class Wind {
    public int speed;
    public int deg;
    public int gust;
}
class Clouds {
    public int all;
}
class Sys {
    public int type;
    public  String id;
    public  String country;
    public  String sunrise;
    public  String sunset;
}