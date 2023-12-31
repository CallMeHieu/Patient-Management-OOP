package com.oop2023nlu.group1.view.panel.sub;

import com.oop2023nlu.group1.utils.FontConstant;
import com.oop2023nlu.group1.custom.TableCustom;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.*;
import com.oop2023nlu.group1.observer.Observer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

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


public class PnItemInfoPatient extends JPanel implements Observer {
    private JPanel pnMain, pnTitle, pnInput, pnButton, pnSearch, pnTable;
    private JButton btnAdd, btnSave, btnRemove, btnDiagnostic;
    private JLabel lbId, lbName, lbYearOfBirth, lbGender, lbPhone, lbAddress, lbSearch;
    private JTextField tfId, tfName, tfYearOfBirth, tfPhone, tfAddress, tfSearch;
    private JComboBox<String> cbbGender;
    private DefaultTableModel dtmPatient;
    private JTable tbPatient;
    private Patient patientModel;

    public PnItemInfoPatient() {
        Main.changLNF("Windows");
        addControls();
        addEvents();
    }

    public DefaultTableModel getDtmPatient() {
        return dtmPatient;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnDiagnostic() {
        return btnDiagnostic;
    }

    public JTextField getTfId() {
        return tfId;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfYearOfBirth() {
        return tfYearOfBirth;
    }

    public JTextField getTfPhone() {
        return tfPhone;
    }

    public JTextField getTfAddress() {
        return tfAddress;
    }

    public JComboBox<String> getCbbGender() {
        return cbbGender;
    }

    public void setModel(Patient patientModel) {
        this.patientModel = patientModel;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    private void addControls() {
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
        pnTitle.add(new JLabel("<html><h1>QUẢN LÝ BỆNH NHÂN</h1></html>"), BorderLayout.CENTER);

        /*
         * ======================= PANEL INPUT =======================
         */
        pnInput = new JPanel();
        pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
        pnMain.add(pnInput);

        lbId = new JLabel("Mã số bệnh nhân");
        lbName = new JLabel("Họ và tên");
        lbYearOfBirth = new JLabel("Năm sinh");
        lbGender = new JLabel("Giới tính");
        lbPhone = new JLabel("Số điện thoại");
        lbAddress = new JLabel("Địa chỉ");

        lbId.setFont(FontConstant.setFontPlain(20));
        lbName.setFont(FontConstant.setFontPlain(20));
        lbYearOfBirth.setFont(FontConstant.setFontPlain(20));
        lbGender.setFont(FontConstant.setFontPlain(20));
        lbPhone.setFont(FontConstant.setFontPlain(20));
        lbAddress.setFont(FontConstant.setFontPlain(20));

        tfId = new JTextField(24);
        tfId.setEditable(false);
        tfName = new JTextField(24);
        tfYearOfBirth = new JTextField(24);
        cbbGender = new JComboBox<>();
        cbbGender.addItem("Chọn giới tính");
        cbbGender.addItem("Nam");
        cbbGender.addItem("Nữ");
        tfPhone = new JTextField(24);
        tfAddress = new JTextField(24);

        tfId.setFont(FontConstant.setFontPlain(20));
        tfName.setFont(FontConstant.setFontPlain(20));
        tfYearOfBirth.setFont(FontConstant.setFontPlain(20));
        cbbGender.setFont(FontConstant.setFontPlain(20));
        tfPhone.setFont(FontConstant.setFontPlain(20));
        tfAddress.setFont(FontConstant.setFontPlain(20));

        JPanel pnId = new JPanel();
        pnId.add(lbId);
        pnId.add(tfId);
        pnInput.add(pnId);

        JPanel pnName = new JPanel();
        pnName.add(lbName);
        pnName.add(tfName);
        pnInput.add(pnName);

        JPanel pnYearOfBirth = new JPanel();
        pnYearOfBirth.add(lbYearOfBirth);
        pnYearOfBirth.add(tfYearOfBirth);
        pnInput.add(pnYearOfBirth);

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

        Dimension lbSize = lbId.getPreferredSize();
        lbSize.setSize(lbSize.getWidth() + 12, lbSize.getHeight());
        lbId.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbYearOfBirth.setPreferredSize(lbSize);
        lbGender.setPreferredSize(lbSize);
        lbPhone.setPreferredSize(lbSize);
        lbAddress.setPreferredSize(lbSize);
        cbbGender.setPreferredSize(tfId.getPreferredSize());

        /*
         * ======================= PANEL BUTTON =======================
         */
        pnButton = new JPanel();
        btnAdd = new JButton("Thêm");
        btnSave = new JButton("Lưu");
        btnRemove = new JButton("Xóa");
        btnDiagnostic = new JButton("Khám bệnh");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnAdd.setFont(fontButton);
        btnSave.setFont(fontButton);
        btnRemove.setFont(fontButton);
        btnDiagnostic.setFont(fontButton);
        pnButton.add(btnAdd);
        pnButton.add(btnSave);
        pnButton.add(btnRemove);
        pnButton.add(btnDiagnostic);
        pnMain.add(pnButton);

        pnSearch = new JPanel();
        lbSearch = new JLabel("Tìm kiếm");
        lbSearch.setFont(FontConstant.setFontPlain(20));
        tfSearch = new JTextField(20);
        tfSearch.setFont(FontConstant.setFontPlain(20));
        pnSearch.add(lbSearch);
        pnSearch.add(tfSearch);
        pnMain.add(pnSearch);

        /*
         * ======================= PANEL TABLE =======================
         */
        pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        pnTable.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        pnMain.add(pnTable);

        dtmPatient = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmPatient.addColumn("Mã số");
        dtmPatient.addColumn("Họ tên");
        dtmPatient.addColumn("Năm sinh");
        dtmPatient.addColumn("Giới tính");
        dtmPatient.addColumn("Số điện thoại");
        dtmPatient.addColumn("Địa chỉ");

        tbPatient = new JTable();
        tbPatient = new TableCustom(dtmPatient);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        tbPatient.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tbPatient.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tbPatient.getColumnModel().getColumn(3).setCellRenderer(renderer);
        tbPatient.getColumnModel().getColumn(4).setCellRenderer(renderer);
        tbPatient.getColumnModel().getColumn(5).setCellRenderer(renderer);

        TableColumnModel columnModel = tbPatient.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(80);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(140);
        columnModel.getColumn(5).setPreferredWidth(300);

        JScrollPane scrollPane = new JScrollPane(tbPatient);
        pnTable.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnTable);
    }

    private void addEvents() {
        tbPatient.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbPatient.getSelectedRow();
                if (row > -1) {
                    tfId.setText(tbPatient.getValueAt(row, 0) + "");
                    tfName.setText(tbPatient.getValueAt(row, 1) + "");
                    tfYearOfBirth.setText(tbPatient.getValueAt(row, 2) + "");
                    int index = tbPatient.getValueAt(row, 3).equals("Nam") ? 1 : 2;
                    cbbGender.setSelectedIndex(index);
                    tfPhone.setText(tbPatient.getValueAt(row, 4) + "");
                    tfAddress.setText(tbPatient.getValueAt(row, 5) + "");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void resetForm() {
        tfId.setText("");
        tfName.setText("");
        tfPhone.setText("");
        tfYearOfBirth.setText("");
        tfAddress.setText("");
    }

    @Override
    public void update() {
        dtmPatient.setRowCount(0);
        for (Patient patient : patientModel.getPatients()) {
            Vector<Object> vec = new Vector<>();
            vec.add(patient.getId());
            vec.add(patient.getName());
            vec.add(patient.getYearOfBirth());
            if (patient.isGender()) {
                vec.add("Nam");
            } else
                vec.add("Nữ");
            vec.add(patient.getPhone());
            vec.add(patient.getAddress());
            dtmPatient.addRow(vec);
        }
    }
}
