package com.oop2023nlu.group1.view.panel;

import com.oop2023nlu.group1.main.Main;

import javax.swing.*;
import java.awt.*;

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
