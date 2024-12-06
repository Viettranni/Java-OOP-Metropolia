package service;

import dao.CurrencyDao;

public class CurrencyService {

    public static double convert(double amount, String fromCurrencyRate, String toCurrencyRate) {
        try {
            double currency1 = CurrencyDao.getRate(fromCurrencyRate);
            double currency2 = CurrencyDao.getRate(toCurrencyRate);
            return amount * (currency2 / currency1);
        } catch (Exception e) {
            e.printStackTrace(); 
            throw new RuntimeException("Conversion failed: Unable to fetch exchange rates.", e); 
        }
    }
}
