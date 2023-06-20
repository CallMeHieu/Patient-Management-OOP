package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.VisitDAO;
import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.dialog.DialogPrescription;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class VisitController {
    private Visit visitModel;
    private Container view;

    public VisitController(Container view, Visit visitModel) {
        this.visitModel = visitModel;
        this.view = view;
        initViewListeners();
        this.visitModel.registerObserver(view.getPrescriptionPanel());
        this.view.getPrescriptionPanel().setVisitModel(visitModel);
        this.visitModel.notifyObservers();
    }

    private void initViewListeners() {
        search();
        show();
    }

    private void show() {
        JTable table = view.getPrescriptionPanel().getTbPrescription();
        DefaultTableModel defaultTableModel = view.getPrescriptionPanel().getDtmPrescription();
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                String idVisit = table.getValueAt(row, 0) + "";
//                Visit visit= VisitDAO.findById();
                Visit visit = null;
                List<PrescriptionMedicine> prescriptionMedicines = new ArrayList<>();
                if (row > -1) {
                    new DialogPrescription(view, prescriptionMedicines);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void search() {
        view.getPrescriptionPanel().getTfInput().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = view.getPrescriptionPanel().getTfInput().getText();
                String type = view.getPrescriptionPanel().getCbbFilter().getSelectedItem() + "";
                if (type.equalsIgnoreCase("Mã bệnh nhân")) {
                    visitModel.getVisitByIdPatient(input);
                }
                if (type.equalsIgnoreCase("Số điện thoại")) {
                    visitModel.getVisitByNumberPhone(input);
                }
            }
        });
    }
}
