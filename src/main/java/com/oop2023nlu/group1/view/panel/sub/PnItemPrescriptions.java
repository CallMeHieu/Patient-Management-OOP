package com.oop2023nlu.group1.view.panel.sub;

import com.oop2023nlu.group1.custom.TableCustom;
import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.model.*;
import com.oop2023nlu.group1.observer.Observer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PnItemPrescriptions extends JPanel implements Observer {
    private JPanel pnMain, pnTitle, pnTable, pnSearch, pnContent, pnButton;
    private JLabel lbSearch, lbId, lbName, lbPhone, lbAddress, lbYearOfBirth, lbSymptom, lbConclusion;
    private JTextArea taPrescriptions;
    private JTextField tfSearch;
    private DefaultTableModel dtmPrescription;
    private JTable tbPrescription;
    public JButton btnBack, btnSave, btnGetMedicines;
    private Medicine medicineModel;
    private List<PrescriptionMedicine> items = new ArrayList<>();

    public PnItemPrescriptions() {
        Main.changLNF("Windows");
        addControls();
    }

    private void addControls() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);
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
        pnTitle.add(new JLabel("<html><h1>TOA THUỐC</h1></html>"), BorderLayout.CENTER);
        /*
         * ======================= PANEL CONTENT =======================
         */
        pnContent = new JPanel();
        pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));
        lbId = new JLabel();
        lbName = new JLabel("Name");
        lbYearOfBirth = new JLabel("YearOfBirth");
        lbPhone = new JLabel("Phone");
        lbAddress = new JLabel("Address");
        lbSymptom = new JLabel();
        lbConclusion = new JLabel();

        lbName.setFont(font);
        lbYearOfBirth.setFont(font);
        lbPhone.setFont(font);
        lbAddress.setFont(font);
        lbSymptom.setFont(font);
        lbConclusion.setFont(font);

        taPrescriptions = new JTextArea(10, 30);
        taPrescriptions.setEditable(false);
        taPrescriptions.setFont(font);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.X_AXIS));
        JPanel pnInfo1 = new JPanel();
        pnInfo1.setLayout(new BoxLayout(pnInfo1, BoxLayout.Y_AXIS));
        pnInfo1.add(lbId);
        pnInfo1.add(lbName);
        pnInfo1.add(lbYearOfBirth);
        pnInfo1.add(lbPhone);
        pnInfo1.add(lbAddress);

        JPanel pnInfo2 = new JPanel();
        pnInfo2.setLayout(new BoxLayout(pnInfo2, BoxLayout.Y_AXIS));
        pnInfo2.add(lbSymptom);
        pnInfo2.add(lbConclusion);

        pnInfo.add(pnInfo1);
        pnInfo.add(pnInfo2);
        pnContent.add(pnInfo);

        JPanel pnTa = new JPanel();
        JScrollPane scrollPane = new JScrollPane(taPrescriptions);
        pnTa.add(scrollPane);
//		pnTa.add(taPrescriptions);
        pnContent.add(pnTa);

        Dimension lbSize = lbName.getPreferredSize();
        lbName.setPreferredSize(lbSize);
        lbYearOfBirth.setPreferredSize(lbSize);
        lbPhone.setPreferredSize(lbSize);
        lbAddress.setPreferredSize(lbSize);

        pnMain.add(pnContent);
        /*
         * ======================= PANEL BUTTON =======================
         */
        pnButton = new JPanel();
        btnBack = new JButton("Quay lại");
        btnSave = new JButton("Xuất");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnBack.setFont(fontButton);
        btnSave.setFont(fontButton);
        pnButton.add(btnBack);
        pnButton.add(btnSave);
        pnMain.add(pnButton);

        pnSearch = new JPanel();
        lbSearch = new JLabel("Tìm kiếm");
        lbSearch.setFont(font);
        tfSearch = new JTextField(20);
        tfSearch.setFont(font);
        btnGetMedicines = new JButton("Lấy thuốc");
        btnGetMedicines.setFont(font);
        pnSearch.add(lbSearch);
        pnSearch.add(tfSearch);
        pnSearch.add(btnGetMedicines);
        pnMain.add(pnSearch);
        /*
         * ======================= PANEL TABLE =======================
         */
        pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        pnTable.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        pnMain.add(pnTable);

        dtmPrescription = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 3; // Chỉnh sửa cột từ cột 3 trở đi
            }
        };

        dtmPrescription.addColumn("Mã số");
        dtmPrescription.addColumn("Tên thuốc");
        dtmPrescription.addColumn("Đơn vị");
        dtmPrescription.addColumn("Liều dùng");
        dtmPrescription.addColumn("Số lượng");


        tbPrescription = new JTable();
        tbPrescription = new TableCustom(dtmPrescription);

