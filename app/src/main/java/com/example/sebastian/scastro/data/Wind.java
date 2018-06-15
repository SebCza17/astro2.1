package com.example.sebastian.scastro.data;

import org.json.JSONObject;

public class Wind implements JSONPopulator {
    private Double speed;
    private String direction;

    public Double getSpeed() {
        return speed;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public void populate(JSONObject jsonObject) {

        speed = jsonObject.optDouble("speed");
        direction = jsonObject.optString("direction");
    }
}
