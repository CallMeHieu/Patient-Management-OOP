package view.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Main;
import observer.Observer;
import view.panel.sub.PnSubBenhNhan;
import view.panel.sub.PnSubChuanHoa;

public class PnPatient extends JPanel {
	JPanel pnTopMenu, pnContainer, pnCard;
	JLabel lbCard1, lbCard2;
	Font font, fontMenu;
	PnSubBenhNhan pnSubBenhNhan = new PnSubBenhNhan();
	PnSubChuanHoa pnSubChuanHoa = new PnSubChuanHoa();

	private CardLayout cardPanelGroup = new CardLayout();
	private List<JLabel> cards = new ArrayList<>();

	public PnSubBenhNhan getPnSubBenhNhan() {
		return pnSubBenhNhan;
	}

	public PnSubChuanHoa getPnSubChuanHoa() {
		return pnSubChuanHoa;
	}

	public PnPatient() {
		Main.changLNF("Windows");
		addControls();
		addEvents();
	}

//Viết code tạo view trong đây
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

		lbCard2.setBackground(Color.WHITE);

		lbCard1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		lbCard2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pnTopMenu.add(lbCard1);
		pnTopMenu.add(lbCard2);

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

		// add label
		cards.add(lbCard1);
		cards.add(lbCard2);

	}

//Viết code xử lí sự kiện trong đây
	public void addEvents() {
		pnSubBenhNhan.getBtnView().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pnSubBenhNhan.getTfId().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
					return;
				}
				for (JLabel jLabel : cards) {
					if (jLabel == lbCard2) {
						jLabel.setBackground(new Color(240, 240, 240));
						jLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					} else {
						jLabel.setBackground(Color.WHITE);
						jLabel.setFont(fontMenu);
					}
				}
				cardPanelGroup.show(pnCard, "2");
			}
		});

		for (JLabel jLabel : cards) {
			jLabel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					String card = "";
					if (jLabel == lbCard1) {
						card = "1";
					} else if (jLabel == lbCard2 && !pnSubBenhNhan.getTfId().getText().isEmpty()) {
						card = "2";
					}

					if (jLabel == lbCard2 && pnSubBenhNhan.getTfId().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
						return;
					}

					for (JLabel jLabel1 : cards) {
						if (jLabel1 == jLabel) {
							jLabel.setBackground(new Color(240, 240, 240));
							jLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						} else {
							jLabel1.setBackground(Color.WHITE);
							jLabel1.setFont(fontMenu);
						}
					}
					cardPanelGroup.show(pnCard, card);

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
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
		}

	}
}
