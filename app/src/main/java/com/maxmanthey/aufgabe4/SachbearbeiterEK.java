package com.maxmanthey.aufgabe4;

import java.util.HashSet;

public final class SachbearbeiterEK {
    static public HashSet<SachbearbeiterEK> sachbearbeiterCollection = new HashSet<SachbearbeiterEK>();
    public HashSet<FortbildungsZuordnungAAS> userFortbildung = new HashSet<FortbildungsZuordnungAAS>();
    private String userName;
    private String passwort;
    private String berechtigung;

    public SachbearbeiterEK() {
    }

    public SachbearbeiterEK(String name, String pw, String ber) {
        this.userName = name;
        this.passwort = pw;
        this.berechtigung = ber;
    }

    static public String[] gibAlleNamen() {
        String[] result = new String[sachbearbeiterCollection.size()];
        int i = 0;
        for(SachbearbeiterEK s : sachbearbeiterCollection) {
            result[i] = s.userName;
            ++i;
        }

        return result;
    }

    static public SachbearbeiterEK gib(String name) {
        SachbearbeiterEK notFound = new SachbearbeiterEK("0", "0", "0");

        for(SachbearbeiterEK s: sachbearbeiterCollection) {
            if(s.userName.equals(name)) {
                return s;
            }
        }
        return notFound;
    }

    public void kopiereAttribute(SachbearbeiterEK s) {
        SachbearbeiterEK.sachbearbeiterCollection.add(new SachbearbeiterEK(s.userName, s.passwort, s.berechtigung));
    }

    static public String getUsername(SachbearbeiterEK s) {
        return s.userName;
    }

    static public String getPasswort(SachbearbeiterEK s) {
        return s.passwort;
    }

    static public String getBerechtigung(SachbearbeiterEK s) {
        return s.berechtigung;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public String getBerechtigung() {
        return berechtigung;
    }
    public void setBerechtigung(String berechtigung) {
        this.berechtigung = berechtigung;
    }


    //Funktionen userFortbildung
    public void addFortbildung(String name) {
        userFortbildung.add(new FortbildungsZuordnungAAS(name));
    }

    public void setFortbildungBestandenTrue(String name) {
        for (FortbildungsZuordnungAAS f : userFortbildung) {
            if (f.getName().equals(name)) {
                f.setBestandenTrue();
            }
        }
    }

    public String[] gibAlleNamenF() {
        String[] result = new String[userFortbildung.size()];
        int i = 0;

        for (FortbildungsZuordnungAAS f : userFortbildung) {
            result[i] = f.getName();
            ++i;
        }

        return result;
    }

    public boolean checkBelegung(String fb) {
        boolean testFB = false;

        for(FortbildungsZuordnungAAS f : userFortbildung) {
            if ((f.getName().equals(fb)) && !f.getBestanden()) {
                testFB = true;
            }
        }

        return  testFB;
    }

    public boolean checkBestanden(String fb) {
        boolean testFB = false;

        for(FortbildungsZuordnungAAS f : userFortbildung) {
            if ((f.getName().equals(fb)) && f.getBestanden()) {
                testFB = true;
            }
        }

        return  testFB;
    }

    public String[] gibAlleBestandenF() {
        int anzahlBestanden = 0;
        for(FortbildungsZuordnungAAS f : userFortbildung) {
            if(f.getBestanden()) {
                ++anzahlBestanden;
            }
        }

        String[] result = new String[anzahlBestanden];
        int i = 0;
        for(FortbildungsZuordnungAAS f : userFortbildung) {
            if(f.getBestanden()) {
                result[i] = f.getName();
                ++i;
            }
        }

        return result;
    }

    public void removeFortbildung(String name) {
        for(FortbildungsZuordnungAAS f : userFortbildung) {
            if (f.getName().equals(name)) {
                userFortbildung.remove(f);
                break;
            }
        }
    }

    public void dump() {
        System.out.println();
        System.out.println("USERNAME = " + userName);
        System.out.println("PASSWORT = " + passwort);
        System.out.println("BERECHTIGT = " + berechtigung);

        System.out.println("FORTBILDUNGEN: ");
        for (FortbildungsZuordnungAAS f : userFortbildung) {
            System.out.println("Kurs = " + f.getName());
            System.out.println("bestanden = " + f.getBestanden());
        }
    }
}
