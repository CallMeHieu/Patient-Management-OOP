package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.dao.PrescriptionMedicineDAO;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.utils.ModelUtils;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.dialog.DialogPrescription;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

                String dateString = table.getValueAt(row, 1) + "";
                String pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS";

                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                Date date = new Date();
                try {
                    date = sdf.parse(dateString);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                ModelUtils.patient = PatientDAO.findPatientByVisitId(idVisit);
                ModelUtils.visit = new Visit(idVisit, date, table.getValueAt(row, 2) + "", table.getValueAt(row, 3) + "", null);
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
        JTable table = view.getPrescriptionPanel().getTbPrescription();
        DefaultTableModel defaultTableModel = view.getPrescriptionPanel().getDtmPrescription();
        view.getPrescriptionPanel().getTfInput().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = view.getPrescriptionPanel().getTfInput().getText();
                String type = view.getPrescriptionPanel().getCbbFilter().getSelectedItem() + "";
                List<Visit> visits = new ArrayList<>();
                if (type.equalsIgnoreCase("Mã bệnh nhân")) {
                    visits = visitModel.getVisitByIdPatient(input);
                }
                if (type.equalsIgnoreCase("Số điện thoại")) {
                    visits = visitModel.getVisitByNumberPhone(input);
                }
                defaultTableModel.setRowCount(0);
                Set<Visit> visitSet = new HashSet<>(visits);
                for (Visit visit : visitSet) {
                    Vector<Object> vec = new Vector<>();
                    vec.add(visit.getVisitID());
                    vec.add(visit.getDate().toString());
                    vec.add(visit.getSymptom());
                    vec.add(visit.getConclusion());
                    defaultTableModel.addRow(vec);
                }
            }
        });
    }
}
