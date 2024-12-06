package view;

import entity.Currency;
import controller.ConverterController;
import view.AddCurrencyWindow;
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
    private Label showConversion = new Label();

    private ConverterController controller;
    private Currency model;

    public void setupTextField() {
        // Restrict input to valid double values
        TextFormatter<Double> doubleFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?\\d*(\\.\\d*)?")) {
                return change; 
            } else {
                return null; 
            }
        });
    
        // Set the formatter to the text field
        inputFirstAmount.setTextFormatter(doubleFormatter);
    }


    public void setController(ConverterController controller) {
        this.controller = controller;
    }


    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Currency Converter");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // Grid for inputs and labels
        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        // Labels and components
        Label inputAmountLabel = new Label("Enter Amount:");
        Label resultLabel = new Label("Converted Amount:");
        Label fromCurrencyLabel = new Label("From Currency:");
        Label toCurrencyLabel = new Label("To Currency:");
        Button convertButton = new Button("Convert");
        

        // Button to open the new window for new currency
        Button openAddCurrencyButton = new Button("Open Add Currency Window");

        // Returns the list of currencies into choice box
        ObservableList<String> currencyOptions = FXCollections.observableArrayList(Currency.currencyCodeList);
        ChoiceBox<String> fromCurrency = new ChoiceBox<>(currencyOptions);
        ChoiceBox<String> toCurrency = new ChoiceBox<>(currencyOptions);
        fromCurrency.setValue(currencyOptions.get(0));
        toCurrency.setValue(currencyOptions.get(1));

        // Text field placeholders
        inputFirstAmount.setPromptText("Enter amount");

        // Add components to the grid
        grid.add(inputAmountLabel, 0, 0);
        grid.add(inputFirstAmount, 1, 0);
        grid.add(fromCurrencyLabel, 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(toCurrencyLabel, 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(showConversion, 1, 3);
        grid.add(resultLabel, 0, 3);
        grid.add(convertButton, 1, 4);
        grid.add(openAddCurrencyButton, 0, 4);

        // Add title and grid to the root layout
        root.getChildren().addAll(title, grid);

        // Scene setup
        Scene scene = new Scene(root, 800, 350);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Conversion Button logic
        convertButton.setOnAction((ActionEvent event) -> {
            try {
                double amountToConvert = Double.parseDouble(inputFirstAmount.getText());
                String selectedFromCurrency = fromCurrency.getValue();
                String selectedToCurrency = toCurrency.getValue();

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

        // Opening the new window for adding the new currency
        openAddCurrencyButton.setOnAction(e -> {
            // Create the AddCurrencyWindow and pass primaryStage for updating the list of currencies
            AddCurrencyWindow addCurrencyWindow = new AddCurrencyWindow(primaryStage, controller);
            Stage newStage = new Stage(); 
            addCurrencyWindow.start(newStage);
            newStage.showAndWait(); // Wait for the new stage to close before continuing
        });
    }

    @Override
    public void init() {
        model = new Currency();
        controller = new ConverterController(model, this);
    }
}
