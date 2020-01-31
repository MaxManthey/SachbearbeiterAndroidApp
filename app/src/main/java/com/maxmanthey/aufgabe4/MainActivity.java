package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SachbearbeiterEK.sachbearbeiterCollection.add(new SachbearbeiterEK("Max", "123", "A"));
        SachbearbeiterEK.sachbearbeiterCollection.add(new SachbearbeiterEK("Anakin", "456", "SB"));
        SachbearbeiterEK.sachbearbeiterCollection.add(new SachbearbeiterEK("ObiWan", "789", "A"));

        FortbildungEK.alleKurse.add(new FortbildungEK("Mathe1"));
        FortbildungEK.alleKurse.add(new FortbildungEK("Mathe2"));
        FortbildungEK.alleKurse.add(new FortbildungEK("Kosten"));
        FortbildungEK.alleKurse.add(new FortbildungEK("BWL"));

        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startInt = new Intent(getApplicationContext(), LoginAS.class);
                startActivity(startInt);
            }
        });
    }
}
