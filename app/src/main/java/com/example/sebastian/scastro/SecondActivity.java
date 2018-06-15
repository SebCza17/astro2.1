package com.example.sebastian.scastro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Sebastian on 16.05.2018.
 */

public class SecondActivity extends AppCompatActivity {

    private EditText editTextLa;
    private EditText editTextLo;
    private EditText editTextRe;

    String[] location = {"Lodz", "Warszawa", "Moskwa",
            "Paryz", "Wieden", "Londyn", "Krakow"};

    Spinner spinner;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);


        editTextLa = (EditText) findViewById(R.id.editTextLatitude);
        editTextLo = (EditText) findViewById(R.id.editTextLongitude);
        editTextRe = (EditText) findViewById(R.id.editTextRefreshTime);

        editTextLa.setText("" + String.valueOf(MainActivity.latitude));
        editTextLo.setText("" + String.valueOf(MainActivity.longitude));
        editTextRe.setText("" + MainActivity.refreshTime / 1000);
        spinner = (Spinner) findViewById(R.id.spinner);


        sharedPreferences = getSharedPreferences("com.example.sebastian.scastro", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, location);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        int prefsInt = sharedPreferences.getInt("SaveSelected", -1);
        if (prefsInt != -1) {
            spinner.setSelection(prefsInt);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                editor.putInt("SaveSelected", position);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void onClickSave(View view) {

        MainActivity.latitude = Double.parseDouble(editTextLa.getText().toString());
        MainActivity.longitude = Double.parseDouble(editTextLo.getText().toString());
        if(Integer.valueOf(editTextRe.getText().toString()) > 0) {
            MainActivity.refreshTime = Integer.parseInt(editTextRe.getText().toString()) * 1000;
        }
        else
            MainActivity.refreshTime = 1000;

        MainActivity.dateTime.refreshAllTime();
        MainActivity.sun.refresh();
        MainActivity.moon.refresh();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
