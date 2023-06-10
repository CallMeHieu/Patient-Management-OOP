package view.panel.sub;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

public class PnItemPrescriptions extends JPanel {
	private JPanel pnMain, pnTitle, pnContent, pnInput, pnButton;

	public PnItemPrescriptions() {
		Main.changLNF("Windows");
		addControls();
		addEvents();
	}

	private void addControls() {
		Font font = new Font("Tahoma", Font.PLAIN, 20);

		/*
		 * ======================= PANEL CARD =======================
		 */

		this.setLayout(new BorderLayout());
		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		this.add(pnMain, BorderLayout.CENTER);
		/*
		 * ======================= PANEL TITLE =======================
		 */
		pnTitle = new JPanel();
		pnMain.add(pnTitle);
		pnTitle.add(new JLabel("<html><h1>TOA THUỐC</h1></html>"), BorderLayout.CENTER);
	}

	private void addEvents() {

	}
}
