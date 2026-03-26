package org.example.controller;

import org.example.model.TermekModel;
import org.example.view.TermekView;

import java.io.IOException;

public class TermekController {

    private final TermekModel model;
    private final TermekView view;

    public TermekController(TermekModel model, TermekView view) {
        this.model = model;
        this.view = view;
    }

    public void futtat() throws IOException {
        model.beolvas("termekek.txt");

        view.kiirLegmagasabbAr(model.legmagasabbAr());
        view.kiirKulonbozoKodok(model.kulonbozoKodokABC());
        view.kiirAtlagArak(model.atlagArakABC());
        view.kiirNovelArak(model.arNovel());
    }
}

