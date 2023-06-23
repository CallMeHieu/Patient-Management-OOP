package com.oop2023nlu.group1.view.panel.sub;

import com.oop2023nlu.group1.utils.FontConstant;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Patient;

import java.awt.*;

import javax.swing.*;


public class PnItemDiagnostic extends JPanel {
    private JPanel pnMain, pnTitle, pnContent, pnInput, pnButton;
    private JLabel lbId, lbName, lbBirthDay, lbGender, lbPhone, lbAddress, lbSymptom, lbConclusion;
    private JTextField tfId, tfName, tfBirthDay, tfGender, tfPhone, tfAddress;
    private JTextArea taSymptom, taConclusion;
    private JButton btnBack, btnContinue;

    public PnItemDiagnostic() {
        Main.changLNF("Windows");
        addControls();
    }

    public JTextField getTfId() {
        return tfId;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfBirthDay() {
        return tfBirthDay;
    }

    public JTextField getTfGender() {
        return tfGender;
    }

    public JTextField getTfPhone() {
        return tfPhone;
    }

    public JTextField getTfAddress() {
        return tfAddress;
    }

    public JTextArea getTaSymptom() {
        return taSymptom;
    }

    public JTextArea getTaConclusion() {
        return taConclusion;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnContinue() {
        return btnContinue;
    }

    public void addControls() {
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
        lbConclusion = new JLabel("Kết luận");

        lbId.setFont(FontConstant.setFontPlain(20));
        lbName.setFont(FontConstant.setFontPlain(20));
        lbBirthDay.setFont(FontConstant.setFontPlain(20));
        lbGender.setFont(FontConstant.setFontPlain(20));
        lbPhone.setFont(FontConstant.setFontPlain(20));
        lbAddress.setFont(FontConstant.setFontPlain(20));
        lbSymptom.setFont(FontConstant.setFontPlain(20));
        lbConclusion.setFont(FontConstant.setFontPlain(20));

        tfId = new JTextField(24);
        tfId.setEditable(false);
        tfName = new JTextField(24);
        tfName.setEditable(false);
        tfBirthDay = new JTextField(24);
        tfBirthDay.setEditable(false);
        tfGender = new JTextField(24);
        tfGender.setEditable(false);
        tfPhone = new JTextField(24);
        tfPhone.setEditable(false);
        tfAddress = new JTextField(24);
        tfAddress.setEditable(false);
        taSymptom = new JTextArea(2, 24);
        taSymptom.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        taSymptom.setLineWrap(true);
        taSymptom.setWrapStyleWord(true);

        taConclusion = new JTextArea(2, 24);
        taConclusion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        taConclusion.setLineWrap(true);
        taConclusion.setWrapStyleWord(true);

        tfId.setFont(FontConstant.setFontPlain(20));
        tfName.setFont(FontConstant.setFontPlain(20));
        tfBirthDay.setFont(FontConstant.setFontPlain(20));
        tfGender.setFont(FontConstant.setFontPlain(20));
        tfPhone.setFont(FontConstant.setFontPlain(20));
        tfAddress.setFont(FontConstant.setFontPlain(20));
        taSymptom.setFont(FontConstant.setFontPlain(20));
        taConclusion.setFont(FontConstant.setFontPlain(20));

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
        pnGender.add(tfGender);
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
        pnSymptom.add(taSymptom);
        pnInput.add(pnSymptom);

        JPanel pnConclusion = new JPanel();
        pnConclusion.add(lbConclusion);
        pnConclusion.add(taConclusion);
        pnInput.add(pnConclusion);

        Dimension lbSize = lbId.getPreferredSize();
        lbSize.setSize(lbSize.getWidth() + 12, lbSize.getHeight());
        lbId.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbBirthDay.setPreferredSize(lbSize);
        lbGender.setPreferredSize(lbSize);
        lbPhone.setPreferredSize(lbSize);
        lbAddress.setPreferredSize(lbSize);
        lbSymptom.setPreferredSize(lbSize);
        lbConclusion.setPreferredSize(lbSize);
        tfGender.setPreferredSize(lbSize);
        taConclusion.setPreferredSize(lbSize);
        taSymptom.setPreferredSize(lbSize);

        /*
         * ======================= PANEL BUTTON =======================
         */

        pnButton = new JPanel();
        btnBack = new JButton("Quay lại");
        btnContinue = new JButton("Tiếp tục");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnBack.setFont(fontButton);
        btnContinue.setFont(fontButton);
        pnButton.add(btnBack);
        pnButton.add(btnContinue);
        pnMain.add(pnButton);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        pnTable.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        pnMain.add(pnTable);

    }
    public void loadPatient(Patient patient) {
        tfId.setText(patient.getId());
        tfName.setText(patient.getName());
        tfBirthDay.setText(patient.getYearOfBirth() + "");
        if (patient.isGender()) {
            tfGender.setText("Nam");
        } else {
            tfGender.setText("Nữ");
        }
        tfPhone.setText(patient.getPhone());
        tfAddress.setText(patient.getAddress());
    }
}
