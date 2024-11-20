package model;

import view.ConverterView;
import controller.ConverterController;

public class Converter {

    private double USD = 1.0;
    private double EUR = 0.95;
    private double VND = 25425.0;

    public double getUSD(String fromCurrency) {
        switch (fromCurrency) {
            case "EUR":
                return 1.05;  // 1 EUR = 1.1 USD
            case "VND":
                return 0.000043;  // 1 VND = 0.000043 USD
            default:
                return 1.0;
        }
    }

    public double getEUR(String fromCurrency) {
        switch (fromCurrency) {
            case "USD":
                return 0.95;  // 1 USD = 0.95 EUR
            case "VND":
                return 0.000039;  // 1 VND = 0.000039 EUR
            default:
                return 1.0;
        }
    }

    public double getVND(String fromCurrency) {
        switch (fromCurrency) {
            case "USD":
                return 23000;  // 1 USD = 23,000 VND
            case "EUR":
                return 25000;  // 1 EUR = 25,000 VND
            default:
                return 1.0;
        }
    }

    // Method for conversion
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double conversionRate = 1.0;

        switch (toCurrency) {
            case "USD":
                conversionRate = getUSD(fromCurrency);
                break;
            case "EUR":
                conversionRate = getEUR(fromCurrency);
                break;
            case "VND":
                conversionRate = getVND(fromCurrency);
                break;
            default:
                System.out.println("Currency not supported");
                return -1;
        }

        return amount * conversionRate;
    }
}


