package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		backScreen();
		selectedMedicine();
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
					String before = view.getPatientPanel().getPnItemPrescriptions().getTaPrescriptions().getText();
					String after = " -" + id + " " + name + "\n";
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
