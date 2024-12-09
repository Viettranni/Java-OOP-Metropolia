package entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


// This package contains the entity classes. Using MVC terms, this constitutes the MODEL.

@Entity
public class Currency {
    public static List<String> currencyCodeList = new ArrayList<String>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(name = "currency_code", unique = true)
    private String currencyCode;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "exchange_rate")
    private double exchangeRate;

    public Currency() {

    }

    public Currency(String currencyCode, double exchangeRate, String currencyName) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
    }


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    } 

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}

