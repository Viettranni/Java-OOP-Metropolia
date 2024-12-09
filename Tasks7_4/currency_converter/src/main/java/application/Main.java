package application;

import java.util.List;

import dao.CurrencyDao;
import entity.Currency;
import view.ConverterView;

public class Main {
    public static void main(String[] args) {
    CurrencyDao.insertInitialCurrencies();

    List<String> codes = CurrencyDao.loadCurrencyCodes();
    Currency.currencyCodeList.clear();
    Currency.currencyCodeList.addAll(codes);
    
    ConverterView.launch(ConverterView.class);
    }   
}
