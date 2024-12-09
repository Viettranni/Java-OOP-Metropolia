package view;

import entity.Currency;
import controller.ConverterController;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class AddCurrencyWindow {
    private Stage primaryStage;

    public AddCurrencyWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private TextField inputCurrencyCodeText = new TextField();
    private TextField inputCurrencyNameText = new TextField();
    private TextField inputCurrencyCodeRate = new TextField();
    private Label showResultText = new Label();

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
        inputCurrencyCodeRate.setTextFormatter(doubleFormatter);
    }

    public void setupOnlyLetters() {
        // Restrict input to uppercase letters only
        TextFormatter<String> uppercaseFormatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[A-Z]*")) { 
                return change; 
            } else {
                return null; 
            }
        });
    
        // Apply the formatter to the text fields
        inputCurrencyCodeText.setTextFormatter(uppercaseFormatter);
        inputCurrencyNameText.setTextFormatter(uppercaseFormatter);
    }

    public AddCurrencyWindow(Stage primaryStage, ConverterController controller) {
        this.primaryStage = primaryStage;
        this.controller = controller;
    }


    public void start(Stage newStage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Add New Currency");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333;");

        // Grid for inputs and labels
        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        Label inputCurrencyCodeLabel = new Label("Enter Currency Code");
        Label inputCurrencyRateLabel = new Label("Enter Currency Rate:");
        Label inputCurrencyNameLabel = new Label("Enter Currency Name: ");
        Label showResultLabel = new Label("Results:");
        Button addCurrencyButton = new Button("Add Currency to Database");

        // Text field placeholders
        inputCurrencyCodeText.setPromptText("EUR/VND/ANY");
        inputCurrencyCodeRate.setPromptText("1.5687");
        inputCurrencyNameText.setPromptText("Vietnamese Dong");

        // Add components to the grid
        grid.add(inputCurrencyCodeLabel, 0, 0);
        grid.add(inputCurrencyCodeText, 1, 0);
        grid.add(inputCurrencyRateLabel, 0, 1);
        grid.add(inputCurrencyCodeRate, 1, 1);
        grid.add(inputCurrencyNameLabel, 0, 2);
        grid.add(inputCurrencyNameText, 1, 2);
        grid.add(showResultLabel, 1, 3);
        grid.add(showResultText, 0, 3);
        grid.add(addCurrencyButton, 1, 4);

        // Add title and grid to the root layout
        root.getChildren().addAll(title, grid, addCurrencyButton);

        // Scene setup
        Scene scene = new Scene(root, 800, 350);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        
        newStage.setTitle("Currency Converter - Add Currency");
        newStage.setScene(scene);
        newStage.show();

        // Adding the Currency to the database Button
        addCurrencyButton.setOnAction((ActionEvent event) -> {
            try {
                // Validate the currency
                String inputtedCurrency = inputCurrencyCodeText.getText();
                if (inputtedCurrency.isEmpty()) {
                    showResultText.setText("Error: Currency code cannot be empty!");
                    return;
                }

                // Validate the currency name
                String inputtedCurrencyName = inputCurrencyNameText.getText();
                if (inputtedCurrencyName.isEmpty()) {
                    showResultText.setText("Error: Please enter the currency name!!");
                    return;
                }
        
                // Validate the currency rate
                String rateText = inputCurrencyCodeRate.getText();
                if (rateText.isEmpty()) {
                    showResultText.setText("Error: Please enter the exchange rate!");
                    return;
                }

                if (controller != null) {
                    // Assuming the method takes name, code, and rate as parameters
                    double inputtedRate = Double.parseDouble(rateText);
                    String result = controller.addNewCurrency(inputtedCurrency, inputtedCurrencyName, inputtedRate);
                    showResultText.setText(result);
                    System.out.println(result);
                } else {
                    System.out.println("Controller is not initialized.");
                }
        
                // double inputtedRate = Double.parseDouble(rateText);
                // String result = controller.addNewCurrency(inputtedCurrency, inputtedCurrencyName, inputtedRate);
        
                // Display the result (success or error message)
                // showResultText.setText(result);

                newStage.close();
                
            } catch (NumberFormatException e) {
                showResultText.setText("Error: Invalid rate. Please enter a valid number.");
            }
        });
    }
}
