package com.oop2023nlu.group1.view;

import com.oop2023nlu.group1.custom.TableCustom;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.observer.Observer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PnPrescription extends JPanel implements Observer {
	JPanel pnMain, pnTitle, pnInput, pnButton, pnTable, pnTableMedicine, pnTablePrescription;
	Font font, fontMenu;
	private DefaultTableModel dtmMedicine, dtmPrescription;
	private JTable tbMedicine, tbPrescription;
	private Clinic clinic;

	public PnPrescription() {
		Main.changLNF("Windows");
		addControls();
		addEvents();
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	// Viết code tạo view trong đây
	public void addControls() {
		font = new Font("Tahoma", Font.PLAIN, 20);
		fontMenu = new Font("Tahoma", Font.PLAIN, 14);
		this.setLayout(new BorderLayout());

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
		pnTitle.add(new JLabel("<html><h1>QUẢN LÝ TOA THUỐC</h1></html>"), BorderLayout.CENTER);
		/*
		 * ======================= PANEL TABLE =======================
		 */
		pnTable = new JPanel();
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		pnMain.add(pnTable);
		/*
		 * ======================= PANEL TABLE 1 =======================
		 */
		pnTableMedicine = new JPanel();
		pnTableMedicine.setLayout(new BorderLayout());
		pnTableMedicine.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		pnTable.add(pnTableMedicine);

		dtmMedicine = new DefaultTableModel();
		dtmMedicine.addColumn("Mã số");
		dtmMedicine.addColumn("Tên thuốc");
		dtmMedicine.addColumn("Liều dùng");

		tbMedicine = new JTable();
		tbMedicine = new TableCustom(dtmMedicine);

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);

		tbMedicine.getColumnModel().getColumn(0).setCellRenderer(renderer);
		tbMedicine.getColumnModel().getColumn(1).setCellRenderer(renderer);
		tbMedicine.getColumnModel().getColumn(2).setCellRenderer(renderer);

		TableColumnModel columnModelBanHang = tbMedicine.getColumnModel();
		columnModelBanHang.getColumn(0).setPreferredWidth(100);
		columnModelBanHang.getColumn(1).setPreferredWidth(250);
		columnModelBanHang.getColumn(2).setPreferredWidth(100);

		JScrollPane scrTblSanPham = new JScrollPane(tbMedicine);
		pnTableMedicine.add(scrTblSanPham, BorderLayout.CENTER);
		pnTable.add(pnTableMedicine);
		/*
		 * ======================= PANEL TABLE 2 =======================
		 */
		pnTablePrescription = new JPanel();
		pnTablePrescription.setLayout(new BorderLayout());
		pnTablePrescription.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		pnTable.add(pnTablePrescription);

		dtmPrescription = new DefaultTableModel();
		dtmPrescription.addColumn("Mã số");
		dtmPrescription.addColumn("Tên thuốc");
		dtmPrescription.addColumn("Liều dùng");
		dtmPrescription.addColumn("Đơn vị");

		tbPrescription = new JTable();
		tbPrescription = new TableCustom(dtmPrescription);

		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setHorizontalAlignment(JLabel.CENTER);

		tbPrescription.getColumnModel().getColumn(0).setCellRenderer(renderer1);
		tbPrescription.getColumnModel().getColumn(1).setCellRenderer(renderer1);
		tbPrescription.getColumnModel().getColumn(2).setCellRenderer(renderer1);
		tbPrescription.getColumnModel().getColumn(3).setCellRenderer(renderer1);

		TableColumnModel columnModelBanHang1 = tbPrescription.getColumnModel();
		columnModelBanHang1.getColumn(0).setPreferredWidth(60);
		columnModelBanHang1.getColumn(1).setPreferredWidth(400);
		columnModelBanHang1.getColumn(2).setPreferredWidth(400);
		columnModelBanHang1.getColumn(3).setPreferredWidth(200);

		JScrollPane scrTblSanPham1 = new JScrollPane(tbPrescription);
		pnTablePrescription.add(scrTblSanPham1, BorderLayout.CENTER);
		pnTable.add(pnTablePrescription);
	}

	public void addEvents() {

	}

	@Override
	public void update() {
		dtmPrescription.setRowCount(0);
		for (Medicine medicine : clinic.getMedicines()) {
			Vector<Object> vec = new Vector<>();
			vec.add(medicine.getMedicineID());
			vec.add(medicine.getName());
			vec.add(medicine.getDefaultDosage());
			vec.add(medicine.getUnit());
			dtmPrescription.addRow(vec);
		}
	}
}