//        SẮP XẾP GIẢM DẦN THEO SỐ LƯỢNG
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbPrescription.getModel());
        tbPrescription.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 4;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        dtmPrescription.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                String updatedValue = tbPrescription.getValueAt(tbPrescription.getSelectedRow(), 4).toString();
                // Tạm thời gỡ bỏ TableModelListener
                TableModelListener[] listeners = dtmPrescription.getTableModelListeners();
                for (TableModelListener listener : listeners) {
                    dtmPrescription.removeTableModelListener(listener);
                }
                int valueCell = -1;
                try {
                    valueCell = Integer.parseInt(updatedValue);
                } catch (Exception e1) {
                    valueCell = -2;
                    System.out.println("lỗi số lượng");
                }
                String idMedicine = tbPrescription.getValueAt(tbPrescription.getSelectedRow(), 0).toString();
                String nameMedicine = tbPrescription.getValueAt(tbPrescription.getSelectedRow(), 1).toString();
                String dosage = tbPrescription.getValueAt(tbPrescription.getSelectedRow(), 3).toString();
                int indexItem = -1;
                for (PrescriptionMedicine item : items) {
                    if (item.getMedicine().getMedicineID().equals(idMedicine)) {
                        indexItem = items.indexOf(item);
                        break;
                    }
                }

                if (valueCell > 0 && indexItem >= 0) {//UPDATE
                    items.get(indexItem).setDosage(dosage);
                    items.get(indexItem).setQuantity(valueCell);
                } else if (valueCell == 0 && indexItem >= 0) {//REMOVE
                    items.remove(indexItem);
                } else if (valueCell > 0 && indexItem < 0) {//ADD
                    items.add(new PrescriptionMedicine(new Medicine(idMedicine, nameMedicine, null, null), dosage, valueCell));
                } else if (valueCell < 0) {//Exception
                    JOptionPane.showMessageDialog(null, "Số lượng không phù hợp");
                    if (indexItem < 0) {
                        tbPrescription.setValueAt(0, tbPrescription.getSelectedRow(), 4);
                    } else {
                        tbPrescription.setValueAt(items.get(indexItem).getQuantity(), tbPrescription.getSelectedRow(), 4);
                    }
                } else {
                    if(valueCell == 0 && indexItem < 0) {
                        System.out.println("không làm gì hết");
                    }else
                        System.out.println("LỖI GÌ ĐÓ Ở PnItemPrescriptions around row 205");
                }

                // Thêm lại TableModelListener
                for (TableModelListener listener : listeners) {
                    dtmPrescription.addTableModelListener(listener);
                }
                sorter.sort();
                btnGetMedicines.doClick();
            }
        });

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        tbPrescription.getColumnModel().getColumn(0).setCellRenderer(renderer);
        tbPrescription.getColumnModel().getColumn(1).setCellRenderer(renderer);
        tbPrescription.getColumnModel().getColumn(2).setCellRenderer(renderer);
        tbPrescription.getColumnModel().getColumn(3).setCellRenderer(renderer);
        tbPrescription.getColumnModel().getColumn(4).setCellRenderer(renderer);

        TableColumnModel columnModelBanHang = tbPrescription.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(60);
        columnModelBanHang.getColumn(1).setPreferredWidth(350);
        columnModelBanHang.getColumn(2).setPreferredWidth(150);
        columnModelBanHang.getColumn(3).setPreferredWidth(350);
        columnModelBanHang.getColumn(4).setPreferredWidth(150);

        JScrollPane scrTblSanPham = new JScrollPane(tbPrescription);
        pnTable.add(scrTblSanPham, BorderLayout.CENTER);
        pnMain.add(pnTable);

