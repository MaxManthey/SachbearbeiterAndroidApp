package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class AdminFortbildungBelegenAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_fortbildung_belegen_as);


        final String username = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAMEADMIN");

        TextView belegenUsername = findViewById(R.id.adminFbBelegenUsernameTextView);
        String zwischen = "Userwahl = " + username;
        belegenUsername.setText(zwischen);

        final TextView errorTextView = findViewById(R.id.adminFbBelegenErrorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        Button mathe1Btn = findViewById(R.id.adminFbMathe1Btn);
        Button mathe2Btn = findViewById(R.id.adminFbMathe2Btn);
        Button bwlBtn = findViewById(R.id.adminFbBwlBtn);
        Button kostenBtn = findViewById(R.id.adminFbKostenBtn);

        final TestFortbildungenK kontrolle = new TestFortbildungenK();

        mathe1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton belegenRadio = findViewById(R.id.adminFbBelegenRadio);
                RadioButton bestehenRadio = findViewById(R.id.adminFbBestehenRadio);

                if (!belegenRadio.isChecked() && !bestehenRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    boolean testUserWahl;
                    if (belegenRadio.isChecked()) {
                        testUserWahl = kontrolle.testMathe1Belegen(username);
                        if (testUserWahl) {
                            kontrolle.addFB(username, "Mathe1");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits belegt");
                        }
                    } else {
                        testUserWahl = kontrolle.testMathe1Bestehen(username);

                        if (testUserWahl) {
                            kontrolle.bestehenFB(username, "Mathe1");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits bestanden/kann nicht bestanden werden");
                        }
                    }
                }
            }
        });

        mathe2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton belegenRadio = findViewById(R.id.adminFbBelegenRadio);
                RadioButton bestehenRadio = findViewById(R.id.adminFbBestehenRadio);

                if (!belegenRadio.isChecked() && !bestehenRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    boolean testUserWahl;
                    if (belegenRadio.isChecked()) {
                        testUserWahl = kontrolle.testMathe2Belegen(username);
                        if (testUserWahl) {
                            kontrolle.addFB(username, "Mathe2");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits belegt");
                        }
                    } else {
                        testUserWahl = kontrolle.testMathe2Bestehen(username);

                        if (testUserWahl) {
                            kontrolle.bestehenFB(username, "Mathe2");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits bestanden/kann nicht bestanden werden");
                        }
                    }
                }
            }
        });

        bwlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton belegenRadio = findViewById(R.id.adminFbBelegenRadio);
                RadioButton bestehenRadio = findViewById(R.id.adminFbBestehenRadio);

                if (!belegenRadio.isChecked() && !bestehenRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    boolean testUserWahl;
                    //todo onNewIntent hier und finish bei sachbearbeiterWahlS
                    if (belegenRadio.isChecked()) {
                        testUserWahl = kontrolle.testBWLBelegen(username);
                        if (testUserWahl) {
                            kontrolle.addFB(username, "BWL");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits belegt");
                        }
                    } else {
                        testUserWahl = kontrolle.testBWLBestehen(username);

                        if (testUserWahl) {
                            kontrolle.bestehenFB(username, "BWL");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits bestanden/kann nicht bestanden werden");
                        }
                    }

                }
            }
        });

        kostenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton belegenRadio = findViewById(R.id.adminFbBelegenRadio);
                RadioButton bestehenRadio = findViewById(R.id.adminFbBestehenRadio);

                if (!belegenRadio.isChecked() && !bestehenRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    boolean testUserWahl;
                    if (belegenRadio.isChecked()) {
                        testUserWahl = kontrolle.testKostenBelegen(username);
                        if (testUserWahl) {
                            kontrolle.addFB(username, "Kosten");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits belegt");
                        }
                    } else {
                        testUserWahl = kontrolle.testKostenBestehen(username);

                        if (testUserWahl) {
                            kontrolle.bestehenFB(username, "Kosten");
                            Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                            onNewIntent(startIntent);
                            finish();
                        } else {
                            errorTextView.setVisibility(View.VISIBLE);
                            errorTextView.setTextColor(Color.RED);
                            errorTextView.setText("Wurde bereits bestanden/kann nicht bestanden werden");
                        }
                    }
                }
            }
        });
    }
}
