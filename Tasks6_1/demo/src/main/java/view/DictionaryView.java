package view;

import model.Dictionary;


import controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class DictionaryView extends Application{
    // initialize components that need to be accessed from multiple methods
    private Label result = new Label("Enter your word and meaning into Dictionary please!");
    // User can input text here
    private TextField inputWordField = new TextField();
    private TextField inputMeaningField = new TextField();
    private DictionaryController controller;
    private Dictionary model;

    public void start(Stage stage) {

        Button inputButton = new Button("Add to Dictionary");
        Button searchWordButton = new Button("Search Meaning");
        FlowPane pane = new FlowPane();

        stage.setTitle("Dictionary");

        // add outside margins for components
        Insets insets = new Insets(10, 10, 10, 10);
        pane.setMargin(result, insets);
        pane.setMargin(inputButton, insets);
        pane.setMargin(searchWordButton, insets);
        pane.setMargin(inputWordField, insets);
        pane.setMargin(inputMeaningField, insets);
        pane.setAlignment(Pos.CENTER);

        // reserve space for result
        result.setMinWidth(300);
        result.setAlignment(Pos.CENTER);

        inputWordField.setPromptText("Enter a word");
        inputMeaningField.setPromptText("Enter  its meaning");

        pane.getChildren().add(inputWordField);
        pane.getChildren().add(inputMeaningField);
        pane.getChildren().add(inputButton);
        pane.getChildren().add(searchWordButton);
        pane.getChildren().add(result);


        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.show();

        inputButton.setOnAction((ActionEvent event) -> {
            String word = inputWordField.getText();
            String meaning = inputMeaningField.getText();

            if (!word.isEmpty() && !meaning.isEmpty()) {
                controller.addWordToDictionary(word, meaning);
                result.setText("Word added: " + word + " -> " + meaning);
                // Clearing the text fields
                inputWordField.clear();
                inputMeaningField.clear();
            } else {
                result.setText("Error: Both fields must be filled out.");
            }
        });

        searchWordButton.setOnAction((ActionEvent event) -> {
            String word = inputWordField.getText();

            if (!word.isEmpty()) {
                // Check if the word exists in the dictionary
                if (!controller.doesWordExist(word)) {
                    result.setText("Error: The word doesn't exist in the dictionary!");
                } else {
                    // Fetch the meaning if the word exists
                    String meaning = controller.searchWordMeaning(word);
                    result.setText(word + " means --> " + meaning);
                }
                // Clearing the text field
                inputWordField.clear();
            } else {
                result.setText("Error: You must fill the field to get the meaning!");
            }
        });
    }

    @Override
    public void init() {
        model = new Dictionary();
        controller = new DictionaryController(this, model);
    }

    public void setResult(String resultText) {
        this.result.setText(resultText);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
