package com.example.aplikasip4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {

    CardView cardPertama;
    CardView cardKedua;
    CardView cardKetiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);;

        cardPertama = findViewById(R.id.cardview_pertama);
        cardKedua = findViewById(R.id.cardview_kedua);
        cardKetiga = findViewById(R.id.cardview_ketiga);

        cardPertama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityPertamaIntent = new Intent(MainActivity.this, activityPertama.class);
                startActivity(activityPertamaIntent);
            }
        });
        cardKedua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityKeduaIntent = new Intent(MainActivity.this, activityKedua.class);
                startActivity(activityKeduaIntent);
            }
        });
        cardKetiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityKetigaIntent = new Intent(MainActivity.this, activityKetiga.class);
                startActivity(activityKetigaIntent);
            }
        });

        TextView locText = findViewById(R.id.text_location);
        locText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchMapAppIntent = new Intent(Intent.ACTION_VIEW);
                launchMapAppIntent.setData(Uri.parse("geo: -7.276608, 112.793847?q=Lapangan+Merah+PENS"));
                startActivity(launchMapAppIntent);
            }
        });

        TextView orderText = findViewById(R.id.text_ordernow);
        orderText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto:kenzienararya981@gmail.com"));
                startActivity(launchEmailAppIntent);
            }
        });

        TextView phoneText = findViewById(R.id.text_contact);
        phoneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchContactAppIntent = new Intent(Intent.ACTION_DIAL);
                launchContactAppIntent.setData(Uri.parse("tel:088217279677"));
                startActivity(launchContactAppIntent);
            }
        });

        TextView instagramText = findViewById(R.id.text_instagram);
        instagramText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchInstagramAppIntent = new Intent(Intent.ACTION_VIEW);
                launchInstagramAppIntent.setData(Uri.parse("https://instagram.com/_whoiszienararya"));
                startActivity(launchInstagramAppIntent);
            }
        });
    }
}
