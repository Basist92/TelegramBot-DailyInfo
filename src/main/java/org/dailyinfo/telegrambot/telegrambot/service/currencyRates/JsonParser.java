package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {


    public List <Rate> getRates(String response) {
        List <Rate> rates = new ArrayList<>();

        //TODO: instead try catch understand if responce consist only from one rate
        JSONArray ratesJSON = null;
        JSONObject rateJSON = null;
        try {
            ratesJSON = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
            rateJSON = new JSONObject(response);
        }

        if (ratesJSON != null) {
            for (Object object : ratesJSON) {
                var rateJson = new JSONObject(object.toString());
                Rate rate = makeRateObject(rateJson);
                rates.add(rate);
            }
        } else {
            Rate rate = makeRateObject(rateJSON);
            rates.add(rate);
        }
        return rates;
    }

    private Rate makeRateObject(JSONObject rateJson) {
        int cur_ID = rateJson.getInt("Cur_ID");
        LocalDateTime date = LocalDateTime.parse(rateJson.getString("Date"));
        String cur_Abbreviation = rateJson.getString("Cur_Abbreviation");
        int cur_Scale = rateJson.getInt("Cur_Scale");
        String cur_Name = rateJson.getString("Cur_Name");
        Double cur_OfficialRate = rateJson.getDouble("Cur_OfficialRate");
        Rate rate = new Rate(cur_ID, date, cur_Abbreviation, cur_Scale, cur_Name,
            cur_OfficialRate);
        return rate;
    }
}
