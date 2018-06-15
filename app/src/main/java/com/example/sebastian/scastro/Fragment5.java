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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sebastian.scastro.data.Channel;
import com.example.sebastian.scastro.data.Forecast;
import com.example.sebastian.scastro.data.Item;
import com.example.sebastian.scastro.service.CallbackWeatherService;
import com.example.sebastian.scastro.service.YahooWaetherSevice;

public class Fragment5 extends Fragment implements CallbackWeatherService {

    private TextView[] textViewsDate = new TextView[3];

    private TextView[] textViewsDay  = new TextView[3];

    private TextView[] textViewsHigh = new TextView[3];

    private TextView[] textViewsLow = new TextView[3];

    private TextView[] textViewsText = new TextView[3];

    private ImageView[] imageViewsCode  = new ImageView[3];



    private YahooWaetherSevice yahooWaetherSevice;
    private  View view;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    String[] locations = {"Lodz", "Warszawa", "Moskwa",
            "Paryz", "Wieden", "Londyn", "Krakow"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment5_layout,container,false);

        fillView();

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

        Item item = channel.getItem();
        for(int i = 0; i < 3; i ++) {
            Forecast forecast = item.getForecast(i+1);

            editor.putInt("imageViewStatus5" + i, getResources().getIdentifier("drawable/a" + forecast.getCode(), null, getActivity().getPackageName()));
            editor.putString("textViewsDate5" + i, forecast.getDate());
            editor.putString("textViewsDay5" + i, forecast.getDay());
            editor.putString("textViewsHigh5" + i, forecast.getHigh()+" \u00B0"+channel.getUnits().getTemperature());
            editor.putString("textViewsLow5" + i, forecast.getLow()+" \u00B0"+channel.getUnits().getTemperature());
            editor.putString("textViewsText5" + i, forecast.getText());

            editor.commit();

        }

        refreshWeather();



    }

    @Override
    public void serviceFailure(Exception e) {
        refreshWeather();
    }


    public void refreshWeather() {
        for(int i = 0; i < 3; i ++) {

            textViewsDate[i].setText(sharedPreferences.getString("textViewsDate5"+ i, ""));
            textViewsDay[i].setText(sharedPreferences.getString("textViewsDay5"+ i, ""));
            textViewsHigh[i].setText(sharedPreferences.getString("textViewsHigh5"+ i, ""));
            textViewsLow[i].setText(sharedPreferences.getString("textViewsLow5"+ i, ""));
            textViewsText[i].setText(sharedPreferences.getString("textViewsText5"+ i, ""));

            int resourceID = sharedPreferences.getInt("imageViewStatus5" + i, 0);
            Drawable weatherIconDrawable = getResources().getDrawable(resourceID);

            imageViewsCode[i].setImageDrawable(weatherIconDrawable);
        }
    }

    private void fillView(){
        for (int i = 0; i < 3; i++) {
            textViewsDate[i] = view.findViewById(getResources().getIdentifier("textViewDate" + (i+1), "id", getContext().getPackageName()));
            textViewsDay[i] = view.findViewById(getResources().getIdentifier("textViewDay" + (i+1), "id", getContext().getPackageName()));
            textViewsHigh[i] = view.findViewById(getResources().getIdentifier("textViewHigh" + (i+1), "id", getContext().getPackageName()));
            textViewsLow[i] = view.findViewById(getResources().getIdentifier("textViewLow" + (i+1), "id", getContext().getPackageName()));
            textViewsText[i] = view.findViewById(getResources().getIdentifier("textViewText" + (i+1), "id", getContext().getPackageName()));
            imageViewsCode[i] = view.findViewById(getResources().getIdentifier("imageViewCode" + (i+1), "id", getContext().getPackageName()));
        }
    }
}
