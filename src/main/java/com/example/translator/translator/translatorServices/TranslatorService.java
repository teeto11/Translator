package com.example.translator.translator.translatorServices;


import com.example.translator.translator.TranslatorInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class TranslatorService {

    public final List<TranslatorInterface> translators;

    public Optional<String> getTranslation(String word, String language) {
        return translators.stream().filter(translator -> translator.isApplicable(language))
                .findFirst().map(translator -> translator.getTranslation(word));

    }
}
