package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.view.container.Container;

public class VisitController {
    private Clinic model;
    private Container view;

    public VisitController(Clinic model, Container view) {
        this.model = model;
        this.view = view;
        initViewListeners();
        model.registerObserver(view.getPatientPanel().getPnItemPrescriptions());
        view.getPatientPanel().getPnItemPrescriptions().setClinic(model);
        model.notifyObservers();
    }

    private void initViewListeners() {
    }
}
