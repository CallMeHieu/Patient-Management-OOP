package com.oop2023nlu.group1.view.panel;

import com.oop2023nlu.group1.utils.FontConstant;
import com.oop2023nlu.group1.custom.TableCustom;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.observer.Observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
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


public class PnMedicine extends JPanel implements Observer {
    private JPanel pnMain, pnTitle, pnInput, pnButton, pnTable, pnSearch;
    private JLabel lbId, lbName, lbDosage, lbUnit, lbSearch, lbSelectUnit;
    private JTextField tfId, tfName, tfDosage, tfSearch, tfUnit;
    private JComboBox<String> cbbUnit;
    private JButton btnAdd, btnEdit, btnRemove;
    private DefaultTableModel dtmMedicine;
    private JTable tbMedicine;
    private Medicine medicineModel;

    public PnMedicine() {
        Main.changLNF("Windows");
        addControls();
        addEvents();
    }

    public void setMedicineModel(Medicine medicineModel) {
        this.medicineModel = medicineModel;
    }

    public JTextField getTfId() {
        return tfId;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfDosage() {
        return tfDosage;
    }

    public JTextField getTfUnit() {
        return tfUnit;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public DefaultTableModel getDtmMedicine() {
        return dtmMedicine;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    private void addControls() {
        this.setLayout(new BorderLayout());
        pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        this.add(pnMain, BorderLayout.CENTER);
        /*
         * ======================= PANEL TITLE =======================
         */
        pnTitle = new JPanel();
        pnMain.add(pnTitle);
        pnTitle.add(new JLabel("<html><h1>QUẢN LÝ THUỐC</h1></html>"), BorderLayout.CENTER);
        /*
         * ======================= PANEL INPUT =======================
         */
        pnInput = new JPanel();
        pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
        pnMain.add(pnInput);

        lbId = new JLabel("Mã thuốc");
        lbName = new JLabel("Tên");
        lbUnit = new JLabel("Đơn vị");
        lbDosage = new JLabel("Liều dùng");
        lbSelectUnit = new JLabel("Nhập");

        lbId.setFont(FontConstant.setFontPlain(20));
        lbName.setFont(FontConstant.setFontPlain(20));
        lbDosage.setFont(FontConstant.setFontPlain(20));
        lbUnit.setFont(FontConstant.setFontPlain(20));
        lbSelectUnit.setFont(FontConstant.setFontPlain(20));

        tfId = new JTextField(24);
        tfId.setEditable(false);
        tfName = new JTextField(24);
        tfDosage = new JTextField(24);
        tfUnit = new JTextField(24);

        cbbUnit = new JComboBox<>();
        cbbUnit.addItem("Chọn đơn vị");
        cbbUnit.addItem("Hộp");
        cbbUnit.addItem("Vỉ");
        cbbUnit.addItem("Ống");
        cbbUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = cbbUnit.getSelectedItem().toString();
                if (selectedItem.equals("Chọn đơn vị")) {
                    tfUnit.setEditable(true);
                    tfUnit.setFont(FontConstant.setFontPlain(20));
                    tfUnit.setForeground(Color.BLACK);
                    tfUnit.setText("");
                    lbSelectUnit.setForeground(Color.BLACK);
                } else {
                    tfUnit.setEditable(false);
                    tfUnit.setText(selectedItem);
                    tfUnit.setForeground(Color.LIGHT_GRAY);
                    lbSelectUnit.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        tfId.setFont(FontConstant.setFontPlain(20));
        tfName.setFont(FontConstant.setFontPlain(20));
        tfDosage.setFont(FontConstant.setFontPlain(20));
        tfUnit.setFont(FontConstant.setFontPlain(20));
        cbbUnit.setFont(FontConstant.setFontPlain(20));

        JPanel pnId = new JPanel();
        pnId.add(lbId);
        pnId.add(tfId);
        pnInput.add(pnId);

        JPanel pnName = new JPanel();
        pnName.add(lbName);
        pnName.add(tfName);
        pnInput.add(pnName);

        JPanel pnDosage = new JPanel();
        pnDosage.add(lbDosage);
        pnDosage.add(tfDosage);
        pnInput.add(pnDosage);

        JPanel pnUnit = new JPanel();
        pnUnit.add(lbUnit);
        pnUnit.add(cbbUnit);
        JPanel pnSubUnit = new JPanel();
        pnSubUnit.add(lbSelectUnit);
        pnSubUnit.add(tfUnit);
        pnInput.add(pnUnit);
        pnInput.add(pnSubUnit);

        Dimension lbSize = lbDosage.getPreferredSize();
        lbId.setPreferredSize(lbSize);
        lbName.setPreferredSize(lbSize);
        lbDosage.setPreferredSize(lbSize);
        lbUnit.setPreferredSize(lbSize);
        lbSelectUnit.setPreferredSize(lbSize);
        cbbUnit.setPreferredSize(tfId.getPreferredSize());

        /*
         * ======================= PANEL BUTTON =======================
         */
        pnButton = new JPanel();
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Lưu");
        btnRemove = new JButton("Xóa");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnAdd.setFont(fontButton);
        btnEdit.setFont(fontButton);
        btnRemove.setFont(fontButton);
        pnButton.add(btnAdd);
        pnButton.add(btnEdit);
        pnButton.add(btnRemove);
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

        dtmMedicine = new DefaultTableModel();
        dtmMedicine.addColumn("Mã số");
        dtmMedicine.addColumn("Tên thuốc");
        dtmMedicine.addColumn("Đơn vị");
        dtmMedicine.addColumn("Liều dùng mặc định");

        tbMedicine = new JTable();
        tbMedicine = new TableCustom(dtmMedicine);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        tbMedicine.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tbMedicine.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tbMedicine.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tbMedicine.getColumnModel().getColumn(3).setCellRenderer(renderer);

        TableColumnModel columnModel = tbMedicine.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(400);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(400);

        JScrollPane scrollPane = new JScrollPane(tbMedicine);
        pnTable.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnTable);

    }

    private void addEvents() {
        tbMedicine.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbMedicine.getSelectedRow();
                if (row > -1) {
                    tfId.setText(tbMedicine.getValueAt(row, 0) + "");
                    tfName.setText(tbMedicine.getValueAt(row, 1) + "");
                    tfDosage.setText(tbMedicine.getValueAt(row, 3) + "");
                    cbbUnit.setSelectedIndex(0);
                    tfUnit.setText(tbMedicine.getValueAt(row, 2) + "");
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
        tfDosage.setText("");
        tfUnit.setText("");
    }

    @Override
    public void update() {
        dtmMedicine.setRowCount(0);
        for (Medicine medicine : medicineModel.getMedicines()) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(medicine.getMedicineID());
            vec.add(medicine.getName());
            vec.add(medicine.getUnit());
            vec.add(medicine.getDefaultDosage());
            dtmMedicine.addRow(vec);
        }
    }
}
