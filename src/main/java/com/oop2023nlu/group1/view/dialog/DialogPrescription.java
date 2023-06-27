package com.oop2023nlu.group1.view.dialog;

import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.utils.FontConstant;
import com.oop2023nlu.group1.utils.ModelUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class DialogPrescription extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JLabel lbName, lbDate, lbPhone, lbAddress, lbSymptom, lbConclusion;
    private JPanel panel;


    public DialogPrescription(JFrame parent, List<PrescriptionMedicine> prescriptionMedicines) {
        super(parent, "Toa thuốc", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        setBounds(100, 100, 600, 500);
        Font font = new Font("Tahoma", Font.PLAIN, 18);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 20, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel pnTitle = new JPanel();
            contentPanel.add(pnTitle, BorderLayout.NORTH);
            pnTitle.add(new JLabel("<html><h1>Toa thuốc</h1></html>"), BorderLayout.CENTER);
        }

        JPanel pnContent = new JPanel();
        pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
        contentPanel.add(pnContent, BorderLayout.CENTER);
        lbName = new JLabel("Tên: " + ModelUtils.patient.getName());
        lbDate = new JLabel("Ngày khám: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ModelUtils.visit.getDate()));
        lbPhone = new JLabel("Số điện thoại: " + ModelUtils.patient.getPhone());
        lbAddress = new JLabel("Địa chỉ: " + ModelUtils.patient.getAddress());
        lbSymptom = new JLabel("Triệu chứng: " + ModelUtils.visit.getSymptom());
        lbConclusion = new JLabel("Kết luận: " + ModelUtils.visit.getConclusion());

        lbName.setFont(font);
        lbDate.setFont(font);
        lbPhone.setFont(font);
        lbAddress.setFont(font);
        lbSymptom.setFont(font);
        lbConclusion.setFont(font);

        pnContent.add(lbDate);
        pnContent.add(lbName);
        pnContent.add(lbPhone);
        pnContent.add(lbAddress);
        pnContent.add(lbSymptom);
        pnContent.add(lbConclusion);

        TitledBorder titledBorder = BorderFactory.createTitledBorder("Danh sách thuốc");
        titledBorder.setTitleFont(FontConstant.setFontPlain(16));
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 0, 20, 50);
        Border border = BorderFactory.createCompoundBorder(titledBorder, emptyBorder);

        panel = new JPanel();

        panel.setBorder(border);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < prescriptionMedicines.size(); i++) {
            JLabel label = new JLabel((i + 1) + " " + prescriptionMedicines.get(i).toString());
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            panel.add(label);
        }
        pnContent.add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
