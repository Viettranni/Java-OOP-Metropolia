package entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.CurrencyDao;


// This package contains the entity classes. Using MVC terms, this constitutes the MODEL.

public class Converter {

    public static List<String> currencyCodeList = new ArrayList<String>();

    private double fromExchangeRate = 0.0;
    private double toExchangeRate = 0.0;
    private String fromCurrency;
    private String toCurrency;


    // GETTERS & SETTERS

    public double getFromExchangeRate() {
        return fromExchangeRate;
    }

    public double getToExchangeRate() {
        return toExchangeRate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }


    // Method for conversion
    public double convert(double amount, String fromCurrencyRate, String toCurrencyRate) {
        try {
            double currency1 = CurrencyDao.getRate(fromCurrencyRate);
            double currency2 = CurrencyDao.getRate(toCurrencyRate);
            return amount * (currency2 / currency1);
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception (replace with a proper logger in production)
            throw new RuntimeException("Conversion failed: Unable to fetch exchange rates.", e); // Convert to an unchecked exception or handle it gracefully
        }
    }
    

}


