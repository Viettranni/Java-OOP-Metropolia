package controller;

import view.ConverterView;
import entity.Currency;
import entity.Transaction;
import dao.TransactionDao;

import jakarta.persistence.PersistenceException;
import service.CurrencyService;

import dao.CurrencyDao;

public class ConverterController {

    private Currency model;
    private ConverterView view;
    private TransactionDao transactionDao;

    public ConverterController(Currency model, ConverterView view) {
        this.model = model;
        this.view = view;
        this.transactionDao = new TransactionDao();
    }

    public double convertNumbers(double amountToConvert, String selectedCurrency1, String selectedCurrency2) {
        Currency currency = CurrencyDao.getCurrencyByCode(selectedCurrency2); 
        Transaction transaction = new Transaction(amountToConvert, currency);
        transactionDao.storeTransaction(transaction);
        return CurrencyService.convert(amountToConvert, selectedCurrency1, selectedCurrency2);
    }

    public String addNewCurrency(String currencyCode, String currencyName, double currencyRate) {
        try {
            // Attempt to insert the new currency into the database
            if (CurrencyDao.insertNewCurrency(currencyCode, currencyName, currencyRate)) {
                return "Currency " + currencyName + " added successfully!";
            } else {
                return "Error: Currency insertion failed";
            }
        } catch (PersistenceException e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "An unexpected error occurred: " + e.getMessage();
        }
    }
}
