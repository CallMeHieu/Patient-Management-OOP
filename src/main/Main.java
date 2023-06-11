package main;

import controller.DiagnosticController;
import controller.ManamentMedicineController;
import controller.PatientController;
import controller.PrescriptionController;
import data.MedicineDAO;
import data.PatientDAO;
import model.Clinic;
import view.container.Container;

public class Main {
	public static void main(String[] args) {
		Container view = new Container();
		Clinic model = new Clinic("Phongkhamabc", "Thu duc", "18000018", PatientDAO.patients, MedicineDAO.medicines);
		PatientController patientController = new PatientController(view, model);
		DiagnosticController diagnosticController = new DiagnosticController(view, model);
		PrescriptionController prescriptionController = new PrescriptionController(view, model);
		ManamentMedicineController manamentPrescriptionController = new ManamentMedicineController(view, model);
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
