package com.maxmanthey.aufgabe4;

public class AdminSachbearbeiterLoeschenK {
    public void deleteUser(String u) {
        String username = u;

        SachbearbeiterEK userToDelete = SachbearbeiterEK.gib(username);

        SachbearbeiterEK.sachbearbeiterCollection.remove(userToDelete);
    }
}