//        Patient patient = new Patient("", "name", "address", "phone", 2001, true);
//        lbName.setText(patient.getName());
//        lbYearOfBirth.setText(patient.getYearOfBirth() + "");
//        lbPhone.setText(patient.getPhone());
//        lbAddress.setText(patient.getAddress());
    }

    @Override
    public void update() {
        dtmPrescription.setRowCount(0);
        for (Medicine medicine : medicineModel.getMedicines()) {
            Vector<Object> vec = new Vector<>();
            vec.add(medicine.getMedicineID());
            vec.add(medicine.getName());
            vec.add(medicine.getUnit());
            vec.add(medicine.getDefaultDosage());
            vec.add(0);
            dtmPrescription.addRow(vec);
        }
    }

    public void loadInfo(Patient patient, Visit visit) {
        lbId.setText(patient.getId());
        lbName.setText(patient.getName());
        lbYearOfBirth.setText(patient.getYearOfBirth() + "");
        lbPhone.setText(patient.getPhone());
        lbAddress.setText(patient.getAddress());
        lbSymptom.setText("Triệu chứng: " + visit.getSymptom());
        lbConclusion.setText("Kết luận: " + visit.getConclusion());
    }

    public Medicine getMedicineModel() {
        return medicineModel;
    }

    public void setMedicineModel(Medicine medicineModel) {
        this.medicineModel = medicineModel;
    }

    public JLabel getLbName() {
        return lbName;
    }

    public JLabel getLbPhone() {
        return lbPhone;
    }

    public JLabel getLbAddress() {
        return lbAddress;
    }

    public JLabel getLbYearOfBirth() {
        return lbYearOfBirth;
    }

    public String getSymptom() {
        String symptom = lbSymptom.getText();
        symptom = symptom.substring(symptom.lastIndexOf(":") + 2);
        System.out.println(symptom);
        return symptom;
    }

    public String getConclusion() {
        String conclusion = lbConclusion.getText();
        conclusion = conclusion.substring(conclusion.lastIndexOf(":") + 2);
        System.out.println(conclusion);
        return conclusion;
    }

    public String getPatientId() {
        return lbId.getText();
    }
    public JPanel getPnMain() {
        return pnMain;
    }

    public JPanel getPnTitle() {
        return pnTitle;
    }

    public JPanel getPnTable() {
        return pnTable;
    }

    public JPanel getPnSearch() {
        return pnSearch;
    }

    public JPanel getPnContent() {
        return pnContent;
    }

    public JPanel getPnButton() {
        return pnButton;
    }

    public JLabel getLbSearch() {
        return lbSearch;
    }

    public JTextArea getTaPrescriptions() {
        return taPrescriptions;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public DefaultTableModel getDtmPrescription() {
        return dtmPrescription;
    }

    public JTable getTbPrescription() {
        return tbPrescription;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnGetMedicines() {
        return btnGetMedicines;
    }

    public void setLbPhone(JLabel lbPhone) {
        this.lbPhone = lbPhone;
    }

    public void setLbYearOfBirth(JLabel lbYearOfBirth) {
        this.lbYearOfBirth = lbYearOfBirth;
    }

    public List<PrescriptionMedicine> getItems() {
        return items;
    }
}
