package org.dailyinfo.telegrambot.telegrambot.service.weather.bean;

public class WeatherBean {
    public String name;
    public String country;
    public String description;
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
    public int speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // public WeatherBean(String name, String country, String description, double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity, int speed) {
    //     this.name = name;
    //     this.country = country;
    //     this.description = description;
    //     this.temp = temp;
    //     this.feels_like = feels_like;
    //     this.temp_min = temp_min;
    //     this.temp_max = temp_max;
    //     this.pressure = pressure;
    //     this.humidity = humidity;
    //     this.speed = speed;
    //
    // }


}