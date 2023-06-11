package controller;

import model.Clinic;
import view.container.Container;

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
		showInfo();
	}

	private void showInfo() {
		this.view.getPatientPanel().getPnItemPrescriptions().getLbName()
				.setText(this.view.getPatientPanel().getPnSubChuanHoa().getTfName().getText());
		this.view.getPatientPanel().getPnItemPrescriptions().getLbYearOfBirth()
				.setText(this.view.getPatientPanel().getPnSubChuanHoa().getTfBirthDay().getText());
		this.view.getPatientPanel().getPnItemPrescriptions().getLbPhone()
				.setText(this.view.getPatientPanel().getPnSubChuanHoa().getTfPhone().getText());
		this.view.getPatientPanel().getPnItemPrescriptions().getLbAddress()
				.setText(this.view.getPatientPanel().getPnSubChuanHoa().getTfAddress().getText());
	}
}
