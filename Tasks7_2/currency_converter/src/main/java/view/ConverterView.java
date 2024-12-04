package view;

import entity.Converter;
import controller.ConverterController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class ConverterView extends Application {
    private TextField inputFirstAmount = new TextField();
    private TextField showConversion = new TextField();
    private ConverterController controller;
    private Converter model;

    public void setupTextField() {
        // Restrict input to numbers (decimal numbers)
        TextFormatter<String> numberFormatter = new TextFormatter<>(change -> {
            String text = change.getControlNewText();
            if (text.matches("^[0-9]*\\.?[0-9]*$")) { // Regular expression for numeric input
                return change;
            } else {
                return null; // Reject invalid input
            }
        });

        inputFirstAmount.setTextFormatter(numberFormatter);
        showConversion.setTextFormatter(numberFormatter);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Currency Converter");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // Grid for inputs and labels
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        // Labels and components
        Label inputAmountLabel = new Label("Enter Amount:");
        Label resultLabel = new Label("Converted Amount:");
        Label fromCurrencyLabel = new Label("From Currency:");
        Label toCurrencyLabel = new Label("To Currency:");
        Button convertButton = new Button("Convert");

        ObservableList<String> currencyOptions = FXCollections.observableArrayList(Converter.currencyCodeList);
        ChoiceBox<String> fromCurrency = new ChoiceBox<>(currencyOptions);
        ChoiceBox<String> toCurrency = new ChoiceBox<>(currencyOptions);
        fromCurrency.setValue(currencyOptions.get(0));
        toCurrency.setValue(currencyOptions.get(1));

        // Text field placeholders
        inputFirstAmount.setPromptText("Enter amount");
        showConversion.setPromptText("Converted amount");

        // Add components to the grid
        grid.add(inputAmountLabel, 0, 0);
        grid.add(inputFirstAmount, 1, 0);
        grid.add(fromCurrencyLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(resultLabel, 0, 2);
        grid.add(showConversion, 1, 2);
        grid.add(toCurrencyLabel, 0, 3);
        grid.add(toCurrency, 1, 3);
        grid.add(convertButton, 1, 4);

        // Add title and grid to the root layout
        root.getChildren().addAll(title, grid);

        // Scene setup
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();

        // Conversion logic
        convertButton.setOnAction((ActionEvent event) -> {
            try {
                double amountToConvert = Double.parseDouble(inputFirstAmount.getText());
                String selectedFromCurrency = fromCurrency.getValue();
                String selectedToCurrency = toCurrency.getValue();
                System.out.println(selectedFromCurrency);
                System.out.println(selectedToCurrency);

                if (amountToConvert > 0 && selectedFromCurrency != null && selectedToCurrency != null) {
                    double convertedAmount = controller.convertNumbers(amountToConvert, selectedFromCurrency, selectedToCurrency);
                    showConversion.setText(String.format("%.2f", convertedAmount));
                } else {
                    showConversion.setText("Error: Invalid input");
                }
            } catch (NumberFormatException e) {
                showConversion.setText("Error: Enter a valid number!");
            }
        });
    }

    @Override
    public void init() {
        model = new Converter();
        controller = new ConverterController(model, this);
    }
}
