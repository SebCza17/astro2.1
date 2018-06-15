package com.example.sebastian.scastro.data;

import org.json.JSONObject;

public class Forecast implements  JSONPopulator{
    private String code;
    private String date;
    private String day;
    private String high;
    private String low;
    private String text;

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getText() {
        return text;
    }


    @Override
    public void populate(JSONObject jsonObject) {

        code = jsonObject.optString("code");
        date = jsonObject.optString("date");
        day = jsonObject.optString("day");
        high = jsonObject.optString("high");
        low = jsonObject.optString("low");
        text = jsonObject.optString("text");
    }
}
