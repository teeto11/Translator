package com.example.translator.translator;

import com.example.translator.translator.translatorServices.TranslatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class TranslatorController {

    private final TranslatorService translatorService;

    @GetMapping("/home")
    public String home(@RequestParam(required = false,name = "name") String name) {
        return  name != null ? "Hello World!"+name : "Hello World!" ;
    }

    @GetMapping(path = "/translate/{word}/{language}")
    Optional<String> getWordAndLanguage(@PathVariable("word") String word, @PathVariable("language") String language) {
        System.out.println("word: " + word + " language: " + language);
        return translatorService.getTranslation(word.toLowerCase(), language.toLowerCase());
    }

}
