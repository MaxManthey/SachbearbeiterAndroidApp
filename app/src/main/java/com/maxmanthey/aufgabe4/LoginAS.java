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

public class LoginAS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);

        final TextView errorTextView = findViewById(R.id.errorTextView);
        errorTextView.setVisibility(View.INVISIBLE);

        Button loginButton = findViewById(R.id.okButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameTextEdit = findViewById(R.id.userNameInput);
                EditText passwordTextEdit = findViewById(R.id.passwordText);

                RadioButton adminRadio = findViewById(R.id.loginAdminRadio);
                RadioButton sbRadio = findViewById(R.id.loginSbRadio);

                if (!adminRadio.isChecked() && !sbRadio.isChecked()) {
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setTextColor(Color.RED);
                    errorTextView.setText("Bitte Berechtigung wählen");
                } else {
                    LoginK loginK = new LoginK(usernameTextEdit.getText().toString(), passwordTextEdit.getText().toString(), "Admin");

                    boolean userKorrekt = loginK.validation();


                    if (userKorrekt) {
                        System.out.println("USER KORREKT");
                        String berechtigungTest;
                        if (adminRadio.isChecked()) {
                            System.out.println("Admin is checked");
                            berechtigungTest = loginK.next(usernameTextEdit.getText().toString(), "A");
                            System.out.println("Berechtigung ist: " + berechtigungTest);

                            if (berechtigungTest.equals("AdminAS")) {
                                Intent startIntent = new Intent(getApplicationContext(), AdminAS.class);
                                startActivity(startIntent);
                            } else {
                                errorTextView.setVisibility(View.VISIBLE);
                                errorTextView.setTextColor(Color.RED);
                                errorTextView.setText("User hat keine Admin berechtigung");
                            }
                        } else {
                            Intent startIntent = new Intent(getApplicationContext(), NormalAS.class);
                            startActivity(startIntent);
                        }
                    } else {
                        errorTextView.setVisibility(View.VISIBLE);
                        errorTextView.setTextColor(Color.RED);
                        errorTextView.setText("Falscher Username/Passwort");
                    }
                }
            }
        });
    }
}
