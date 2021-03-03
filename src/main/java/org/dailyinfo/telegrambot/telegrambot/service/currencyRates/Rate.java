package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rate {

    private int Cur_ID;
    private LocalDateTime Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private Double Cur_OfficialRate;

    public Rate(int cur_ID, LocalDateTime date, String cur_Abbreviation, int cur_Scale, String cur_Name, Double cur_OfficialRate) {
        Cur_ID = cur_ID;
        Date = date;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Scale = cur_Scale;
        Cur_Name = cur_Name;
        Cur_OfficialRate = cur_OfficialRate;
    }

    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public Double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(Double cur_OfficialRate) {
        Cur_OfficialRate = cur_OfficialRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Cur_ID == rate.Cur_ID && Cur_Scale == rate.Cur_Scale && Objects.equals(Date, rate.Date) && Objects.equals(Cur_Abbreviation, rate.Cur_Abbreviation) && Objects.equals(Cur_Name, rate.Cur_Name) && Objects.equals(Cur_OfficialRate, rate.Cur_OfficialRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cur_ID, Date, Cur_Abbreviation, Cur_Scale, Cur_Name, Cur_OfficialRate);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "Cur_ID=" + Cur_ID +
                ", Date=" + Date +
                ", Cur_Abbreviation='" + Cur_Abbreviation + '\'' +
                ", Cur_Scale=" + Cur_Scale +
                ", Cur_Name='" + Cur_Name + '\'' +
                ", Cur_OfficialRate=" + Cur_OfficialRate +
                '}';
    }
}

