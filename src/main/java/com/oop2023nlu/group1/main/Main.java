package com.oop2023nlu.group1.main;

import com.oop2023nlu.group1.controller.DiagnosticController;
import com.oop2023nlu.group1.controller.MedicineManagementController;
import com.oop2023nlu.group1.controller.PatientController;
import com.oop2023nlu.group1.controller.PrescriptionController;
import com.oop2023nlu.group1. model.Clinic;
import com.oop2023nlu.group1.view.container.Container;

public class Main {
	public static void main(String[] args) {
		Container view = new Container();
		Clinic model = new Clinic("Phongkhamabc", "Thu duc", "18000018");
		PatientController controller = new PatientController(view, model);
		DiagnosticController diagnosticController = new DiagnosticController(view, model);
		PrescriptionController prescriptionController = new PrescriptionController(view, model);
		MedicineManagementController medicineController = new MedicineManagementController(view, model);
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
