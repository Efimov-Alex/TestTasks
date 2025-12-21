package ru.mos.qa.testtasks.playground.config;

public class TestConfig {
    public static final String BASE_URL = "http://uitestingplayground.com";
    public static final String AJAX_PAGE_URL = BASE_URL + "/ajax";
    public static final String SAMPLE_APP_URL = BASE_URL + "/sampleapp";

    public static final int DEFAULT_TIMEOUT_SECONDS = 30;

    public static final String AJAX_BUTTON_TEXT = "Button Triggering AJAX Request";
    public static final String AJAX_SUCCESS_TEXT = "Data loaded with AJAX get request.";

    public static final String SAMPLE_APP_SUCCESS_PREFIX = "Welcome,";
    public static final String SAMPLE_APP_ERROR_TEXT = "Invalid username/password";

    private TestConfig() {
    }
}