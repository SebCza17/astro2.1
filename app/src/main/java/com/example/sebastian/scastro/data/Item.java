package com.example.sebastian.scastro.data;

import org.json.JSONArray;
import org.json.JSONObject;

public class Item implements JSONPopulator {
    private JSONArray jsonArray;
    private Condition condition;
    private Forecast[] forecast;
    private Double lat;
    private Double longi;

    public Condition getCondition() {
        return condition;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLongi() {
        return longi;
    }

    public Forecast getForecast(int i) {
        return forecast[i];
    }

    @Override
    public void populate(JSONObject jsonObject) {
        condition = new Condition();
        condition.populate(jsonObject.optJSONObject("condition"));

        jsonArray = jsonObject.optJSONArray("forecast");
        forecast = new Forecast[5];
        for (int i = 0; i < 5; i++) {
            try {
                forecast[i] = new Forecast();
                forecast[i].populate(jsonArray.getJSONObject(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        lat = jsonObject.optDouble("lat");
        longi = jsonObject.optDouble("long");
    }
}
