package com.example;

import java.util.Random;

/**
 * Created by lars on 22.01.17.
 */

public class GermanJokeTeller implements JokeTeller {

    // TODO: 22.01.17 add some german info jokes
    private static String[] jokes = {
            "Joke 1",
            "Joke 2",
            "Joke 3",
            "Joke 4",
            "Joke 5"
    };

    @Override
    public String tellJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
