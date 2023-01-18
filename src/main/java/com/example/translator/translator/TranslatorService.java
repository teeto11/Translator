package com.example.translator.translator;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TranslatorService {

    public final List<TranslatorInterface> translators;

    public Optional<String> getTranslation(String word, String language) {
        return translators.stream().filter(translator -> translator.isApplicable(language))
                .findFirst().map(translator -> translator.getTranslation(word));

    }
}
