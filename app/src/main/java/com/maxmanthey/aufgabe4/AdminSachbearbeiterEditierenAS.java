package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AdminSachbearbeiterEditierenAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sachbearbeiter_editieren_as);

        final TextView errorTextView = findViewById(R.id.adminEditErrorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        //TODO zurück button erstellen
        Button applyBtn = findViewById(R.id.adminEditUserBtn);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userEdit = findViewById(R.id.adminEditUsernameEditText);
                EditText pwEdit = findViewById(R.id.adminEditPasswordEditText);

                RadioButton adminRadio = findViewById(R.id.adminEditAdminRadio);
                RadioButton sbRadio = findViewById(R.id.adminEditSbRadio);

                if (!adminRadio.isChecked() && !sbRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    String usernameAlt = "";
                    if (getIntent().hasExtra("org.maxmanthey.aufgabe4.USERNAME")) {
                        usernameAlt = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAME");
                        System.out.println("USERNAME UEBERGABE WAR ERFOLGREICH MIT = " + usernameAlt);
                    }

                    AdminSachbearbeiterEditierenK kontrolle = new AdminSachbearbeiterEditierenK();

                    String berechtigung = "SB";

                    if (adminRadio.isChecked()) {
                        berechtigung = "A";
                    }
                    boolean testInput = kontrolle.editUser(userEdit.getText().toString(), usernameAlt, pwEdit.getText().toString(), berechtigung);

                    if (testInput) {
                        Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                        onNewIntent(startIntent);
                        finish();
                    } else {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setTextColor(Color.RED);
                        errorTextView.setText("Falsche Angaben");
                    }

                }
            }
        });
    }
}
