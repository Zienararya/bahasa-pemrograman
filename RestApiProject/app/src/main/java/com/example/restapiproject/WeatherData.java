package com.example.restapiproject;

public class WeatherData {
    private String cityName;
    private String temperature;
    private String condition;
    private String icon;

    public WeatherData(String cityName, String temperature, String condition, String icon) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.condition = condition;
        this.icon = icon;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public String getIcon() {
        return icon;
    }
}