package com.example.translator.translator;

public interface TranslatorInterface {
    boolean isApplicable(String language);

    String getTranslation(String word);
}
