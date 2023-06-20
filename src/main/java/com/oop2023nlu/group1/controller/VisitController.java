package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.view.container.Container;

public class VisitController {
    private Medicine medicineModel;
    private Container view;

    public VisitController(Medicine medicineModel, Container view) {
        this.medicineModel = medicineModel;
        this.view = view;
        initViewListeners();
        this.medicineModel.registerObserver(view.getPatientPanel().getPnItemPrescriptions());
        this.view.getPatientPanel().getPnItemPrescriptions().setMedicineModel(this.medicineModel);
        this.medicineModel.notifyObservers();
    }

    private void initViewListeners() {
    }
}
