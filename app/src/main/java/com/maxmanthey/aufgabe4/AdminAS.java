package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_as);

        Button adminEditBtn = findViewById(R.id.adminEditBtn);
        Button erstellenBtn = findViewById(R.id.erstellenApplyBtn);
        Button loeschenBtn = findViewById(R.id.loeschenBtn);
        Button adminFbBelegenBtn = findViewById(R.id.adminFbBelegenBtn);
        Button adminFbLoeschenBtn = findViewById(R.id.adminFbLoeschenBtn);

        //erstellen Button
        erstellenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AdminSachbearbeiterErstellenAAS.class);
                startActivity(startIntent);
            }
        });

        adminEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.ADMINEDIT", "ADMINEDIT");
                startActivity(startIntent);
            }
        });

        loeschenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.ADMINDELETE", "ADMINDELETE");
                startActivity(startIntent);
            }
        });

        adminFbBelegenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.ADMINFBBELEGEN", "ADMINFBBELEGEN");
                startActivity(startIntent);
            }
        });

        adminFbLoeschenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SachbearbeiterWahlS.class);
                startIntent.putExtra("org.maxmanthey.aufgabe4.ADMINFBLOESCHEN", "ADMINFBLOESCHEN");
                startActivity(startIntent);
            }
        });
    }
}
