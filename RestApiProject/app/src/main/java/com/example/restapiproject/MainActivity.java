package com.example.restapiproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter adapter;
    private List<WeatherData> weatherList = new ArrayList<>();
    private APIHandler apiHandler;
    private List<String> cities = new ArrayList<>();
    private EditText editTextCity;
    private Button buttonAddCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        adapter = new CustomAdapter(this, weatherList);
        listView.setAdapter(adapter);

        editTextCity = findViewById(R.id.editTextCity);
        buttonAddCity = findViewById(R.id.buttonAddCity);

        apiHandler = new APIHandler(this);

        // Tambahkan beberapa kota awal
        cities.add("Jakarta");
        cities.add("Surabaya");
        cities.add("Bandung");


        fetchWeatherData( );

        // Tambahkan logika saat tombol tambah ditekan
        buttonAddCity.setOnClickListener(v -> {
            String newCity = editTextCity.getText().toString().trim();
            if (!newCity.isEmpty() && !cities.contains(newCity)) {
                cities.add(newCity);
                fetchWeatherData();
                editTextCity.setText(""); // Kosongkan input setelah menambah kota
                Toast.makeText(MainActivity.this, "Kota " + newCity + " ditambahkan", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Nama kota tidak valid atau sudah ada", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            WeatherData selectedData = weatherList.get(position);
            Intent intent = new Intent(MainActivity.this, WeatherDetailActivity.class);
            intent.putExtra("cityName", selectedData.getCityName());
            intent.putExtra("temperature", selectedData.getTemperature());
            intent.putExtra("condition", selectedData.getCondition());
            startActivity(intent);
        });
    }

    private void fetchWeatherData( ) {
        weatherList.clear();
        for (String city : cities) {
            apiHandler.getWeatherData(city, new APIHandler.WeatherResponseListener() {
                @Override
                public void onResponse(List<WeatherData> data) {
//                    weatherList.clear();
                    weatherList.addAll(data);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onError(String message) {
                    Toast.makeText(MainActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
