package model;

import java.util.ArrayList;
import java.util.List;


public class Notebook {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public boolean deleteNote(String title) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTitle().equals(title)) {
                notes.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
