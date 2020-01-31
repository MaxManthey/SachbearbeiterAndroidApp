package com.maxmanthey.aufgabe4;

import java.util.HashSet;

public class FortbildungEK {
    private String fortbildungName;
    public static HashSet<FortbildungEK> alleKurse = new HashSet<FortbildungEK>();

    public FortbildungEK(String name) {
        this.fortbildungName = name;
    }

    public static String[] gibAlleNamen() {
        String[] result = new String[alleKurse.size()];
        int i = 0;

        for (FortbildungEK f : alleKurse) {
            result[i] = f.fortbildungName;
            ++i;
        }

        return result;
    }

    public FortbildungEK gib(String name) {
        FortbildungEK fail = new FortbildungEK("");

        for (FortbildungEK f : alleKurse) {
            if (f.fortbildungName.equals(name)) {
                return f;
            }
        }

        System.out.println("Name konnte nicht gefunden werden");
        return fail;
    }

    public String getFortbildungName() {
        return fortbildungName;
    }
    public void setFortbildungName(String fortbildungName) {
        this.fortbildungName = fortbildungName;
    }
}
