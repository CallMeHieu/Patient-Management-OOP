package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.utils.ModelUtils;
import com.oop2023nlu.group1.view.container.Container;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;


public class PrescriptionController {
    private Container view;
    private Clinic model;

    public PrescriptionController(Container view, Clinic model) {
        super();
        this.view = view;
        this.model = model;
        initViewListeners();
        model.registerObserver(view.getPatientPanel().getPnItemPrescriptions());
        view.getPatientPanel().getPnItemPrescriptions().setClinic(model);
        model.notifyObservers();
    }

    private void initViewListeners() {
        backScreen();
        selectedMedicine();
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

    private void selectedMedicine() {
        view.getPatientPanel().getPnItemPrescriptions().getBtnSelected().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getSelectedRow();
                if (row > -1) {
                    String id = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 0)
                            .toString();
                    String name = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 1)
                            .toString();
                    String defaultDosage = view.getPatientPanel().getPnItemPrescriptions().getTbPrescription().getValueAt(row, 2)
                            .toString();
                    String before = view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().getText();
                    String after = " -" + id + " " + name + " (" + defaultDosage +")"+ "\n";
                    StringBuilder result = new StringBuilder();
                    result.append(before);
                    result.append(after);
                    if (before.contains(id)) {
                        JOptionPane.showMessageDialog(null, "Đã thêm thuốc này");
                        return;
                    }
                    view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText("");
                    view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().setText(result.toString());
                }
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
                for (Medicine medicine : medicines) {
                    Vector<Object> vec = new Vector<>();
                    vec.add(medicine.getMedicineID());
                    vec.add(medicine.getName());
                    vec.add(medicine.getDefaultDosage());
                    vec.add(medicine.getUnit());
                    view.getPatientPanel().getPnItemPrescriptions().getDtmPrescription().addRow(vec);
                }
            }
        });
    }
}
