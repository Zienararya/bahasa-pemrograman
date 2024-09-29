package com.example.aplikasip4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activityPertama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertama);
        Toolbar toolbarPertama = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarPertama);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        ListView pembukaList = findViewById(R.id.list_view_pembuka);

        Dish[] dishes = {
                new Dish("Weetabix and shoyu salad", "A crisp salad featuring weetabix and shoyu", 51),
                new Dish("Rocket and pancetta pasta", "Fresh egg pasta in a sauce made from fresh rocket and smoked pancetta", 62),
                new Dish("Nutmeg and cinnamon loaf", "Crunchy bread made with nutmeg and cinnamon", 40),
                new Dish("Tofu and pepper ciabatta", "Warm ciabatta filled with marinaded tofu and green pepper", 38),
                new Dish("Sweetcorn and cod dumplings", "Thin pastry cases stuffed with baby sweetcorn and fresh cod", 41)
        };

        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dishes);

        pembukaList.setAdapter(dishAdapter);

        pembukaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dish ds = dishAdapter.getItem(i);
                Toast toast = Toast.makeText(getApplicationContext(),ds.getDesc(),Toast.LENGTH_SHORT);;
                toast.show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Kembali ke aktivitas sebelumnya
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
