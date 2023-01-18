package com.example.translator.translator;

import org.springframework.boot.CommandLineRunner;
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
