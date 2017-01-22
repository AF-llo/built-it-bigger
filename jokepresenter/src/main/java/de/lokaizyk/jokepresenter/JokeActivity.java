package de.lokaizyk.jokepresenter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.lokaizyk.jokepresenter.databinding.ActivityJokeBinding;

public class JokeActivity extends AppCompatActivity {

    public ObservableField<String> joke = new ObservableField<>();

    private static final String EXTRA_JOKE = "keyExtraJoke";

    public static void displayJoke(Context context, String joke) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, JokeActivity.class);
        if (joke != null) {
            intent.putExtra(EXTRA_JOKE, joke);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);
        binding.setJokeActivity(this);

        Bundle data = savedInstanceState == null ? getIntent().getExtras() : savedInstanceState;
        if (data != null && data.containsKey(EXTRA_JOKE)) {
            joke.set(data.getString(EXTRA_JOKE));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(EXTRA_JOKE, joke.get());
        super.onSaveInstanceState(outState);
    }
}
