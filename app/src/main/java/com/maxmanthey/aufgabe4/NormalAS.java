package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormalAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_as);

        Button normalEditBtn = findViewById(R.id.normalSbEditBtn);
        Button normalFbBelBtn = findViewById(R.id.normalFbBelegenRadio);
        Button normalFbDelBtn = findViewById(R.id.normalFbLoeschenBtn);

        normalEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.NORMALEDIT", "NORMALEDIT");
                startActivity(startIntent);
            }
        });

        normalFbBelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.NORMALFBBEL", "NORMALFBBEL");
                startActivity(startIntent);
            }
        });

        normalFbDelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.NORMALFBDEL", "NORMALFBDEL");
                startActivity(startIntent);
            }
        });
    }
}
