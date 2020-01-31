package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FortbildungSWahl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortbildung_swahl);






        //ALTER CODE
        //fortbildungDetailList
        /*final ListView fortbildungList = findViewById(R.id.alleFortbildungenS);

        String[] alleFbNamen = FortbildungEK.gibAlleNamen();


        final SachbearbeiterWahlAdapter itemAdapter = new SachbearbeiterWahlAdapter(this, alleFbNamen);
        fortbildungList.setAdapter(itemAdapter);

        fortbildungList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle extrasOld = intent.getExtras();
                //String username_string = extras.getString("org.maxmanthey.aufgabe4.USERNAMEADMIN");
                //String password_string = extras.getString("org.maxmanthey.aufgabe4.TOBELEGEN");

                if (extrasOld.containsKey("org.maxmanthey.aufgabe4.USERNAMEADMIN")) {
                    if (extrasOld.containsKey("org.maxmanthey.aufgabe4.TOBELEGEN")) {
                        Intent startIntent = new Intent(getApplicationContext(), AdminFortbildungBelegenAS.class);
                        String usernameExtra = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAME");

                        Bundle extras = new Bundle();
                        extras.putString("org.maxmanthey.aufgabe4.FORTBILDUNG",fortbildungList.getItemAtPosition(position).toString());
                        extras.putString("org.maxmanthey.aufgabe4.USERNAMEFB",usernameExtra);
                        startIntent.putExtras(extras);

                        System.out.println("my username in fortbildung is = " + usernameExtra);
                        startActivity(startIntent);
                    } else {
                        //TODO Fortbildung löschen
                    }
                } else {
                    //TODO normal fortbildung löschen und belegen
                }
            }
        });*/

    }
}
