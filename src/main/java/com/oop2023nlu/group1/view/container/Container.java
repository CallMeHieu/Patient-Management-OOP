package com.oop2023nlu.group1.view.container;


import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.utils.SystemColor;
import com.oop2023nlu.group1.view.PnPrescription;
import com.oop2023nlu.group1.view.panel.PnDanh;
import com.oop2023nlu.group1.view.panel.PnMedicine;
import com.oop2023nlu.group1.view.panel.PnPatient;
import com.oop2023nlu.group1.view.panel.sub.PnItemDiagnostic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Container extends JFrame {
	JPanel pnMenu, pnRight, pnTitle, pnContent, pnPatient, pnDinh, pnDanh, pnDuc, pnMedicine;
	JLabel lbLogo, lbPatient, lbDinh, lbDanh, lbDuc, lbMedicine;
	ArrayList<JLabel> listMenu;
	CardLayout cardMenuLeftGroup = new CardLayout();
	PnPatient patientPanel;
	PnPrescription prescriptionPanel;
	PnDanh danhPanel;
	PnItemDiagnostic ducPanel;
	PnMedicine medicinePanel;

	public Container() {
		Main.changLNF("Nimbus");
		this.setTitle("Phần mềm quản lý bệnh nhân");
		this.setSize(1400, 800);
		addControls();
		addEvent();
		showWindow();
	}

	public PnPatient getPatientPanel() {
		return patientPanel;
	}

	public PnPrescription getPrescriptionPanel() {
		return prescriptionPanel;
	}

	public PnMedicine getMedicinePanel() {
		return medicinePanel;
	}

	public void showWindow() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		int width = this.getWidth();
		int height = this.getHeight();

		// 1400-250
		// 800-46-???

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		this.add(pnMain);

		/*
		 * ======================= SIDE BAR MENU =======================
		 */

		pnMenu = new JPanel();
		pnMenu.setPreferredSize(new Dimension(250, height));
		pnMenu.setBackground(SystemColor.CONTAINER_BACKGROUND);
		pnMain.add(pnMenu, BorderLayout.WEST);

		lbLogo = new JLabel(new ImageIcon("image/ContainerView/logo.jpg"), JLabel.CENTER);
		lbLogo.setPreferredSize(new Dimension(250, 200));
		pnMenu.add(lbLogo);

		lbPatient = new JLabel("Bệnh nhân", JLabel.CENTER);
		lbDinh = new JLabel("Toa thuốc", JLabel.CENTER);
		lbDanh = new JLabel("Chức năng - Danh", JLabel.CENTER);
		lbDuc = new JLabel("Chức năng - Đức", JLabel.CENTER);
		lbMedicine = new JLabel("Quản lí thuốc", JLabel.CENTER);

		listMenu = new ArrayList<>();
		listMenu.add(lbPatient);
		listMenu.add(lbDinh);
		listMenu.add(lbDanh);
		listMenu.add(lbDuc);
		listMenu.add(lbMedicine);

		for (JLabel jLabel : listMenu) {
			jLabel.setForeground(SystemColor.CONTAINER_TEXT_ITEM_MENU);
			jLabel.setVisible(true);
			jLabel.setPreferredSize(new Dimension(250, 65));
			jLabel.setOpaque(true);
			jLabel.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU);
			jLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pnMenu.add(jLabel);
		}
		lbPatient.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU_SELECTED);
//		lbPatient.setBackground(Color.white);

		/*
		 * ======================= PANEL RIGHT =======================
		 */

		pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		pnRight.setPreferredSize(new Dimension(width - pnMenu.getWidth(), height));
		pnRight.setBackground(new Color(242, 153, 74));
		pnMain.add(pnRight);

		/*
		 * ======================= TITLE BAR =======================
		 */

		pnTitle = new JPanel();
		pnTitle.setPreferredSize(new Dimension(pnRight.getWidth(), 46));
		pnTitle.setLayout(new BoxLayout(pnTitle, BoxLayout.X_AXIS));
		pnTitle.setBackground(SystemColor.CONTAINER_BACKGROUND_TITLE);
		pnRight.add(pnTitle, BorderLayout.NORTH);

		/*
		 * ======================= CONTENT =======================
		 */

		pnContent = new JPanel(cardMenuLeftGroup);
		pnRight.add(pnContent);

		pnPatient = new JPanel();
		pnDinh = new JPanel();
		pnDanh = new JPanel();
		pnDuc = new JPanel();
		pnMedicine = new JPanel();

		pnContent.add(pnPatient, "1");
		pnContent.add(pnDinh, "2");
		pnContent.add(pnDanh, "3");
		pnContent.add(pnDuc, "4");
		pnContent.add(pnMedicine, "5");

		patientPanel = new PnPatient();
		pnPatient.setLayout(new BorderLayout());
		pnPatient.add(patientPanel, BorderLayout.CENTER);

		prescriptionPanel = new PnPrescription();
		pnDinh.setLayout(new BorderLayout());
		pnDinh.add(prescriptionPanel, BorderLayout.CENTER);

		danhPanel = new PnDanh();
		pnDanh.setLayout(new BorderLayout());
		pnDanh.add(danhPanel, BorderLayout.CENTER);

		ducPanel = new PnItemDiagnostic();
		pnDuc.setLayout(new BorderLayout());
		pnDuc.add(ducPanel, BorderLayout.CENTER);

		medicinePanel = new PnMedicine();
		pnMedicine.setLayout(new BorderLayout());
		pnMedicine.add(medicinePanel, BorderLayout.CENTER);

	}

	public void addEvent() {
		for (JLabel jLabel : listMenu) {
			jLabel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (JLabel jLabelDisable : listMenu) {
						jLabelDisable.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU);
					}
					jLabel.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU_SELECTED);

					String card = "";
					if (jLabel == lbPatient) {
						card = "1";
					} else if (jLabel == lbDinh) {
						card = "2";
					} else if (jLabel == lbDanh) {
						card = "3";
					} else if (jLabel == lbDuc) {
						card = "4";
					} else {
						card = "5";
					}
					cardMenuLeftGroup.show(pnContent, card);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}
			});
		}
	}
}
