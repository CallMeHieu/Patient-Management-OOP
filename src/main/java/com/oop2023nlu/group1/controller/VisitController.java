package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.dao.PrescriptionMedicineDAO;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.utils.ModelUtils;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.dialog.DialogPrescription;
import com.oop2023nlu.group1.view.panel.PnPrescription;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VisitController {
    private Visit visitModel;
    private Container view;
    private final PnPrescription pnPrescription;

    public VisitController(Container view, Visit visitModel) {
        this.visitModel = visitModel;
        this.view = view;
        this.pnPrescription = view.getPrescriptionPanel();
        this.visitModel.registerObserver(view.getPrescriptionPanel());
        this.view.getPrescriptionPanel().setVisitModel(visitModel);
        this.visitModel.notifyObservers();
        initViewListeners();
    }

    private void initViewListeners() {
        search();
        show();
    }

    private void show() {
        pnPrescription.getTbPrescription().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = pnPrescription.getTbPrescription().getSelectedRow();
                String idVisit = pnPrescription.getTbPrescription().getValueAt(row, 0) + "";

                String dateString = pnPrescription.getTbPrescription().getValueAt(row, 1) + "";
                String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";

                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                Date date = new Date();
                try {
                    date = sdf.parse(dateString);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                ModelUtils.patient = PatientDAO.findPatientByVisitId(idVisit);
                ModelUtils.visit = new Visit(idVisit, date, pnPrescription.getTbPrescription().getValueAt(row, 2) + "", pnPrescription.getTbPrescription().getValueAt(row, 3) + "", null);
                Visit visit = null;
                List<PrescriptionMedicine> prescriptionMedicines = PrescriptionMedicineDAO.findAllByVisitId(idVisit);
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
        pnPrescription.getTfInput().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = pnPrescription.getTfInput().getText();
                String type = pnPrescription.getCbbFilter().getSelectedItem() + "";
                List<Visit> visits = visitModel.getVisits();
                if (type.equalsIgnoreCase("Mã bệnh nhân")) {
                    visits = visitModel.getVisitByIdPatient(input);
                }
                if (type.equalsIgnoreCase("Số điện thoại")) {
                    visits = visitModel.getVisitByNumberPhone(input);
                }
                pnPrescription.getDtmPrescription().setRowCount(0);
                Set<Visit> visitSet = new HashSet<>(visits);
                for (Visit visit : visitSet) {
                    Vector<Object> vec = new Vector<>();
                    vec.add(visit.getVisitID());
                    vec.add(visit.getDate().toString());
                    vec.add(visit.getSymptom());
                    vec.add(visit.getConclusion());
                    pnPrescription.getDtmPrescription().addRow(vec);
                }
            }
        });
    }
}
