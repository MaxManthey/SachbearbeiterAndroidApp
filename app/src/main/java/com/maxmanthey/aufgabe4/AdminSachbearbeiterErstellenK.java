package com.maxmanthey.aufgabe4;

public class AdminSachbearbeiterErstellenK {
    private String username;
    private String password;
    private String berechtigung;

    public AdminSachbearbeiterErstellenK(String u, String p, String b) {
        this.username = u;
        this.password = p;
        this.berechtigung = b;
    }

    public void erzeugeEK() {
            SachbearbeiterEK.sachbearbeiterCollection.add(new SachbearbeiterEK(username, password, berechtigung));
    }

    public boolean correctInput(String name) {
        for(int i = 0; i < name.length(); ++i) {
            char lauf = name.charAt(i);

            if(!Character.isLetter(lauf) && lauf != '_') {
                return false;
            }
        }

        return true;
    }
}
