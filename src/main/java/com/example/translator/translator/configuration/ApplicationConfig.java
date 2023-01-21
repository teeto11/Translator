package com.example.translator.translator.configuration;

import com.example.translator.translator.TranslatorInterface;
import com.example.translator.translator.TranslatorRepository;
import com.example.translator.translator.translatorServices.TranslatorService;
import com.example.translator.translator.translatorServices.FrenchTranslatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    public TranslatorService translatorService(List<TranslatorInterface> translators) {
        return new TranslatorService(translators);
    }

    @Bean
    public TranslatorRepository translatorRepository() {
        return new TranslatorRepository();
    }

    @Bean
    public FrenchTranslatorService frenchTranslatorService(TranslatorRepository translatorRepository) {
        return new FrenchTranslatorService(translatorRepository);
    }
}
