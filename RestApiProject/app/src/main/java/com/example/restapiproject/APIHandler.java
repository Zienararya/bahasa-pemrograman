package com.example.restapiproject;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class APIHandler {
    private static final String API_KEY = "80bdf26e12d44d6e82330026242909";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=";

    private Context context;
    private RequestQueue requestQueue;

    public APIHandler(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public interface WeatherResponseListener {
        void onResponse(List<WeatherData> weatherDataList);

        void onError(String message);
    }

    public void getWeatherData(String city, WeatherResponseListener listener) {
        String url = BASE_URL + city;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
            try {
                List<WeatherData> weatherDataList = new ArrayList<>();
                JSONObject location = response.getJSONObject("location");
                JSONObject current = response.getJSONObject("current");

                String cityName = location.getString("name");
                String temperature = current.getString("temp_c") + "°C";
                String condition = current.getJSONObject("condition").getString("text");
                String icon = current.getJSONObject("condition").getString("icon");

                weatherDataList.add(new WeatherData(cityName, temperature, condition, icon));
                listener.onResponse(weatherDataList);
            } catch (JSONException e){
                listener.onError(e.getMessage());
            }
            }, error -> listener.onError(error.toString())
        );

        requestQueue.add(request);
    }

}