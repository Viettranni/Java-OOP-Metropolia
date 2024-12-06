package entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


// This package contains the entity classes. Using MVC terms, this constitutes the MODEL.

@Entity
// It maps first to the currencies TABLE
@Table(name = "currencies")
public class Currency {
    public static List<String> currencyCodeList = new ArrayList<String>();

    @Id
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "exchange_rate")
    private double exchangeRate;

    @Column(name = "currency_name")
    private String currencyName;

    // Getters and Setters
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

