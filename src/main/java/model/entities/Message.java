package model.entities;

import model.ExchangeCurrencyRepository;
import java.io.IOException;
import java.util.ArrayList;

public class Message {
    public ArrayList<Product> products;
    public double total;
    public double discount;
    public double usdTotal;
    public double eurTotal;

    public Message(ArrayList<Product> newProducts, double newTotal, double newDiscount) throws IOException {
        products = newProducts;
        total = newTotal;
        discount = newDiscount;
        ExchangeCurrencyRepository usdCurrencyExchanger = new ExchangeCurrencyRepository("GBP", "USD");
        usdTotal = usdCurrencyExchanger.exchangeRatio * total;
        usdTotal = Math.round(usdTotal * 100.0) / 100.0;
        ExchangeCurrencyRepository eurCurrencyExchanger = new ExchangeCurrencyRepository("GBP", "EUR");
        eurTotal = eurCurrencyExchanger.exchangeRatio * total;
        eurTotal = Math.round(eurTotal * 100.0) / 100.0;
    }
}
