package com.example.restapiproject;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        TextView cityName = findViewById(R.id.tv_city_name);
        TextView temperature = findViewById(R.id.tv_temperature);
        TextView condition = findViewById(R.id.tv_condition);

        String city = getIntent().getStringExtra("cityName");
        String temp = getIntent().getStringExtra("temperature");
        String cond = getIntent().getStringExtra("condition");

        cityName.setText(city);
        temperature.setText(temp);
        condition.setText(cond);
    }
}