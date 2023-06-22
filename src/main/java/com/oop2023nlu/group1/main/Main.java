package com.oop2023nlu.group1.main;

import com.oop2023nlu.group1.controller.*;
import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;

import javax.swing.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        System.out.println(PatientDAO.findPatientByVisitId("10").toString());
//        System.out.println(new HashSet<>(VisitDAO.findAllVisitByPatient("005")).size());

        Container view = new Container();
        Clinic model = new Clinic("Phongkhamabc", "Thu duc", "18000018");
        Patient patientModel = new Patient();
        Medicine medicineModel = new Medicine();
        Visit visitModel = new Visit();
        PatientController patientController = new PatientController(view, patientModel);
        DiagnosticController diagnosticController = new DiagnosticController(view, patientModel);
        PrescriptionController prescriptionController = new PrescriptionController(view, medicineModel, visitModel);
        MedicineController medicineController = new MedicineController(view, medicineModel);
        VisitController visitController = new VisitController(view, visitModel);
    }

    public static void changLNF(String nameLNF) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (nameLNF.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }

}
