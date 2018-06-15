package com.example.sebastian.scastro;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sebastian on 17.05.2018.
 */

public class DateTime extends BaseObservable {

    private String dateTime;

    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Calendar calendar;
    private String dateTest;
    private String[] dateTestTab;

    AstroCalculator astroCalculator;

    public DateTime() {
        calendar = Calendar.getInstance();
        dateTest = df.format(calendar.getTime());
        dateTestTab = dateTest.split("[-: ]");

        dateTime = dateTest;

        AstroCalculator.Location location = new AstroCalculator.Location( MainActivity.latitude, MainActivity.longitude);
        AstroDateTime astroDateTime = new AstroDateTime(
                Integer.parseInt(getDateTestTab()[0]), Integer.parseInt(getDateTestTab()[1]),Integer.parseInt(getDateTestTab()[2]),
                Integer.parseInt(getDateTestTab()[3]),Integer.parseInt(getDateTestTab()[4]),Integer.parseInt(getDateTestTab()[5]),
                2, false);

        astroCalculator = new AstroCalculator(astroDateTime, location);
    }

    @Bindable
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
        notifyPropertyChanged(BR.dateTime);
    }


    public String[] getDateTestTab() {
        return dateTestTab;
    }

    public void refreshTime(){
        calendar = Calendar.getInstance();
        dateTest = df.format(calendar.getTime());

        setDateTime(dateTest);
    }

    public void refreshAllTime(){
        dateTestTab = dateTest.split("[-: ]");

        AstroCalculator.Location location = new AstroCalculator.Location( MainActivity.latitude, MainActivity.longitude);
        AstroDateTime astroDateTime = new AstroDateTime(
                Integer.parseInt(getDateTestTab()[0]), Integer.parseInt(getDateTestTab()[1]),Integer.parseInt(getDateTestTab()[2]),
                Integer.parseInt(getDateTestTab()[3]),Integer.parseInt(getDateTestTab()[4]),Integer.parseInt(getDateTestTab()[5]),
                2, false);

        astroCalculator = new AstroCalculator(astroDateTime, location);
    }



}
