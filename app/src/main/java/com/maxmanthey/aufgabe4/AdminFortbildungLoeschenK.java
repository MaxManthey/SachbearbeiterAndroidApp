package com.maxmanthey.aufgabe4;

public class AdminFortbildungLoeschenK {
    public void loeschen(String username, String fortbildung) {
        SachbearbeiterEK user = SachbearbeiterEK.gib(username);

        user.removeFortbildung(fortbildung);
    }

    public boolean fLoeschen(String username, String fortbildung) {
        SachbearbeiterEK user = SachbearbeiterEK.gib(username);

        String[] alleFortbildungenUser = user.gibAlleNamenF();

        boolean testFortbildungExistiert = false;
        for (String s : alleFortbildungenUser) {
            if (s.equals(fortbildung)) {
                testFortbildungExistiert = true;
            }
        }

        if (!testFortbildungExistiert) {
            return false;
        } else {
            boolean testLoeschenErlaubt = loeschenErlaubt(user, fortbildung);

            if (!testLoeschenErlaubt) {
                return false;
            } else {
                user.removeFortbildung(fortbildung);
                return true;
            }
        }
    }

    public boolean loeschenErlaubt(SachbearbeiterEK user, String fortbildung) {
        String[] lauf = user.gibAlleNamenF();
        boolean mathe1 = false;
        boolean mathe2 = false;
        boolean bwl = false;
        boolean kosten = false;

        for(String s : lauf) {
            if(s.equals("Mathe1")) {
                mathe1 = true;
            } else if(s.equals("Mathe2")) {
                mathe2 = true;
            } else if(s.equals("BWL")) {
                bwl = true;
            } else if(s.equals("Kosten")) {
                kosten = true;
            }
        }

        if (kosten && !fortbildung.equals("Kosten")) {
            return false;
        } else if(fortbildung.equals("Mathe1") && mathe2) {
            return false;
        } else {
            return true;
        }
    }
}
