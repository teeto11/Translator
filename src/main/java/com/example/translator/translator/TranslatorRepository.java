package com.example.translator.translator;

import org.apache.catalina.mapper.Mapper;

import java.util.Map;

public class TranslatorRepository {
    private Map<String, String> translations;

    public TranslatorRepository() {
        this.translations = Map.of("hello", "wi", "bye", "wa");
    }

    public String getTranslation(String word) {
        if (translations.get(word) == null) {
            return "not found";
        } else {
            return translations.get(word);
        }
    }
}
