package org.example.view;

import java.util.Map;
import java.util.Set;

public class TermekView {

    public void kiirLegmagasabbAr(int ar) {
        System.out.println("A legmagasabb ár: " + ar);
    }

    public void kiirKulonbozoKodok(Set<String> kodok) {
        System.out.println("A különböző termékkódok ABC szerint: " + String.join(", ", kodok));
    }

    public void kiirAtlagArak(Map<String, Double> atlagok) {
        System.out.print("Az átlagárak ABC szerint: ");
        atlagok.forEach((k, v) -> System.out.print(k + ":" + String.format("%.2f", v) + "; "));
        System.out.println();
    }

    public void kiirNovelArak(Map<String, Double> arak) {
        System.out.println("A 10%-kal növelt árak:");
        arak.forEach((k, v) -> System.out.println(k + " → " + v));
    }
}
