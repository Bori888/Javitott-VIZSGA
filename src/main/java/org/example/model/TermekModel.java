package org.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TermekModel {

    private final List<Termek> lista = new ArrayList<>();

    public void beolvas(String fajlNev) throws IOException {
        for (String sor : Files.readAllLines(Path.of(fajlNev))) {
            String[] d = sor.split(" ");
            lista.add(new Termek(d[0], Integer.parseInt(d[1])));
        }
    }

    public int legmagasabbAr() {
        return lista.stream().mapToInt(Termek::getAr).max().orElse(0);
    }

    public int legalacsonyabbAr() {
        return lista.stream().mapToInt(Termek::getAr).min().orElse(0);
    }

    public Set<String> kulonbozoKodokABC() {
        Set<String> set = new TreeSet<>();
        for (Termek t : lista) set.add(t.getKod());
        return set;
    }

    public Map<String, Double> atlagArakABC() {
        Map<String, List<Integer>> gyujto = new TreeMap<>();

        for (Termek t : lista) {
            gyujto.putIfAbsent(t.getKod(), new ArrayList<>());
            gyujto.get(t.getKod()).add(t.getAr());
        }

        Map<String, Double> atlagok = new TreeMap<>();
        for (var e : gyujto.entrySet()) {
            double atlag = e.getValue().stream().mapToInt(i -> i).average().orElse(0);
            atlagok.put(e.getKey(), atlag);
        }

        return atlagok;
    }

    public Map<String, Double> arNovel(double szazalek) {
        Map<String, Double> ujArak = new LinkedHashMap<>();
        for (Termek t : lista) {
            double ujAr = t.getAr() * (1 + szazalek / 100);
            ujArak.put(t.getKod(), ujAr);
        }
        return ujArak;
    }

    public Map<String, Double> arNovel() {
        return arNovel(10);
    }
}
