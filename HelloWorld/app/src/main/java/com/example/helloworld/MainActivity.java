package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button; //Mendefinisikan button
    private TextView TextView; //mendefinisikan text
    private int clickCount = 0; //menghitung jumlah klik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        TextView = findViewById(R.id.TextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount == 1) {
                    TextView.setText("Hello, Good Morning");
                } else if (clickCount == 2) {
                    TextView.setText("Nama: Kenzie Nararya\nNRP: 3223600031\nKelas: 2 D4 Teknik Komputer ");
                }
            }
        });
    }
}