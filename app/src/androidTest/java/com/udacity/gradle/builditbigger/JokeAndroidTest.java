package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.network.JokeTask;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by lars on 22.01.17.
 */
@RunWith(AndroidJUnit4.class)
public class JokeAndroidTest {
    @Test
    public void testVerifyJokeTask() {
        new JokeTask().execute(new JokeTask.JokeListener() {
            @Override
            public void jokeLoaded(String joke) {
                Assert.assertNotNull(joke);
                Assert.assertNotSame("", joke);
            }
        });
    }
}
