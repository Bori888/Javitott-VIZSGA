package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        TermekModel t = new TermekModel();
        t.beolvas("termekek.txt");

        System.out.println("a legmagasabb ár: " + t.legmagasabbAr());
        System.out.println("a különböző termékkódok ABC szerint: " + String.join(", ", t.kulonbozoKodokABC()));

        System.out.print("az átlagárak ABC szerint: ");
        t.atlagArakABC().forEach((k, v) -> System.out.print(k + ":" + String.format("%.2f", v) + "; "));
        System.out.println();

        System.out.println("a 10%-kal növelt árak:");
        t.arNovel().forEach((k, v) -> System.out.println(k + " → " + v));
    }
}
