package view.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import custom.TableCustom;
import main.Main;
import observer.Observer;

public class PnMedicine extends JPanel implements Observer{
	JPanel pnMain, pnTitle, pnInput, pnButton,pnTable;
	JLabel lbId, lbName, lbUnit;
	JTextField tfId, tfName;
	JComboBox<String> cbbUnit;
	JButton btnAdd, btnEdit, btnRemove;
	Font font, fontMenu;
	private DefaultTableModel dtmMedicine;
	private JTable tbMedicine;

	public PnMedicine() {
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
		pnTitle.add(new JLabel("<html><h1>QUẢN LÝ THUỐC</h1></html>"), BorderLayout.CENTER);
		/*
		 * ======================= PANEL INPUT =======================
		 */
		pnInput = new JPanel();
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		pnMain.add(pnInput);

		lbId = new JLabel("Mã thuốc");
		lbName = new JLabel("Tên thuốc");
		lbUnit = new JLabel("Liều dùng");

		lbId.setFont(font);
		lbName.setFont(font);
		lbUnit.setFont(font);

		tfId = new JTextField(24);
		tfName = new JTextField(24);
		cbbUnit = new JComboBox<>();
		cbbUnit.addItem("Chọn liều dùng");
		cbbUnit.addItem("Hộp");
		cbbUnit.addItem("Vỉ");
		cbbUnit.addItem("Viên");

		tfId.setFont(font);
		tfName.setFont(font);
		cbbUnit.setFont(font);

		JPanel pnId = new JPanel();
		pnId.add(lbId);
		pnId.add(tfId);
		pnInput.add(pnId);

		JPanel pnName = new JPanel();
		pnName.add(lbName);
		pnName.add(tfName);
		pnInput.add(pnName);

		JPanel pnUnit = new JPanel();
		pnUnit.add(lbUnit);
		pnUnit.add(cbbUnit);
		pnInput.add(pnUnit);

		Dimension lbSize = lbName.getPreferredSize();
		lbId.setPreferredSize(lbSize);
		lbName.setPreferredSize(lbSize);
		cbbUnit.setPreferredSize(tfId.getPreferredSize());
		/*
		 * ======================= PANEL BUTTON =======================
		 */
		pnButton = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEdit = new JButton("Lưu");
		btnRemove = new JButton("Xóa");

		Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
		btnAdd.setFont(fontButton);
		btnEdit.setFont(fontButton);
		btnRemove.setFont(fontButton);
		pnButton.add(btnAdd);
		pnButton.add(btnEdit);
		pnButton.add(btnRemove);
		pnMain.add(pnButton);
		/*
		 * ======================= PANEL TABLE =======================
		 */
		pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		pnTable.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		pnMain.add(pnTable);

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
		columnModelBanHang.getColumn(0).setPreferredWidth(60);
		columnModelBanHang.getColumn(1).setPreferredWidth(550);
		columnModelBanHang.getColumn(2).setPreferredWidth(200);

		JScrollPane scrTblSanPham = new JScrollPane(tbMedicine);
		pnTable.add(scrTblSanPham, BorderLayout.CENTER);
		pnMain.add(pnTable);

	}

//Viết code xử lí sự kiện trong đây
	public void addEvents() {

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
