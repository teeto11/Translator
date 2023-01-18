package com.example.translator.translator;

import java.util.Map;

public class TranslatorRepository {
    private Map<String, String> translations;

    public TranslatorRepository() {
        //this.translations = Map.of("hello", "salut", "bye", "au revoir");
    }

    String Translations(String word) {

        translations = Map.of("hello", "salut", "bye", "au revoir");
        if (translations.get(word) == null) {
            return "not found";
        } else {
            return translations.get(word);
        }
    }

    public String getTranslation(String word) {
        return this.Translations(word);
    }
}
