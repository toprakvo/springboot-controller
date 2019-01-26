package com.toprakvo.restexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/english-greetings")
public class EnglishGreetingController {

    private List<EnglishGreeting> englishGreetings;

    public EnglishGreetingController() {
    	englishGreetings = new ArrayList<>();
    	englishGreetings.add(new EnglishGreeting("Hello!"));
    	englishGreetings.add(new EnglishGreeting("Hi?!"));
    	englishGreetings.add(new EnglishGreeting("What's up!"));
    }

    @GetMapping("/{id}")
    public EnglishGreeting getSpanishGreetingById(@PathVariable("id") final int id) {
        return englishGreetings.get(id - 1); // list index starts with 0 but we prefer to start on 1
    }

    @GetMapping("/random")
    public EnglishGreeting getRandom() {
        return englishGreetings.get(new Random().nextInt(englishGreetings.size()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createEnglishGreeting(@RequestBody EnglishGreeting englishGreeting) {
    	englishGreetings.add(englishGreeting);
    }
}
