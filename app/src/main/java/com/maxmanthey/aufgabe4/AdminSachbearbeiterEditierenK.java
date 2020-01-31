package com.maxmanthey.aufgabe4;

public class AdminSachbearbeiterEditierenK {
    public boolean editUser(String uNeu, String uAlt, String pw, String ber) {
        String username = uNeu;
        String password = pw;
        String berechtigung = ber;
        String usernameAlt = uAlt;

        SachbearbeiterEK userToEdit = SachbearbeiterEK.gib(usernameAlt);
        boolean inputKorrekt = new AdminSachbearbeiterErstellenK(username, password, berechtigung).correctInput(username);

        if(!inputKorrekt) {
            return false;
        } else {
            userToEdit.setUserName(username);
            userToEdit.setPasswort(password);
            userToEdit.setBerechtigung(berechtigung);
            return true;
        }
    }
}
