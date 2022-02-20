package dev.belueu.springbootchucknorris.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class ChuckNorrisServiceImpl implements ChuckNorrisService {
    @Override
    public String getChuckNorrisRandomJoke() {
        return new ChuckNorrisQuotes().getRandomQuote();
    }
}
