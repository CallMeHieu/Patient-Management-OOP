package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Clinic;
import model.Medicine;
import view.container.Container;

public class ManamentMedicineController {
	private Container view;
	private Clinic model;

	public ManamentMedicineController(Container view, Clinic model) {
		super();
		this.view = view;
		this.model = model;
		initViewListeners();
		model.registerObserver(view.getMedicinePanel());
		view.getMedicinePanel().setClinic(model);
		model.notifyObservers();
	}

	private void initViewListeners() {
		addMedicine();
		updateMedicine();
		deleteMedicine();
	}

	private void addMedicine() {
		this.view.getMedicinePanel().btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getMedicinePanel().getTfId().getText().equals("")) {
					String id = "";
					if (model.getMedicines() == null) {
						id = "SP001";
					} else
						id = "SP00" + (model.getMedicines().size() + 1);
					String name = view.getMedicinePanel().getTfName().getText();
					String dosage = view.getMedicinePanel().getTfDosage().getText();
					String unit = view.getMedicinePanel().getCbbUnit().getSelectedItem().toString();
					Medicine medicine = new Medicine(id, name, unit, dosage);
					model.addMedicine(medicine);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				} else {
					resetForm();
				}
			}

		});
	}

	private void resetForm() {
		view.getMedicinePanel().getTfId().setText("");
		view.getMedicinePanel().getTfName().setText("");
		view.getMedicinePanel().getTfDosage().setText("");
	}

	private void updateMedicine() {
		this.view.getMedicinePanel().btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.getMedicinePanel().getTfId().getText();
				if (model.findMedicineById(id) != null) {
					String name = view.getMedicinePanel().getTfName().getText();
					String dosage = view.getMedicinePanel().getTfDosage().getText();
					String unit = view.getMedicinePanel().getCbbUnit().getSelectedItem().toString();
					Medicine medicine = new Medicine(id, name, unit, dosage);
					if (model.updateMedicine(medicine))
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					else
						JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!!");
				} else {
					JOptionPane.showMessageDialog(null, "Lỗi !!! Không tìm thấy bệnh nhân này");
				}
			}
		});
	}

	private void deleteMedicine() {
		this.view.getMedicinePanel().btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc là xóa loại thuốc này", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					String id = view.getMedicinePanel().getTfId().getText();
					if (model.deleteMedicine(id))
						JOptionPane.showMessageDialog(null, "Xóa thành công");
					else
						JOptionPane.showMessageDialog(null, "Xóa thất bại!!!");
				} else if (result == JOptionPane.NO_OPTION) {
					System.out.println("Bạn chọn không");
				} else {
					System.out.println("...");
				}
			}
		});
	}

}
