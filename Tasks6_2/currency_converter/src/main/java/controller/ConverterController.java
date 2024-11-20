package controller;

import java.util.Dictionary;

import view.ConverterView;
import model.Converter;

public class ConverterController {

    private Converter model;
    private ConverterView view;

    public ConverterController(Converter model, ConverterView view) {
        this.model = model;
        this.view = view;

    }

    public double convertNumbers(double amountToConvert, String selectedCurrency1, String selectedCurrency2) {
        return model.convert(amountToConvert, selectedCurrency1, selectedCurrency2);
    }
}

