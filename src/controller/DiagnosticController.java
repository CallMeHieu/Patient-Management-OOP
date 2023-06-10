package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Clinic;
import model.Patient;
import view.container.Container;

public class DiagnosticController {
	private Container view;
	private Clinic model;

	public DiagnosticController(Container view, Clinic model) {
		super();
		this.view = view;
		this.model = model;
		initViewListeners();
	}

	private void initViewListeners() {
		loadDataOfTableDiagnostic();
		backToScreenPatient();
		nextToScreenPrescriptions();
	}

	private void nextToScreenPrescriptions() {
		view.getPatientPanel().getPnSubChuanHoa().getBtnContinue().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getPatientPanel().getPnSubChuanHoa().getTaSymptom().getText().equals("")
						|| view.getPatientPanel().getPnSubChuanHoa().getTaCnclude().getText().equals(""))
					return;
				view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "3");
				view.getPatientPanel().getLbCard3().setBackground(new Color(240, 240, 240));
				view.getPatientPanel().getLbCard3().setFont(new Font("Tahoma", Font.PLAIN, 16));
				view.getPatientPanel().getLbCard2().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard2().setFont(view.getPatientPanel().fontMenu);
				view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
			}
		});
	}

	private void backToScreenPatient() {
		view.getPatientPanel().getPnSubChuanHoa().getBtnBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "1");
				view.getPatientPanel().getLbCard1().setBackground(new Color(240, 240, 240));
				view.getPatientPanel().getLbCard1().setFont(new Font("Tahoma", Font.PLAIN, 16));
				view.getPatientPanel().getLbCard2().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard2().setFont(view.getPatientPanel().fontMenu);
				view.getPatientPanel().getLbCard3().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard3().setFont(view.getPatientPanel().fontMenu);
			}
		});
	}

	private void loadDataOfTableDiagnostic() {
		view.getPatientPanel().getPnSubBenhNhan().getBtnView().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getPatientPanel().getPnSubBenhNhan().getTfId().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
					return;
				}
				view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "2");
				view.getPatientPanel().getLbCard2().setBackground(new Color(240, 240, 240));
				view.getPatientPanel().getLbCard2().setFont(new Font("Tahoma", Font.PLAIN, 16));
				view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
				view.getPatientPanel().getLbCard3().setBackground(Color.WHITE);
				view.getPatientPanel().getLbCard3().setFont(view.getPatientPanel().fontMenu);
				String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
				Patient patient = model.findPatientById(id);
				view.getPatientPanel().getPnSubChuanHoa().loadPatient(patient);
			}
		});
	}
}
