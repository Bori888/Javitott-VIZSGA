package org.example;

import org.example.controller.TermekController;
import org.example.model.TermekModel;
import org.example.view.TermekView;

public class Main {
    public static void main(String[] args) throws Exception {
        TermekModel model = new TermekModel();
        TermekView view = new TermekView();
        TermekController controller = new TermekController(model, view);

        controller.futtat();
    }
}
