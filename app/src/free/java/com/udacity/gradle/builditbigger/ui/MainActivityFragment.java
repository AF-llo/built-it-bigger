package com.udacity.gradle.builditbigger.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;
import com.udacity.gradle.builditbigger.network.JokeTask;

import de.lokaizyk.jokepresenter.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeTask.JokeListener{

    public ObservableBoolean isLoading = new ObservableBoolean(false);

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setMainFragment(this);

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        binding.adView.loadAd(adRequest);
        return binding.getRoot();
    }

    public void tellJoke() {
        isLoading.set(true);
        new JokeTask().execute(this);
    }

    @Override
    public void jokeLoaded(String joke) {
        isLoading.set(false);
        JokeActivity.displayJoke(getContext(), joke);
    }
}
