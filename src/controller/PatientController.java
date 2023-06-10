package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.Clinic;
import model.Patient;
import view.container.Container;

public class PatientController {
    private Container view;
    private Clinic model;

    public PatientController(Container view, Clinic model) {
        super();
        this.view = view;
        this.model = model;
        initViewListeners();
        model.registerObserver(view.getPatientPanel().getPnSubBenhNhan());
        view.getPatientPanel().getPnSubBenhNhan().setClinic(model);
        model.notifyObservers();
    }

    private void initViewListeners() {
//ADD CONTROLLLER
        this.view.getPatientPanel().getPnSubBenhNhan().getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnSubBenhNhan().getTfId().getText().equals("")) {
                    String id = "";
                    if (model.getPatients() == null) {
                        id = "001";
                    } else
                        id = "00" + (model.getPatients().size() + 1);
                    String name = view.getPatientPanel().getPnSubBenhNhan().getTfName().getText();
                    String address = view.getPatientPanel().getPnSubBenhNhan().getTfAddress().getText();
                    String phone = view.getPatientPanel().getPnSubBenhNhan().getTfPhone().getText();
                    int yearOfBirth = Integer
                            .parseInt(view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().getText());
                    String gender = view.getPatientPanel().getPnSubBenhNhan().getCbbGender().getSelectedItem() + "";
                    Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
                    if (gender.equalsIgnoreCase("Nữ")) {
                        patient = new Patient(id, name, address, phone, yearOfBirth, false);
                    }
                    model.addPatient(patient);

//					loadDataOfTablePatient();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    resetForm();
                }
            }
        });

//DELETE CONTROLLLER
        this.view.getPatientPanel().getPnSubBenhNhan().getBtnRemove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc là xóa bệnh nhân này", "Xác nhận",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
                    if (model.deletePatient(id))
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    else
                        JOptionPane.showMessageDialog(null, "Xóa thất bại!!! vì hiếu ngu");
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("Mày vừa chọn không");
                } else {
                    System.out.println("...");
                }
            }
        });

//UPDATE CONTROLLLER
        this.view.getPatientPanel().getPnSubBenhNhan().getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
                if (model.findPatientById(id) != null) {

                    String name = view.getPatientPanel().getPnSubBenhNhan().getTfName().getText();
                    String address = view.getPatientPanel().getPnSubBenhNhan().getTfAddress().getText();
                    String phone = view.getPatientPanel().getPnSubBenhNhan().getTfPhone().getText();
                    int yearOfBirth = Integer
                            .parseInt(view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().getText());
                    String gender = view.getPatientPanel().getPnSubBenhNhan().getCbbGender().getSelectedItem() + "";

                    Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
                    if (gender.equalsIgnoreCase("Nữ"))
                        patient = new Patient(id, name, address, phone, yearOfBirth, false);

                    if(model.updatePatient(patient)) JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					else JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi !!! Không tìm thấy bệnh nhân này");
                }
            }
        });
    }


    private void resetForm() {
        view.getPatientPanel().getPnSubBenhNhan().getTfId().setText("");
        view.getPatientPanel().getPnSubBenhNhan().getTfName().setText("");
        view.getPatientPanel().getPnSubBenhNhan().getTfPhone().setText("");
        view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().setText("");
        view.getPatientPanel().getPnSubBenhNhan().getTfAddress().setText("");
    }

}
