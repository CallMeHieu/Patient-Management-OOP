package view.panel.sub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;

public class PnSubChuanHoa extends JPanel {
	private JPanel pnMain, pnTitle, pnContent, pnInput, pnButton;
	private JLabel lbId, lbName, lbBirthDay, lbGender, lbPhone, lbAddress, lbSymptom, lbCnclude;
	private JTextField tfId, tfName, tfBirthDay, tfPhone, tfAddress, tfSymptom, tfCnclude;
	private JComboBox<String> cbbGender;
	private JButton btnCancel, btnReset, btnSave;

	public PnSubChuanHoa() {
		Main.changLNF("Windows");
		addControls();
		addEvents();
	}

//Viết code tạo view trong đây
	public void addControls() {
		Font font = new Font("Tahoma", Font.PLAIN, 20);

		this.setLayout(new BorderLayout());

		pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		this.add(pnMain, BorderLayout.CENTER);

		pnTitle = new JPanel();
		pnTitle.setOpaque(false);
		pnTitle.add(new JLabel("<html><h1>CHUẨN ĐOÁN</h1></html>"));
		pnMain.add(pnTitle);

		pnContent = new JPanel();
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.X_AXIS));
		pnMain.add(pnContent);

		/*
		 * ======================= PANEL INPUT =======================
		 */

		pnInput = new JPanel();
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		pnContent.add(pnInput);

		lbId = new JLabel("Mã số bệnh nhân");
		lbName = new JLabel("Họ và tên");
		lbBirthDay = new JLabel("Ngày sinh");
		lbGender = new JLabel("Giới tính");
		lbPhone = new JLabel("Số điện thoại");
		lbAddress = new JLabel("Địa chỉ");
		lbSymptom = new JLabel("Triệu chứng");
		lbCnclude = new JLabel("Kết luận");

		lbId.setFont(font);
		lbName.setFont(font);
		lbBirthDay.setFont(font);
		lbGender.setFont(font);
		lbPhone.setFont(font);
		lbAddress.setFont(font);
		lbSymptom.setFont(font);
		lbCnclude.setFont(font);

		tfId = new JTextField(24);
		tfId.setEditable(false);
		tfName = new JTextField(24);
		tfBirthDay = new JTextField(24);
		cbbGender = new JComboBox<>();
		cbbGender.addItem("Chọn giới tính");
		cbbGender.addItem("Nam");
		cbbGender.addItem("Nữ");
		tfPhone = new JTextField(24);
		tfAddress = new JTextField(24);
		tfSymptom = new JTextField(24);
		tfCnclude = new JTextField(24);

		tfId.setFont(font);
		tfName.setFont(font);
		tfBirthDay.setFont(font);
		cbbGender.setFont(font);
		tfPhone.setFont(font);
		tfAddress.setFont(font);
		tfSymptom.setFont(font);
		tfCnclude.setFont(font);

		JPanel pnId = new JPanel();
		pnId.add(lbId);
		pnId.add(tfId);
		pnInput.add(pnId);

		JPanel pnName = new JPanel();
		pnName.add(lbName);
		pnName.add(tfName);
		pnInput.add(pnName);

		JPanel pnBirthDay = new JPanel();
		pnBirthDay.add(lbBirthDay);
		pnBirthDay.add(tfBirthDay);
		pnInput.add(pnBirthDay);

		JPanel pnGender = new JPanel();
		pnGender.add(lbGender);
		pnGender.add(cbbGender);
		pnInput.add(pnGender);

		JPanel pnPhone = new JPanel();
		pnPhone.add(lbPhone);
		pnPhone.add(tfPhone);
		pnInput.add(pnPhone);

		JPanel pnAddress = new JPanel();
		pnAddress.add(lbAddress);
		pnAddress.add(tfAddress);
		pnInput.add(pnAddress);

		JPanel pnSymptom = new JPanel();
		pnSymptom.add(lbSymptom);
		pnSymptom.add(tfSymptom);
		pnInput.add(pnSymptom);

		JPanel pnCnclude = new JPanel();
		pnCnclude.add(lbCnclude);
		pnCnclude.add(tfCnclude);
		pnInput.add(pnCnclude);

		Dimension lbSize = lbId.getPreferredSize();
		lbId.setPreferredSize(lbSize);
		lbName.setPreferredSize(lbSize);
		lbBirthDay.setPreferredSize(lbSize);
		lbGender.setPreferredSize(lbSize);
		lbPhone.setPreferredSize(lbSize);
		lbAddress.setPreferredSize(lbSize);
		lbSymptom.setPreferredSize(lbSize);
		lbCnclude.setPreferredSize(lbSize);
		cbbGender.setPreferredSize(tfId.getPreferredSize());

		/*
		 * ======================= PANEL BUTTON =======================
		 */

		pnButton = new JPanel();
		btnCancel = new JButton("Hủy");
		btnReset = new JButton("Làm mới");
		btnSave = new JButton("Lưu");

		Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
		btnCancel.setFont(fontButton);
		btnReset.setFont(fontButton);
		btnSave.setFont(fontButton);
		pnButton.add(btnCancel);
		pnButton.add(btnReset);
		pnButton.add(btnSave);
		pnMain.add(pnButton);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BorderLayout());
		pnTable.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		pnMain.add(pnTable);

	}

//Viết code xử lí sự kiện trong đây
	public void addEvents() {

	}
}
