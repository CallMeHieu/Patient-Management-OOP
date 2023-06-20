package com.oop2023nlu.group1.view.panel;

import com.oop2023nlu.group1.custom.TableCustom;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.observer.Observer;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PnPrescription extends JPanel implements Observer {
    JPanel pnMain, pnTitle, pnInput, pnButton, pnTable, pnTablePrescription;
    Font font, fontMenu;
    private DefaultTableModel dtmPrescription;
    private JTable tbPrescription;
    private JLabel lbIdPatient, lbFilter;
    private JTextField tfInput;
    private JComboBox<String> cbbFilter;
    private Visit visitModel = new Visit();

    public PnPrescription() {
        Main.changLNF("Windows");
        addControls();
    }

    public Visit getVisitModel() {
        return visitModel;
    }

    public void setVisitModel(Visit visitModel) {
        this.visitModel = visitModel;
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
         * ======================= PANEL INPUT =======================
         */
        pnInput = new JPanel();
        pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
        pnMain.add(pnInput);

        lbFilter = new JLabel("Lọc theo");
        lbIdPatient = new JLabel("Nhập thông tin tìm kiếm");

        lbFilter.setFont(font);
        lbIdPatient.setFont(font);

        cbbFilter = new JComboBox<>();
        cbbFilter.addItem("Mã bệnh nhân");
        cbbFilter.addItem("Số điện thoại");
        tfInput = new JTextField(24);

        cbbFilter.setFont(font);
        tfInput.setFont(font);

        JPanel pnFilter = new JPanel();
        pnFilter.add(lbFilter);
        pnFilter.add(cbbFilter);
        pnInput.add(pnFilter);

        JPanel pnIdPatient = new JPanel();
        pnIdPatient.add(lbIdPatient);
        pnIdPatient.add(tfInput);
        pnInput.add(pnIdPatient);

        Dimension lbSize = lbIdPatient.getPreferredSize();
        lbIdPatient.setPreferredSize(lbSize);
        lbFilter.setPreferredSize(lbSize);
        cbbFilter.setPreferredSize(tfInput.getPreferredSize());
        /*
         * ======================= PANEL TABLE  =======================
         */
        pnTablePrescription = new JPanel();
        pnTablePrescription.setLayout(new BorderLayout());
        pnTablePrescription.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        pnMain.add(pnTablePrescription);

        dtmPrescription = new DefaultTableModel();
        dtmPrescription.addColumn("Mã số");
        dtmPrescription.addColumn("Ngày khám");
        dtmPrescription.addColumn("Chuẩn đoán");
        dtmPrescription.addColumn("Kết quả");

        tbPrescription = new JTable();
        tbPrescription = new TableCustom(dtmPrescription);

        DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
        renderer1.setHorizontalAlignment(JLabel.CENTER);

        tbPrescription.getColumnModel().getColumn(0).setCellRenderer(renderer1);
        tbPrescription.getColumnModel().getColumn(1).setCellRenderer(renderer1);
        tbPrescription.getColumnModel().getColumn(2).setCellRenderer(renderer1);
        tbPrescription.getColumnModel().getColumn(3).setCellRenderer(renderer1);

        TableColumnModel columnModel = tbPrescription.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(400);
        columnModel.getColumn(3).setPreferredWidth(400);

        JScrollPane scrollPane = new JScrollPane(tbPrescription);
        pnTablePrescription.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnTablePrescription);
    }

    @Override
    public void update() {
        dtmPrescription.setRowCount(0);
        for (Visit visit : visitModel.getVisits()) {
            Vector<Object> vec = new Vector<>();
            vec.add(visit.getVisitID());
            vec.add(visit.getDate().toString());
            vec.add(visit.getSymptom());
            vec.add(visit.getConclusion());
            dtmPrescription.addRow(vec);
        }
    }

    public JTextField getTfInput() {
        return tfInput;
    }

    public JComboBox<String> getCbbFilter() {
        return cbbFilter;
    }

    public JPanel getPnMain() {
        return pnMain;
    }

    public DefaultTableModel getDtmPrescription() {
        return dtmPrescription;
    }

    public JTable getTbPrescription() {
        return tbPrescription;
    }
}
