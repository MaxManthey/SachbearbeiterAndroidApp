package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminSachbearbeiterLoeschenAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sachbearbeiter_loeschen_as);

        //TODO zurück button erstellen
        Button sbLoeschenBtn = findViewById(R.id.adminDeleteApplyBtn);

        sbLoeschenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSachbearbeiterLoeschenK kontrolle = new AdminSachbearbeiterLoeschenK();

                if (getIntent().hasExtra("org.maxmanthey.aufgabe4.USERNAME")) {
                    String username = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAME");
                    kontrolle.deleteUser(username);
                }

                Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                startActivity(startIntent);
            }
        });
    }
}
