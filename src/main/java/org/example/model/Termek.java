package org.example.model;

public class Termek {
    private final String kod;
    private final int ar;

    public Termek(String kod, int ar) {
        this.kod = kod;
        this.ar = ar;
    }

    public String getKod() {
        return kod;
    }

    public int getAr() {
        return ar;
    }
}
