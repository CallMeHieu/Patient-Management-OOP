package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.view.container.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class MedicineController {
    private Container view;
    private Medicine medicineModel;

    public MedicineController(Container view, Medicine medicineModel) {
        this.view = view;
        this.medicineModel = medicineModel;
        initViewListeners();
        this.medicineModel.registerObserver(view.getMedicinePanel());
        this.view.getMedicinePanel().setMedicineModel(medicineModel);
        this.medicineModel.notifyObservers();
    }

    private void initViewListeners() {
        addMedicine();
        updateMedicine();
        deleteMedicine();
        searchMedicine();
    }


    private void addMedicine() {
        this.view.getMedicinePanel().btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getMedicinePanel().getTfId().getText().equals("")) {
                    String id = "";
                    if (medicineModel.getMedicines() == null) {
                        id = "SP001";
                    } else
                        id = "SP00" + (medicineModel.getMedicines().size() + 1);
                    String name = view.getMedicinePanel().getTfName().getText();
                    String dosage = view.getMedicinePanel().getTfDosage().getText();
                    String unit = view.getMedicinePanel().getTfUnit().getText();
                    Medicine medicine = new Medicine(id, name, unit, dosage);
                    if(name.equals("") || dosage.equals("") || unit.equals("")){
                        JOptionPane.showMessageDialog(null, "Hãy nhập đủ dữ liệu");
                    }else{
                        medicineModel.addMedicine(medicine);
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    }
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
                if (medicineModel.findMedicineById(id) != null) {
                    String name = view.getMedicinePanel().getTfName().getText();
                    String dosage = view.getMedicinePanel().getTfDosage().getText();
                    String unit = view.getMedicinePanel().getTfUnit().getText();
                    System.out.println(dosage);
                    System.out.println(unit);
                    Medicine medicine = new Medicine(id, name, unit, dosage);
                    if (medicineModel.updateMedicine(medicine))
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    else
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi !!! thuốc không tồn tại");
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
                    if (medicineModel.deleteMedicine(id))
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

    private void searchMedicine() {
    }
}
