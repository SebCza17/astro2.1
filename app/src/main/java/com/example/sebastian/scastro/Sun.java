package com.example.sebastian.scastro;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sebastian on 17.05.2018.
 */

public class Sun extends BaseObservable {

    private String sunRiseAndAzimuth;
    private String sunSetAndAzimuth;
    private String sunTwilightEveningAndMorning;


    public Sun() {

        this.sunRiseAndAzimuth =
                " Rise: " + MainActivity.dateTime.astroCalculator.getSunInfo().getSunrise().toString().split(" ")[1] +
                " Azimuth: " + String.valueOf(MainActivity.dateTime.astroCalculator.getSunInfo().getAzimuthRise()).substring(0,5);
        this.sunSetAndAzimuth =
                " Set: " + MainActivity.dateTime.astroCalculator.getSunInfo().getSunset().toString().split(" ")[1] +
                " Azimuth: " + String.valueOf(MainActivity.dateTime.astroCalculator.getSunInfo().getAzimuthSet()).substring(0,5);
        this.sunTwilightEveningAndMorning =
                " Twilight Evening: " + MainActivity.dateTime.astroCalculator.getSunInfo().getTwilightEvening().toString().split(" ")[1] +
                " Evening: " + MainActivity.dateTime.astroCalculator.getSunInfo().getTwilightMorning().toString().split(" ")[1];


    }

    @Bindable
    public String getSunRiseAndAzimuth() {
        return sunRiseAndAzimuth;
    }

    public void setSunRiseAndAzimuth(String sunRise) {
        this.sunRiseAndAzimuth = sunRise;
        notifyPropertyChanged(BR.sunRiseAndAzimuth);
    }

    @Bindable
    public String getSunSetAndAzimuth() {
        return sunSetAndAzimuth;
    }

    public void setSunSetAndAzimuth(String sunSetAndAzimuth) {
        this.sunSetAndAzimuth = sunSetAndAzimuth;
        notifyPropertyChanged(BR.sunSetAndAzimuth);
    }

    @Bindable
    public String getSunTwilightEveningAndMorning() {
        return sunTwilightEveningAndMorning;
    }

    public void setSunTwilightEveningAndMorning(String sunTwilightEvening) {
        this.sunTwilightEveningAndMorning = sunTwilightEvening;
    }

    public void refresh(){
        setSunRiseAndAzimuth(
                " Rise: " + MainActivity.dateTime.astroCalculator.getSunInfo().getSunrise().toString().split(" ")[1] +
                        " Azimuth: " + String.valueOf(MainActivity.dateTime.astroCalculator.getSunInfo().getAzimuthRise()).substring(0,5));
        setSunSetAndAzimuth(
                " Set: " + MainActivity.dateTime.astroCalculator.getSunInfo().getSunset().toString().split(" ")[1] +
                        " Azimuth: " + String.valueOf(MainActivity.dateTime.astroCalculator.getSunInfo().getAzimuthSet()).substring(0,5));
        setSunTwilightEveningAndMorning(
                " Twilight Evening: " + MainActivity.dateTime.astroCalculator.getSunInfo().getTwilightEvening().toString().split(" ")[1] +
                        " Evening: " + MainActivity.dateTime.astroCalculator.getSunInfo().getTwilightMorning().toString().split(" ")[1]);
    }

}
