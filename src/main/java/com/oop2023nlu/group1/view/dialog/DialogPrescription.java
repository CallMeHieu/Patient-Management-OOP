package com.oop2023nlu.group1.view.dialog;

import com.oop2023nlu.group1.model.PrescriptionMedicine;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DialogPrescription extends JDialog {
    public DialogPrescription(JFrame parent, List<PrescriptionMedicine> prescriptionMedicines) {
        super(parent, "Toa thuốc", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        Font font = new Font("Tahoma", Font.PLAIN, 20);
        setLayout(new BorderLayout());

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        add(pnMain, BorderLayout.CENTER);

        JPanel pnTitle = new JPanel();
        pnMain.add(pnTitle);
        pnTitle.add(new JLabel("<html><h1>Toa thuốc</h1></html>"), BorderLayout.CENTER);

        StringBuilder result = new StringBuilder();
        for (PrescriptionMedicine prescriptionMedicine : prescriptionMedicines) {
            result.append(prescriptionMedicine.toString());
        }

        JPanel pnContent = new JPanel();
        pnContent.add(new JLabel(result.toString()));
        pnMain.add(pnContent);

        setVisible(true);
    }
}
