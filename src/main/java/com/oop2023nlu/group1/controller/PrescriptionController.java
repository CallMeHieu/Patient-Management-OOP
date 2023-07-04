package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.utils.ModelUtils;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.dialog.DialogPrescription;
import com.oop2023nlu.group1.view.panel.sub.PnItemPrescriptions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class PrescriptionController {
    private final Container view;
    private final Visit visitModel;
    private final PrescriptionMedicine prescriptionMedicineModel = new PrescriptionMedicine();
    private final Patient patientModel = new Patient();

    public PrescriptionController(Container view, Medicine medicineModel, Visit visitModel) {
        super();
        this.view = view;
        this.visitModel = visitModel;
        medicineModel.registerObserver(view.getPatientPanel().getPnItemPrescriptions());
        view.getPatientPanel().getPnItemPrescriptions().setMedicineModel(medicineModel);
        medicineModel.notifyObservers();
        initViewListeners();
    }

    private void initViewListeners() {
        backScreen();
        getSelectedMedicines();
        saveVisit();
        searchMedicine();
    }

    private void backScreen() {
        view.getPatientPanel().getPnItemPrescriptions().btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.changeScreen("2");
            }
        });
    }

    private void saveVisit() {
        PnItemPrescriptions panel = view.getPatientPanel().getPnItemPrescriptions();
        panel.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientId = panel.getPatientId();
                String symptom = panel.getSymptom();
                String conclusion = panel.getConclusion();
                List<PrescriptionMedicine> prescription = panel.getItems();
                for (PrescriptionMedicine item : prescription) {
                    item.setId(prescriptionMedicineModel.count() + 1 + "");
                    item = prescriptionMedicineModel.addPrescriptionMedicine(item);
                }

                String visitID = visitModel.count() + 1 + "";
                Visit visit = new Visit(visitID, new Date(), symptom, conclusion, prescription);
                visitModel.saveVisit(visit);
                Patient patient = patientModel.findPatientById(patientId);
                System.out.println("before add :" + patient.getVisits().size());
                patient.getVisits().add(visit);
                System.out.println("before add :" + patient.getVisits().size());

                patientModel.updatePatient(patient);
                JOptionPane.showMessageDialog(null, "Thành công");
                ModelUtils.visit = visit;
                ModelUtils.patient = patient;
                new DialogPrescription(view, prescription);
                view.getPatientPanel().getPnItemInfoPatient().resetForm();
                view.getPatientPanel().getPnItemDiagnostic().resetForm();
                view.getPatientPanel().getPnItemPrescriptions().resetForm();
                panel.getItems().clear();
                view.changeScreen("1");
            }
        });
    }

    private void getSelectedMedicines() {
        List<PrescriptionMedicine> items = view.getPatientPanel().getPnItemPrescriptions().getItems();
        view.getPatientPanel().getPnItemPrescriptions().getBtnGetMedicines().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder result = new StringBuilder();
                for (PrescriptionMedicine item : items) {
                    result.append(item.toString());
                }
                view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText("");
                view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText(result.toString());
            }
        });
    }


    private void searchMedicine() {
        this.view.getPatientPanel().getPnItemPrescriptions().getTfSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charName = view.getPatientPanel().getPnItemPrescriptions().getTfSearch().getText();
                List<Medicine> medicines = MedicineDAO.findAllByCharName(charName);
                view.getPatientPanel().getPnItemPrescriptions().getDtmPrescription().setRowCount(0);
                List<PrescriptionMedicine> items = view.getPatientPanel().getPnItemPrescriptions().getItems();
                for (Medicine medicine : medicines) {
                    Vector<Object> vec = new Vector<>();
                    vec.add(medicine.getMedicineID());
                    vec.add(medicine.getName());
                    vec.add(medicine.getUnit());
                    vec.add(medicine.getDefaultDosage());
                    for (PrescriptionMedicine item : items) {
                        if (item.getMedicine().getMedicineID().equals(medicine.getMedicineID())) {
                            vec.add(item.getQuantity());
                            break;
                        }
                    }
                    if (vec.size() == 4) vec.add(0);
                    view.getPatientPanel().getPnItemPrescriptions().getDtmPrescription().addRow(vec);
                }
            }
        });
    }
}
