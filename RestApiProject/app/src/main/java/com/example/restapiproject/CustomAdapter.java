package com.example.restapiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<WeatherData> {
    private Context mcontext;
    private List<WeatherData> weatherList;

    public CustomAdapter(Context context, List<WeatherData> list) {
        super(context, 0, list);
        mcontext = context;
        weatherList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mcontext).inflate(R.layout.weather_item, parent, false);
        }

        WeatherData currentWeather = weatherList.get(position);

        TextView cityName = listItem.findViewById(R.id.tv_city_name);
        TextView temperature = listItem.findViewById(R.id.tv_temperature);
        TextView condition = listItem.findViewById(R.id.tv_condition);

        cityName.setText(currentWeather.getCityName());
        temperature.setText(currentWeather.getTemperature());
        condition.setText(currentWeather.getCondition());


        return listItem;
    }
}