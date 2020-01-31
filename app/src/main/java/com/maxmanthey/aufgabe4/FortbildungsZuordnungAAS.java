package com.maxmanthey.aufgabe4;

public class FortbildungsZuordnungAAS {
    private String fname;
    private boolean bestanden;

    public FortbildungsZuordnungAAS(String name) {
        this.fname = name;
        this.bestanden = false;
    }

    public void setBestandenTrue() {
        this.bestanden = true;
    }

    public boolean getBestanden() {
        return this.bestanden;
    }

    public String getName() {
        return this.fname;
    }


    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public boolean isBestanden() {
        return bestanden;
    }
    public void setBestanden(boolean bestanden) {
        this.bestanden = bestanden;
    }
}
