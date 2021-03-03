package org.dailyinfo.telegrambot.telegrambot.service.currencyRates;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class View {

    private LocalDate today ;
    private final List<Rate> rates;

    public View(String currencyRate) throws IOException {
        RequestToBank request = new RequestToBank();
        rates = request.connection(currencyRate);
        if(currencyRate.equals("/USDTest")){
            today = LocalDate.of(2020, 7, 6);
        }else {
            today = LocalDate.now();
        }
     }

    public String present(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("ОФИЦИАЛЬНЫЕ КУРСЫ ВАЛЮТ ПО НБРБ на сегодня \n%s\n\n",
                today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))));
        str.append("\tКод  \tКол. Ед.  \tВалюта                                 \tКурс   \n");
        str.append("========================================================");

        for (Rate rate:
                rates) {
            str.append(String.format("\t%-5s\t%-10s\t%-39s\t%8s\n",
                    rate.getCur_Abbreviation(),
                    rate.getCur_Scale(),
                    rate.getCur_Name(),
                    rate.getCur_OfficialRate()));
        }

        return str.toString();
    }
}
