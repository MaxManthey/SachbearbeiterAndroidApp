package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SachbearbeiterWahlS extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sachbearbeiter_wahl_s);

        final TextView userChoiceTextView = findViewById(R.id.userChoiceTextView);
        userChoiceTextView.setVisibility(View.INVISIBLE);

        final ListView sachbearbeiterList = findViewById(R.id.alleSachbearbeiterS);

        String[] alleSbNamen = SachbearbeiterEK.gibAlleNamen();

        final SachbearbeiterWahlAdapter itemAdapter = new SachbearbeiterWahlAdapter(this, alleSbNamen);
        sachbearbeiterList.setAdapter(itemAdapter);

        sachbearbeiterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (getIntent().hasExtra("org.maxmanthey.aufgabe4.ADMINEDIT")) {
                    Intent startIntent = new Intent(getApplicationContext(), AdminSachbearbeiterEditierenAS.class);
                    System.out.println("My user is = " +sachbearbeiterList.getItemAtPosition(position));
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAME", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.ADMINDELETE")) {
                    Intent startIntent = new Intent(getApplicationContext(), AdminSachbearbeiterLoeschenAS.class);
                    System.out.println("My user is = " +sachbearbeiterList.getItemAtPosition(position));
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAME", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.ADMINFBBELEGEN")) {
                    Intent startIntent = new Intent(getApplicationContext(), AdminFortbildungBelegenAS.class);
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAMEADMIN", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.ADMINFBLOESCHEN")) {
                    Intent startIntent = new Intent(getApplicationContext(), AdminFortbildungLoeschen.class);
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAMEADMIN", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.NORMALEDIT")) {
                    Intent startIntent = new Intent(getApplicationContext(), NormalSachbearbeiterEditierenAS.class);
                    System.out.println("My user is = " +sachbearbeiterList.getItemAtPosition(position));
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAME", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.NORMALFBBEL")) {
                    Intent startIntent = new Intent(getApplicationContext(), NormalFortbildungBelegenAS.class);
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAME", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else if (getIntent().hasExtra("org.maxmanthey.aufgabe4.NORMALFBDEL")) {
                    Intent startIntent = new Intent(getApplicationContext(), NormalFortbildungLoeschenAS.class);
                    startIntent.putExtra("org.maxmanthey.aufgabe4.USERNAME", sachbearbeiterList.getItemAtPosition(position).toString());
                    startActivity(startIntent);
                    finish();

                } else {
                    userChoiceTextView.setVisibility(View.VISIBLE);
                    userChoiceTextView.setTextColor(Color.RED);
                    userChoiceTextView.setText("Fehler. Bitte zurück");
                }

            }
        });
    }
}
