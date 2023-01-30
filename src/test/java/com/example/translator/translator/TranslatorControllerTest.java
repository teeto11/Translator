package com.example.translator.translator;

import com.example.translator.translator.translatorServices.TranslatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TranslatorControllerTest {

    private TranslatorController translatorController;

    private TranslatorService mockTranslatorService;
    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    private static final String WORD = "hello";
    private static final String LANGUAGE = "french";

    @BeforeEach
    void init() {
        mockTranslatorService = mock(TranslatorService.class);
        translatorController = new TranslatorController(mockTranslatorService);
        restTemplate = new RestTemplate();
    }

    @Test
    void HelloMethodShouldReturnString() {
       TranslatorController spyTranslatorController = spy(translatorController);
       when(spyTranslatorController.home("tomi")).thenReturn("hello world!");
       assertEquals("hello world!", spyTranslatorController.home("tomi"));
    }

    @Test
    void shouldReturnWordTranslation() {
        when(mockTranslatorService.getTranslation("hello", "french")).thenReturn(Optional.of("mock value"));
        Optional<String> expected = Optional.of("mock value");
        //String translation = this.restTemplate.getForObject("http://localhost:8080/api/v1/translate/" + WORD + "/" + LANGUAGE + "", String.class);
       assertEquals(expected,translatorController.getWordAndLanguage(WORD,LANGUAGE));
       assertThat(translatorController.getWordAndLanguage(WORD,LANGUAGE)).hasValue("mock value");

    }
}
