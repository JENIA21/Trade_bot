package com.company.telegram.commands;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Rate {

    Document documentDollar;

    {
        try {
            documentDollar = Jsoup.connect("https://www.banki.ru/products/currency/cash/usd/ekaterinburg/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDollarRate() {
        return (int) parseDouble(documentDollar.getElementsByClass("currency-table__large-text").get(1).text().replaceAll(",", "."));
    }
}
