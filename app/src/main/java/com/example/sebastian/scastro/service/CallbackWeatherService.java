package com.example.sebastian.scastro.service;

import com.example.sebastian.scastro.data.Channel;

public interface CallbackWeatherService {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception e);
}
