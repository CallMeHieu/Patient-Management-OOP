package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

public class PnDanh extends JPanel {

	public PnDanh() {
		Main.changLNF("Windows");
		addControls();
		addEvents();
	}

//Viết code tạo view trong đây
	public void addControls() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.ORANGE);
//
//		int w = 950;
//		int h = 654;

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		pnMain.add(new JLabel("Danh"));
		this.add(pnMain, BorderLayout.CENTER);
	}

//Viết code xử lí sự kiện trong đây
	public void addEvents() {

	}
}
