package org.dailyinfo.telegrambot.telegrambot.service.quote.handle;

import org.dailyinfo.telegrambot.telegrambot.service.quote.model.OnlyQuote;
import org.dailyinfo.telegrambot.telegrambot.service.quote.model.Quote;
import org.dailyinfo.telegrambot.telegrambot.service.quote.model.UpdateQuote;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseParser {

    public static UpdateQuote getUpdateQuote(String responseFromApi) {

        JSONObject updateQuoteJson;
//        try {
//            updateQuoteJson = new JSONObject(responseFromApi);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        updateQuoteJson = new JSONObject(responseFromApi);
        return makeUpdateQuoteObject(updateQuoteJson);
    }

//    //TODO model for Quote with only one string -> Body of quote
//    private static OnlyQuote makeUpdateQuoteObject(JSONObject updateQuoteJson, int quantityOfLine) {
//        String body = updateQuoteJson.getString("body");
//        return new OnlyQuote(body);
//    }

    private static UpdateQuote makeUpdateQuoteObject(JSONObject updateQuoteJson) {

        String qotd_date = updateQuoteJson.getString("qotd_date");
        int id = updateQuoteJson.getInt("id");
        boolean dialogue = updateQuoteJson.getBoolean("dialogue");
        boolean isPrivate = updateQuoteJson.getBoolean("private");
        String[] tags = getArrayOfStringFromJson(updateQuoteJson, "tags");
        String url = updateQuoteJson.getString("url");
        int favorites_count = updateQuoteJson.getInt("favorites_count");
        int upvotes_count = updateQuoteJson.getInt("upvotes_count");
        int downvotes_count = updateQuoteJson.getInt("downvotes_count");
        String author = updateQuoteJson.getString("author");
        String author_permalink = updateQuoteJson.getString("author_permalink");
        String body = updateQuoteJson.getString("body");


        Quote quote = new Quote(id, dialogue, isPrivate, tags,
                url, favorites_count, upvotes_count, downvotes_count,
                author, author_permalink, body);

        return new UpdateQuote(qotd_date, quote);
    }

    private static String[] getArrayOfStringFromJson(JSONObject jsonObject, String key) {

        JSONArray arrJson = jsonObject.getJSONArray(key);
        int lengthOfArray = arrJson.length();
        String[] newArray = new String[lengthOfArray];
        for (
                int i = 0; i < arrJson.length(); i++)
            newArray[i] = arrJson.getString(i);
        return newArray;
    }

}
