package at.ac.fhcampuswien.newsanalyzer.ctrl;

import at.ac.fhcampuswien.newsapi.NewsApi;

public class NewsApiException extends Exception {
    public NewsApiException(String error) {
        super(error);
    }

}
