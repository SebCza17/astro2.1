package com.example.sebastian.scastro;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastian.scastro.data.Atmosphere;
import com.example.sebastian.scastro.data.Channel;
import com.example.sebastian.scastro.data.Item;
import com.example.sebastian.scastro.data.Wind;
import com.example.sebastian.scastro.service.CallbackWeatherService;
import com.example.sebastian.scastro.service.YahooWaetherSevice;

public class Fragment4 extends Fragment implements CallbackWeatherService {

    private TextView textViewWind;
    private TextView textViewWindDir;
    private TextView textViewHumi;
    private TextView textViewVisibility;

    private YahooWaetherSevice yahooWaetherSevice;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String[] locations = {"Lodz", "Warszawa", "Moskwa",
            "Paryz", "Wieden", "Londyn", "Krakow"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment4_layout,container,false);

        textViewWind = (TextView)view.findViewById(R.id.textViewWind);
        textViewWindDir = (TextView)view.findViewById(R.id.textViewWindDir);
        textViewHumi = (TextView)view.findViewById(R.id.textViewHumidity);
        textViewVisibility = (TextView)view.findViewById(R.id.textViewVisibility);


        sharedPreferences = getActivity().getSharedPreferences("com.example.sebastian.scastro", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String location = "lodz";
        int selected = sharedPreferences.getInt("SaveSelected", -1);
        if (selected != -1) {
            location = locations[selected];
        }

        yahooWaetherSevice = new YahooWaetherSevice(this);
        yahooWaetherSevice.refreshWeather(location);

        return view;
    }

    @Override
    public void serviceSuccess(Channel channel) {

        Wind wind = channel.getWind();
        Atmosphere atmosphere = channel.getAtmosphere();

        editor.putString("textViewWind40", wind.getSpeed().toString()+" "+channel.getUnits().getSpeed());
        editor.putString("textViewWindDir40", wind.getDirection()+" \u00B0");
        editor.putString("textViewHumi40", atmosphere.getHumidity() + " %");
        editor.putString("textViewVisibility40", atmosphere.getVisibility()+" "+channel.getUnits().getSpeed());

        editor.commit();


        refreshWeather();

    }

    @Override
    public void serviceFailure(Exception e) {

        refreshWeather();
    }

    public void refreshWeather() {

        textViewWind.setText(sharedPreferences.getString("textViewWind40", ""));
        textViewWindDir.setText(sharedPreferences.getString("textViewWindDir40", ""));
        textViewHumi.setText(sharedPreferences.getString("textViewHumi40", ""));
        textViewVisibility.setText(sharedPreferences.getString("textViewVisibility40", ""));
    }
}
