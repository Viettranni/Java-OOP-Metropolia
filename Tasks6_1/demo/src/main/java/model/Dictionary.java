package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public void addWordAndMeaning(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String getMeaning(String searchWord) {
        if (dictionary.containsKey(searchWord)) {
            return dictionary.get(searchWord);
        } else {
            return "Word not found in the dictionary!";
        }
    }
}