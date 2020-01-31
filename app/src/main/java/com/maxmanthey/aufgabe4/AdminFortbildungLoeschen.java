package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminFortbildungLoeschen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_fortbildung_loeschen);

        final String username = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAMEADMIN");

        TextView loeschenUsername = findViewById(R.id.adminFbDelUsernameTextView);
        String zwischen = "Userwahl = " + username;
        loeschenUsername.setText(zwischen);

        final TextView errorTextView = findViewById(R.id.adminFbDelErrorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        Button mathe1Btn = findViewById(R.id.adminMathe1DelBtn);
        Button mathe2Btn = findViewById(R.id.adminMathe2DelBtn);
        Button bwlBtn = findViewById(R.id.adminBwlDelBtn);
        Button kostenBtn = findViewById(R.id.adminKostenDelBtn);

        final AdminFortbildungLoeschenK kontrolle = new AdminFortbildungLoeschenK();

        mathe1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean testUserWahl = kontrolle.fLoeschen(username, "Mathe1");

                if (testUserWahl) {
                    kontrolle.loeschen(username, "Mathe1");
                    Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                    startActivity(startIntent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Darf nicht gelöscht werden");
                }
            }
        });

        mathe2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean testUserWahl = kontrolle.fLoeschen(username, "Mathe2");

                if (testUserWahl) {
                    kontrolle.loeschen(username, "Mathe2");
                    Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                    startActivity(startIntent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Darf nicht gelöscht werden");
                }
            }
        });

        bwlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean testUserWahl = kontrolle.fLoeschen(username, "BWL");

                if (testUserWahl) {
                    kontrolle.loeschen(username, "BWL");
                    Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                    startActivity(startIntent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Darf nicht gelöscht werden");
                }
            }
        });

        kostenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean testUserWahl = kontrolle.fLoeschen(username, "Kosten");

                if (testUserWahl) {
                    kontrolle.loeschen(username, "Kosten");
                    Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                    startActivity(startIntent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Darf nicht gelöscht werden");
                }
            }
        });




    }
}
