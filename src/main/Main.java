package main;

import controller.PatientController;
import data.PatientDAO;
import model.Clinic;
import view.container.Container;

public class Main {
	public static void main(String[] args) {
		Container view = new Container();
		Clinic model = new Clinic("Phongkhamabc", "Thu duc", "18000018", PatientDAO.patients, null);
		PatientController controller = new PatientController(view, model);
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
