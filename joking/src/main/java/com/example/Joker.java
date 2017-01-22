package com.example;

public class Joker {

    private static JokeTeller mJokeTeller;

    public static void setJokeTeller(JokeTeller mJokeTeller) {
        Joker.mJokeTeller = mJokeTeller;
    }

    public static String tellJoke() {
        if (mJokeTeller == null) {
            mJokeTeller = new GermanJokeTeller();
        }
        String joke = mJokeTeller.tellJoke();
        return joke == null ? "" : joke;
    }
}
