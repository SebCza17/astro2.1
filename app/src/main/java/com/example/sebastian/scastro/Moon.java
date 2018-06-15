package com.example.sebastian.scastro;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Sebastian on 17.05.2018.
 */

public class Moon extends BaseObservable{

    private String moonRiseAndSet;
    private String moonNewAndFull;
    private String moonPhase;
    private String moonDay;

    public Moon() {
        this.moonRiseAndSet =
                " Rise: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getMoonrise().toString().split(" ")[1] +
                " Set: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getMoonset().toString().split(" ")[1];
        this.moonNewAndFull =
                " New: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getNextNewMoon().toString().split("G")[0] +
                " Full: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getNextFullMoon().toString().split("G")[0];
        this.moonPhase = " Phase: " + String.valueOf(MainActivity.dateTime.astroCalculator.getMoonInfo().getIllumination() * 100).substring(0,5) + "%";
        this.moonDay = " Day: " + String.valueOf(MainActivity.dateTime.astroCalculator.getMoonInfo().getAge()).substring(0,5);
    }

    @Bindable
    public String getMoonRiseAndSet() {
        return moonRiseAndSet;
    }

    public void setMoonRiseAndSet(String moonRiseAndSet) {
        this.moonRiseAndSet = moonRiseAndSet;
        notifyPropertyChanged(BR.moonRiseAndSet);
    }

    @Bindable
    public String getMoonNewAndFull() {
        return moonNewAndFull;
    }

    public void setMoonNewAndFull(String moonNewAndFull) {
        this.moonNewAndFull = moonNewAndFull;
        notifyPropertyChanged(BR.moonNewAndFull);
    }

    @Bindable
    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
        notifyPropertyChanged(BR.moonPhase);
    }

    @Bindable
    public String getMoonDay() {
        return moonDay;
    }

    public void setMoonDay(String moonDay) {
        this.moonDay = moonDay;
        notifyPropertyChanged(BR.moonDay);
    }

    public void refresh(){
        setMoonRiseAndSet(
                " Rise: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getMoonrise().toString().split(" ")[1] +
                        " Set: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getMoonset().toString().split(" ")[1]);

        setMoonNewAndFull(
                " New: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getNextNewMoon().toString().split("G")[0] +
                        " Full: " + MainActivity.dateTime.astroCalculator.getMoonInfo().getNextFullMoon().toString().split("G")[0]);

        setMoonPhase(" Phase: " + String.valueOf(MainActivity.dateTime.astroCalculator.getMoonInfo().getIllumination() * 100).substring(0,5) + "%");
        setMoonDay(" Day: " + String.valueOf(MainActivity.dateTime.astroCalculator.getMoonInfo().getAge()).substring(0,5));
    }

}
