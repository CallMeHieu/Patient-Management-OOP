package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.panel.PnMedicine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;


public class MedicineController {
    private Container view;
    private Medicine medicineModel;
    private PnMedicine pnMedicine;

    public MedicineController(Container view, Medicine medicineModel) {
        this.view = view;
        this.medicineModel = medicineModel;
        this.pnMedicine = view.getMedicinePanel();
        this.medicineModel.registerObserver(view.getMedicinePanel());
        this.view.getMedicinePanel().setMedicineModel(medicineModel);
        this.medicineModel.notifyObservers();
        initViewListeners();
    }

    private void initViewListeners() {
        add();
        update();
        delete();
        search();
    }

    private void add() {
        pnMedicine.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnMedicine.getTfId().getText().equals("")) {
                    String id = "";
                    if (medicineModel.getMedicines() == null)
                        id = "SP1";
                    else
                        id = "SP" + (medicineModel.getMedicines().size() + 1);
                    Medicine medicine = getMedicineModel();
                    medicine.setMedicineID(id);
                    if (medicine.getName().equals("") || medicine.getDefaultDosage().equals("") || medicine.getUnit().equals("")) {
                        JOptionPane.showMessageDialog(null, "Hãy nhập đủ dữ liệu");
                    } else {
                        medicineModel.addMedicine(medicine);
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    }
                } else {
                    resetForm();
                }
            }

        });
    }

    private void update() {
        pnMedicine.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (medicineModel.findMedicineById(pnMedicine.getTfId().getText()) != null) {
                    Medicine medicine = getMedicineModel();
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

    private void delete() {
        pnMedicine.getBtnRemove().addActionListener(new ActionListener() {
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

    private void search() {
        pnMedicine.getTfSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charName = pnMedicine.getTfSearch().getText();
                List<Medicine> medicines = medicineModel.findAllByCharName(charName);
                pnMedicine.getDtmMedicine().setRowCount(0);
                for (Medicine medicine : medicines) {
                    Vector<Object> vec = new Vector<>();
                    vec.add(medicine.getMedicineID());
                    vec.add(medicine.getName());
                    vec.add(medicine.getUnit());
                    vec.add(medicine.getDefaultDosage());
                    pnMedicine.getDtmMedicine().addRow(vec);
                }
            }
        });
    }

    private void resetForm() {
        pnMedicine.getTfId().setText("");
        pnMedicine.getTfName().setText("");
        pnMedicine.getTfDosage().setText("");
        pnMedicine.getTfUnit().setText("");
    }

    private Medicine getMedicineModel() {
        String id = pnMedicine.getTfId().getText();
        String name = pnMedicine.getTfName().getText();
        String dosage = pnMedicine.getTfDosage().getText();
        String unit = pnMedicine.getTfUnit().getText();
        return new Medicine(id, name, unit, dosage);
    }
}
