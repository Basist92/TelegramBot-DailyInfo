package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {


    public List <Rate> getRates(String response) {

        List <Rate> rates = new ArrayList<>();
        JSONArray ratesJSON = new JSONArray(response);

        for (Object object:
             ratesJSON) {

            var rateJson = new JSONObject(object.toString());
            int cur_ID = rateJson.getInt("Cur_ID");
            LocalDateTime date = LocalDateTime.parse(rateJson.getString("Date"));
            String cur_Abbreviation = rateJson.getString("Cur_Abbreviation");
            int cur_Scale = rateJson.getInt("Cur_Scale");
            String cur_Name = rateJson.getString("Cur_Name");
            Double cur_OfficialRate = rateJson.getDouble("Cur_OfficialRate");

            rates.add(new Rate(cur_ID, date, cur_Abbreviation, cur_Scale, cur_Name, cur_OfficialRate));
        }

        return rates;
    }
}
