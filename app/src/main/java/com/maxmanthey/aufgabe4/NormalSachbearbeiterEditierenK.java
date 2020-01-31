package com.maxmanthey.aufgabe4;

public class NormalSachbearbeiterEditierenK {
    public boolean editUser(String userNeu, String userAlt, String pw) {
        String username = userNeu;
        String password = pw;
        String usernameAlt = userAlt;

        SachbearbeiterEK userToEdit = SachbearbeiterEK.gib(usernameAlt);
        boolean inputKorrekt = new AdminSachbearbeiterErstellenK(userAlt, password, userToEdit.getBerechtigung()).correctInput(username);

        if(!inputKorrekt) {
            return false;
        } else {
            userToEdit.setUserName(username);
            userToEdit.setPasswort(password);
            return true;
        }
    }
}
