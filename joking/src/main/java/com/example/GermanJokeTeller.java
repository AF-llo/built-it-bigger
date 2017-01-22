package com.example;

import java.util.Random;

/**
 * Created by lars on 22.01.17.
 */

public class GermanJokeTeller implements JokeTeller {

    private static String[] jokes = {
            "Wie viele Programmierer sind nötig, um eine kaputte Glühbirne auszuwechseln? – Keiner. Das ist ein Hardwareproblem.",
            "Telefonieren zwei Informatiker. Fragt der eine: „Und, wie ist das Wetter bei euch?“ „Caps Lock.“ „Häh?“ „Na, shift ohne Ende…“",
            "Was ist das? Schwimmt im Wasser und schreit F1?\n" +
                    "\n" +
                    "Ein Informatiker, der nicht schwimmen kann.",
            "UNIX ist das Betriebssystem der Zukunft. Und das schon seit 30 Jahren.",
            "UNIX wurde entwickelt, um zu verhindern, dass sich jeder Dahergelaufene einbildet, er kenne sich mit einem Computer aus."
    };

    @Override
    public String tellJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
