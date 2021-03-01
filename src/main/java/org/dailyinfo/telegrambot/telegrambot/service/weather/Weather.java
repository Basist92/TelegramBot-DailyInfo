package org.dailyinfo.telegrambot.telegrambot.service.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//"http://api.openweathermap.org/data/2.5/weather?q=London&appid=19efcf206130c164112f3620a141d3d1"
public class Weather {
    @Autowired
    ObjectMapper objectMapper;
    private void saveJSON(String mess) {
        try {
            objectMapper.writeValue(new File("src/main/resources/weather.json"), mess);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String connection() throws IOException {
        final URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Minsk&units=metric&lang=ru&appid=19efcf206130c164112f3620a141d3d1");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(1000);
        con.setReadTimeout(1000);
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            saveJSON(content.toString());
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }


    }


}
