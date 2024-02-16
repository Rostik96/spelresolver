package dev.rost.spelresolver.service;

import org.springframework.stereotype.Component;

@Component("stringAppender")
public class StringAppenderService {

    public String append(String appending) {
        return StringAppenderService.class.getSimpleName().concat(appending);
    }
}
