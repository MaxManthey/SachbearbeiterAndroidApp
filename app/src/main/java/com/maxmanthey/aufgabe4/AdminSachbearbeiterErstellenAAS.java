package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AdminSachbearbeiterErstellenAAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sachbearbeiter_erstellen_aas);

        final TextView errorTextView = findViewById(R.id.erstellenErrorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        Button erstellenApplyBtn = findViewById(R.id.erstellenApplyBtn);

        erstellenApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText erstellenUserNameEditText = findViewById(R.id.erstellenUserNameEditText);
                EditText erstellenPasswordEditText = findViewById(R.id.erstellenPasswordEditText);

                RadioButton adminRadio = findViewById(R.id.erstellenAdminRadio);
                RadioButton sbRadio = findViewById(R.id.erstellenSbRadio);

                if (!adminRadio.isChecked() && !sbRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung Auswählen");
                } else {
                    String username = erstellenUserNameEditText.getText().toString();
                    String password = erstellenPasswordEditText.getText().toString();

                    String berechtigung;

                    if (adminRadio.isChecked()) {
                        berechtigung = "A";
                    } else {
                        berechtigung = "SB";
                    }

                    AdminSachbearbeiterErstellenK kontrolle = new AdminSachbearbeiterErstellenK(username, password, berechtigung);

                    boolean testInput = kontrolle.correctInput(username);

                    if (testInput) {
                        kontrolle.erzeugeEK();
                        Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                        startActivity(startIntent);
                    } else {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setTextColor(Color.RED);
                        errorTextView.setText("Username darf nur buchstaben und _ enthalten");
                    }
                }
            }
        });
    }
}
