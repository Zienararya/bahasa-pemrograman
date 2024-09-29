package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int state = 0;
    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtMsg = findViewById(R.id.txtHello);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBtnClick(view);
                    }
                });
    }


    public void onBtnClick(View view) {
        state++;
        if (state == 1){
            txtMsg.setText("Hello Good Morning");
        } else if (state == 2) {
            txtMsg.setText("Nama: Kenzie Nararya\nNRP: 3223600031\nKelas: 2 D4 Teknik Komputer");
        } else {
            state = 0;
            txtMsg.setText("Hello World!");
        }
    }
}
