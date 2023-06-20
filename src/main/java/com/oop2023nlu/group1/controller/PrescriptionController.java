package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.panel.sub.PnItemPrescriptions;

import javax.persistence.Transient;
import javax.swing.*;
import javax.transaction.Transactional;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class PrescriptionController {
    private Container view;
    private Medicine medicineModel;
    private Visit visitModel;
    private PrescriptionMedicine prescriptionMedicineModel = new PrescriptionMedicine();
    private Patient patientModel = new Patient();

    public PrescriptionController(Container view, Medicine medicineModel, Visit visitModel) {
        super();
        this.view = view;
        this.medicineModel = medicineModel;
        this.visitModel = visitModel;
        initViewListeners();
        medicineModel.registerObserver(view.getPatientPanel().getPnItemPrescriptions());
        view.getPatientPanel().getPnItemPrescriptions().setMedicineModel(medicineModel);
        medicineModel.notifyObservers();
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
                view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "2");
                view.getPatientPanel().getLbCard2().setBackground(new Color(240, 240, 240));
                view.getPatientPanel().getLbCard2().setFont(new Font("Tahoma", Font.PLAIN, 16));
                view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
                view.getPatientPanel().getLbCard3().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard3().setFont(view.getPatientPanel().fontMenu);
            }
        });
    }

    private void saveVisit() {
        PnItemPrescriptions panel = view.getPatientPanel().getPnItemPrescriptions();
        panel.btnSave.addActionListener(new ActionListener() {
            @Override
            @Transactional
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
                visit = visitModel.addVisit(visit);
                Patient patient = patientModel.findPatientById(patientId);
                patient.getVisits().add(visit);
                patientModel.updatePatient(patient);
            }
        });
    }

//    private void getSelectedMedicines() {
//        view.getPatientPanel().getPnItemPrescriptions().getBtnGetMedicines().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int row = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getSelectedRow();
//                if (row > -1) {
//                    String id = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 0)
//                            .toString();
//                    String name = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 1)
//                            .toString();
//                    String defaultDosage = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 3)
//                            .toString();
//                    String before = view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().getText();
//                    String after = " - " + id + ", " + name + "(" + defaultDosage +")"+ "\n";
//                    StringBuilder result = new StringBuilder();
//                    result.append(before);
//                    result.append(MedicineDAO.findMedicineById(id).toString());
//                    if (before.contains(id)) {
//                        JOptionPane.showMessageDialog(null, "Đã thêm thuốc này");
//                        return;
//                    }
//                    view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText("");
//                    view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText(result.toString());
//                }
//            }
//        });
//    }

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
