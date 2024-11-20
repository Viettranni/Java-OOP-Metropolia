package controller;

import view.DictionaryView;
import model.Dictionary;

public class DictionaryController {
    private DictionaryView gui;
    private Dictionary dictionary = new Dictionary();
    

    public DictionaryController(DictionaryView gui, Dictionary dictionary) {
        this.gui = gui;
        this.dictionary = new Dictionary();
    }

    public void addWordToDictionary(String word, String meaning) {
        dictionary.addWordAndMeaning(word, meaning); 
    }

    public String searchWordMeaning(String word) {
        return dictionary.getMeaning(word);
    }

    public boolean doesWordExist(String word) {
        return dictionary.getMeaning(word) != null;
    }
    

}