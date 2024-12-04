package application;

import java.util.List;

import dao.CurrencyDao;
import entity.Converter;
import view.ConverterView;

public class Main {
    public static void main(String[] args) {
    List<String> codes = CurrencyDao.loadCurrencyCodes();
    Converter.currencyCodeList.clear();
    Converter.currencyCodeList.addAll(codes);
    ConverterView.launch(ConverterView.class);
}

}
