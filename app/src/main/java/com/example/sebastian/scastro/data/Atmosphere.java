package com.example.sebastian.scastro.data;

import org.json.JSONObject;

public class Atmosphere implements JSONPopulator {
    private Double pressure;
    private String humidity;
    private String visibility;

    public String getHumidity() {
        return humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public Double getPressure() {
        return pressure;
    }

    @Override
    public void populate(JSONObject jsonObject) {

        pressure = jsonObject.optDouble("pressure");
        humidity = jsonObject.optString("humidity");
        visibility = jsonObject.optString("visibility");
    }
}
