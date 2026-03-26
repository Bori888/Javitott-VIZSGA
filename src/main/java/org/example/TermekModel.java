package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TermekModel {

    private static class Termek {
        String kod;
        int ar;

        Termek(String kod, int ar) {
            this.kod = kod;
            this.ar = ar;
        }
    }

    private final List<Termek> lista = new ArrayList<>();

    // 1. Beolvasás
    public void beolvas(String fajlNev) throws IOException {
        for (String sor : Files.readAllLines(Path.of(fajlNev))) {
            String[] d = sor.split(" ");
            lista.add(new Termek(d[0], Integer.parseInt(d[1])));
        }
    }

    // 2. Min / Max ár
    public int legmagasabbAr() {
        return lista.stream().mapToInt(t -> t.ar).max().orElse(0);
    }

    public int legalacsonyabbAr() {
        return lista.stream().mapToInt(t -> t.ar).min().orElse(0);
    }

    // 3. Különböző termékkódok ABC szerint
    public Set<String> kulonbozoKodokABC() {
        Set<String> set = new TreeSet<>();
        for (Termek t : lista) set.add(t.kod);
        return set;
    }

    // 4. Átlagárak ABC szerint
    public Map<String, Double> atlagArakABC() {
        Map<String, List<Integer>> gyujto = new TreeMap<>();

        for (Termek t : lista) {
            gyujto.putIfAbsent(t.kod, new ArrayList<>());
            gyujto.get(t.kod).add(t.ar);
        }

        Map<String, Double> atlagok = new TreeMap<>();
        for (var e : gyujto.entrySet()) {
            double atlag = e.getValue().stream().mapToInt(i -> i).average().orElse(0);
            atlagok.put(e.getKey(), atlag);
        }

        return atlagok;
    }

    // 5. Ár növelése – paraméteres
    public Map<String, Double> arNovel(double szazalek) {
        Map<String, Double> ujArak = new LinkedHashMap<>();
        for (Termek t : lista) {
            double ujAr = t.ar * (1 + szazalek / 100);
            ujArak.put(t.kod, ujAr);
        }
        return ujArak;
    }

    // 5. Ár növelése – 10% alapértelmezett
    public Map<String, Double> arNovel() {
        return arNovel(10);
    }
}
