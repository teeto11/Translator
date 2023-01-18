package com.example.translator.translator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class TranslatorController {

    private final TranslatorService translatorService;

    @GetMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @GetMapping(path = "/translate/{word}/{language}")
    Optional<String> getWordAndLanguage(@PathVariable("word") String word, @PathVariable("language") String language) {
        System.out.println("word: " + word + " language: " + language);
        return translatorService.getTranslation(word, language);
    }

}
