package com.maxmanthey.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NormalSachbearbeiterEditierenAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_sachbearbeiter_editieren_as);

        final TextView errorTextView = findViewById(R.id.normalEditErrorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        //TODO zurück button erstellen
        Button applyBtn = findViewById(R.id.normalEditApplyBtn);

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userEdit = findViewById(R.id.normalEditUsernameEditText);
                EditText pwEdit = findViewById(R.id.normalEditPasswordEditText);

                String usernameAlt = "";
                if (getIntent().hasExtra("org.maxmanthey.aufgabe4.USERNAME")) {
                    usernameAlt = getIntent().getExtras().getString("org.maxmanthey.aufgabe4.USERNAME");
                    System.out.println("USERNAME UEBERGABE WAR ERFOLGREICH MIT = " + usernameAlt);
                }

                NormalSachbearbeiterEditierenK kontrolle = new NormalSachbearbeiterEditierenK();

                boolean testInput = kontrolle.editUser(userEdit.getText().toString(), usernameAlt, pwEdit.getText().toString());

                if (testInput) {
                    Intent startIntent = new Intent(getApplicationContext(), NormalAS.class);
                    startActivity(startIntent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Falscher Username gegeben");
                }
            }
        });
    }
}
