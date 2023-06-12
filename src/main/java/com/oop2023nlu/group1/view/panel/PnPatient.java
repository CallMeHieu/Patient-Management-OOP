package com.oop2023nlu.group1.view.panel;

import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.view.panel.sub.PnItemDiagnostic;
import com.oop2023nlu.group1.view.panel.sub.PnItemInfoPatient;
import com.oop2023nlu.group1.view.panel.sub.PnItemPrescriptions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PnPatient extends JPanel {
	JPanel pnTopMenu, pnContainer, pnCard;
	JLabel lbCard1, lbCard2, lbCard3;
	public Font font, fontMenu;
	PnItemInfoPatient pnSubBenhNhan = new PnItemInfoPatient();
	PnItemDiagnostic pnSubChuanHoa = new PnItemDiagnostic();
	PnItemPrescriptions pnItemPrescriptions = new PnItemPrescriptions();

	private CardLayout cardPanelGroup = new CardLayout();
	private List<JLabel> cards = new ArrayList<>();

	public PnItemPrescriptions getPnItemPrescriptions() {
		return pnItemPrescriptions;
	}

	public PnItemInfoPatient getPnSubBenhNhan() {
		return pnSubBenhNhan;
	}

	public PnItemDiagnostic getPnSubChuanHoa() {
		return pnSubChuanHoa;
	}

	public PnPatient() {
		Main.changLNF("Windows");
		addControls();
	}

	public JLabel getLbCard3() {
		return lbCard3;
	}

	public JLabel getLbCard1() {
		return lbCard1;
	}

	public JLabel getLbCard2() {
		return lbCard2;
	}

	public JPanel getPnCard() {
		return pnCard;
	}

	public CardLayout getCardPanelGroup() {
		return cardPanelGroup;
	}

	public void addControls() {
		font = new Font("Tahoma", Font.PLAIN, 20);
		fontMenu = new Font("Tahoma", Font.PLAIN, 14);
		this.setLayout(new BorderLayout());

		/*
		 * ======================= PANEL TOP (CARD) =======================
		 */

		pnTopMenu = new JPanel();
		this.add(pnTopMenu, BorderLayout.NORTH);
		pnTopMenu.setLayout(new BoxLayout(pnTopMenu, BoxLayout.X_AXIS));
		pnTopMenu.setBackground(Color.WHITE);

		lbCard1 = new JLabel("Bệnh nhân");
		lbCard1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbCard1.setOpaque(true);

		lbCard2 = new JLabel("Chuẩn đoán");
		lbCard2.setFont(fontMenu);
		lbCard2.setOpaque(true);
		
		lbCard3 = new JLabel("Toa thuốc");
		lbCard3.setFont(fontMenu);
		lbCard3.setOpaque(true);

		lbCard2.setBackground(Color.WHITE);
		lbCard3.setBackground(Color.WHITE);

		lbCard1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lbCard2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lbCard3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnTopMenu.add(lbCard1);
		pnTopMenu.add(lbCard2);
		pnTopMenu.add(lbCard3);

		/*
		 * ======================= PANEL CONTAINS PANEL CARD =======================
		 */

		pnContainer = new JPanel();
		pnContainer.setLayout(new BoxLayout(pnContainer, BoxLayout.Y_AXIS));
		this.add(pnContainer, BorderLayout.CENTER);

		/*
		 * ======================= PANEL CARD =======================
		 */
		pnCard = new JPanel(cardPanelGroup);
		pnContainer.add(pnCard);
		pnCard.add(pnSubBenhNhan, "1");
		pnCard.add(pnSubChuanHoa, "2");
		pnCard.add(pnItemPrescriptions, "3");

		// add label
		cards.add(lbCard1);
		cards.add(lbCard2);
		cards.add(lbCard3);

	}
}
