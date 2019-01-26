package com.toprakvo.restexample;

public class EnglishGreeting {

	private String message;

    // Required for JSON deserialization
	EnglishGreeting() {
    }

    public EnglishGreeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
