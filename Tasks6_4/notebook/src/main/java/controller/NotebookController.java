package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import model.Note;
import model.Notebook;


public class NotebookController {
    @FXML
    private VBox savedNotesVBox;

    @FXML 
    private TextField title;

    @FXML 
    private TextField retrieveNote;

    @FXML 
    private TextArea note;

    @FXML
    private Label displayNotes;


    // Initializing the notebook
    private Notebook vietsNotebook = new Notebook();


    @FXML
    private void handleAddNoteButtonAction() {
        System.out.println("Button clicked!");
        String noteTitle = title.getText();
        String noteNote = note.getText();

        // Making sure that both fields are filled
        if (noteTitle.isEmpty() || noteNote.isEmpty()) {
            System.out.println("Both fields are required!");
            return;
        }

        Note newNote = new Note(noteTitle, noteNote);
        vietsNotebook.addNote(newNote);

        // Updating the notes to display below everything
        updateSavedNotesView();

        // Clear the text fields after adding the note
        title.clear();
        note.clear();
    }

    @FXML 
    public void handleRetrieveNoteButton() {
        String deleteTitle = retrieveNote.getText();
        System.out.println("Deleting the Note with Title: " + deleteTitle);

        if (vietsNotebook.deleteNote(deleteTitle)) {
            System.out.println("Note has been deleted successfully!");
        } else {
            System.out.println("Note not found/deleted unsuccessfully!");
        }
        
        // Updating the notes to display only the relevant notes
        updateSavedNotesView();
    }

    private void updateSavedNotesView() {

        if (vietsNotebook.getNotes().isEmpty()) {
            savedNotesVBox.getChildren().clear(); // Clear the VBox
            savedNotesVBox.getChildren().add(new Label("Notebook is empty!"));
        } else {
            savedNotesVBox.getChildren().clear(); // Clear the VBox
            savedNotesVBox.getChildren().add(new Label("Saved notes:")); // Add the header label
        
            // Add each note as a Label to the VBox
            for (Note note : vietsNotebook.getNotes()) {
                Label noteLabel = new Label("Title: " + note.getTitle() + "\n" + "Content: " + note.getNote());
                noteLabel.setStyle("-fx-padding: 10; -fx-border-color: lightgray; -fx-border-width: 1; -fx-background-color: #f9f9f9;");
                savedNotesVBox.getChildren().add(noteLabel);
            }
        }
    }
}
