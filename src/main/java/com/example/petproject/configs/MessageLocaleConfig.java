package com.example.petproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageLocaleConfig extends AcceptHeaderLocaleResolver {
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        Locale defaultLocale = new Locale("ru");
        acceptHeaderLocaleResolver.setDefaultLocale(defaultLocale);

        return acceptHeaderLocaleResolver;
    }

    @Bean
    public ResourceBundleMessageSource message() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("/locale_ru.properties");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);

        return resourceBundleMessageSource;
    }
}