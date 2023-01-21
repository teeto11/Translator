package com.example.translator.translator.translatorServices;

import com.example.translator.translator.TranslatorInterface;
import com.example.translator.translator.TranslatorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FrenchTranslatorService implements TranslatorInterface {
    private final TranslatorRepository translatorRepository;

    @Override
    public boolean isApplicable(String language) {
        return ("french".equals(language));
    }

    @Override
    public String getTranslation(String word) {
        return translatorRepository.getTranslation(word);

    }
}

