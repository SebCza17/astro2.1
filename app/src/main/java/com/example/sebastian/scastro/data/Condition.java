package com.example.sebastian.scastro.data;

import org.json.JSONObject;

public class Condition implements JSONPopulator {
    private int code;
    private int temp;
    private String description;

    public int getCode() {
        return code;
    }

    public int getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void populate(JSONObject jsonObject) {

        code = jsonObject.optInt("code");
        temp = jsonObject.optInt("temp");
        description = jsonObject.optString("text");

    }
}
