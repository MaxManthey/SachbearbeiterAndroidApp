package com.maxmanthey.aufgabe4;

public class TestFortbildungenK {
    public void addFB(String u, String fb) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(u);
        username.addFortbildung(fb);

        username.dump();
    }

    public void bestehenFB(String u, String fb) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(u);
        username.setFortbildungBestandenTrue(fb);
        username.dump();
    }

    public boolean testMathe1Belegen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Mathe1")) {
            return false;
        } else if (username.checkBelegung("Mathe1")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean testMathe1Bestehen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Mathe1")) {
            return false;
        } else if (username.checkBelegung("Mathe1")){
            return true;
        } else {
            return false;
        }
    }

    public boolean testBWLBelegen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("BWL")) {
            return false;
        } else if (username.checkBelegung("BWL")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean testBWLBestehen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("BWL")) {
            return false;
        } else if (username.checkBelegung("BWL")){
            return true;
        } else {
            return false;
        }
    }

    public boolean testMathe2Belegen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Mathe2")) {
            return false;
        } else if (username.checkBelegung("Mathe2")) {
            return false;
        } else {
            if (username.checkBestanden("Mathe1")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean testMathe2Bestehen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Mathe2")) {
            return false;
        } else if (username.checkBelegung("Mathe2")){
            return true;
        } else {
            return false;
        }
    }

    public boolean testKostenBelegen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Mathe2")) {
            if (username.checkBestanden("BWL")) {
                return true;
            } else {
                return false;
            }
        } else if (username.checkBelegung("Kosten")) {
            return false;
        } else {
            return false;
        }
    }

    public boolean testKostenBestehen(String user) {
        SachbearbeiterEK username = SachbearbeiterEK.gib(user);

        if (username.checkBestanden("Kosten")) {
            return false;
        } else if (username.checkBelegung("Kosten")){
            return true;
        } else {
            return false;
        }
    }
}
