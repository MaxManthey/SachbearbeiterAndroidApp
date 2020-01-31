package com.maxmanthey.aufgabe4;

public class LoginK {
    private String username;
    private String passwort;
    private String berechtigung;

    public LoginK(String name, String pw, String ber) {
        this.username = name;
        this.passwort = pw;
        this.berechtigung = ber;
    }

    public boolean validation() {
        String[] testForUsername = SachbearbeiterEK.gibAlleNamen();
        String resultUsername = "";

        //durchlaufen ob name existiert
        for (String s : testForUsername) {
            if (s.equals(username)) {
                resultUsername = username;
                break;
            }
        }

        //Wenn nicht existiert, login neu Starten
        if(resultUsername.equals("")) {
            return false;
        }

        //Test ob Passwort korrekt ist
        SachbearbeiterEK result = SachbearbeiterEK.gib(this.username);

        if(SachbearbeiterEK.getPasswort(result).equals(this.passwort)) {
            return true;
        } else {
            return false;
        }
    }

    public String next(String name, String ber) {
        SachbearbeiterEK change = SachbearbeiterEK.gib(name);

        if(SachbearbeiterEK.getBerechtigung(change).equals("A")) {
            if(ber.equals("A")) {
                return "AdminAS";

            } else if(ber.equals("SB")){
                return "NormalAS";
            } else {
                return "LoginAS";
            }
        } else if(SachbearbeiterEK.getBerechtigung(change).equals("SB")){
            return "NormalAS";
        } else {
            System.out.println("FALSCHE BERECHTIGUNG GEGEBEN");
            return "LoginAS";
        }
    }
}
