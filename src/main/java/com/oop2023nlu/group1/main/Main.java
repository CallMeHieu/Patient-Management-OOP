package com.oop2023nlu.group1.main;

import com.oop2023nlu.group1.controller.DiagnosticController;
import com.oop2023nlu.group1.controller.MedicineController;
import com.oop2023nlu.group1.controller.PatientController;
import com.oop2023nlu.group1.controller.PrescriptionController;
import com.oop2023nlu.group1. model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;

public class Main {
	public static void main(String[] args) {
		Container view = new Container();
		Clinic model = new Clinic("Phongkhamabc", "Thu duc", "18000018");
		Patient patientModel = new Patient();
		Medicine medicineModel = new Medicine();
		Visit visitModel = new Visit();

		PatientController patientController = new PatientController(view, patientModel);
		DiagnosticController diagnosticController = new DiagnosticController(view, patientModel);
		PrescriptionController prescriptionController = new PrescriptionController(view, medicineModel, visitModel);
		MedicineController medicineController = new MedicineController(view, medicineModel);
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
