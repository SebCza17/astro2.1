package com.example.sebastian.scastro.data;

import org.json.JSONObject;

public class Channel implements JSONPopulator {
    private Units units;
    private Wind wind;
    private Atmosphere atmosphere;
    private Item item;

    @Override
    public void populate(JSONObject jsonObject) {

        units = new Units();
        units.populate(jsonObject.optJSONObject("units"));

        wind = new Wind();
        wind.populate(jsonObject.optJSONObject("wind"));

        atmosphere = new Atmosphere();
        atmosphere.populate(jsonObject.optJSONObject("atmosphere"));

        item = new Item();
        item.populate(jsonObject.optJSONObject("item"));
    }

    public Units getUnits() {
        return units;
    }

    public Wind getWind() {
        return wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public Item getItem() {
        return item;
    }
}
