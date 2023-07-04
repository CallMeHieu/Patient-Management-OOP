package com.oop2023nlu.group1.view.container;


import com.oop2023nlu.group1.main.Main;
import com.oop2023nlu.group1.utils.FontConstant;
import com.oop2023nlu.group1.utils.SystemColor;
import com.oop2023nlu.group1.view.panel.PnPrescription;
import com.oop2023nlu.group1.view.panel.PnMedicine;
import com.oop2023nlu.group1.view.panel.PnPatient;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Container extends JFrame {
    private JPanel pnMenu, pnRight, pnTitle, pnContent, pnPatient, pnPrPrescription, pnMedicine;
    private JLabel lbLogo, lbPatient, lbPrescription, lbMedicine;
    private ArrayList<JLabel> listMenu;
    private final CardLayout cardMenuLeftGroup = new CardLayout();
    private PnPatient patientPanel;
    private PnPrescription prescriptionPanel;
    private PnMedicine medicinePanel;

    public Container() {
        Main.changLNF("Nimbus");
        this.setTitle("Phần mềm quản lý bệnh nhân");
        this.setSize(1400, 800);
        addControls();
        addEvent();
        showWindow();
    }

    public PnPatient getPatientPanel() {
        return patientPanel;
    }

    public PnPrescription getPrescriptionPanel() {
        return prescriptionPanel;
    }

    public PnMedicine getMedicinePanel() {
        return medicinePanel;
    }

    public void showWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        this.add(pnMain);

        /*
         * ======================= SIDE BAR MENU =======================
         */
        pnMenu = new JPanel();
        pnMenu.setPreferredSize(new Dimension(250, height));
        pnMenu.setBackground(SystemColor.CONTAINER_BACKGROUND);
        pnMain.add(pnMenu, BorderLayout.WEST);

        lbLogo = new JLabel(new ImageIcon("src/main/image/ContainerView/logo.jpg"), JLabel.CENTER);
        lbLogo.setPreferredSize(new Dimension(250, 200));
        pnMenu.add(lbLogo);

        lbPatient = new JLabel("Bệnh nhân", JLabel.CENTER);
        lbPrescription = new JLabel("Tra cứu toa thuốc", JLabel.CENTER);
        lbMedicine = new JLabel("Quản lí thuốc", JLabel.CENTER);

        listMenu = new ArrayList<>();
        listMenu.add(lbPatient);
        listMenu.add(lbPrescription);
        listMenu.add(lbMedicine);

        for (JLabel jLabel : listMenu) {
            jLabel.setForeground(SystemColor.CONTAINER_TEXT_ITEM_MENU);
            jLabel.setVisible(true);
            jLabel.setPreferredSize(new Dimension(250, 65));
            jLabel.setOpaque(true);
            jLabel.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU);
            jLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pnMenu.add(jLabel);
        }
        lbPatient.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU_SELECTED);

        /*
         * ======================= PANEL RIGHT =======================
         */
        pnRight = new JPanel();
        pnRight.setLayout(new BorderLayout());
        pnRight.setPreferredSize(new Dimension(width - pnMenu.getWidth(), height));
        pnRight.setBackground(new Color(242, 153, 74));
        pnMain.add(pnRight);

        /*
         * ======================= TITLE BAR =======================
         */
        pnTitle = new JPanel();
        pnTitle.setPreferredSize(new Dimension(pnRight.getWidth(), 46));
        pnTitle.setLayout(new BoxLayout(pnTitle, BoxLayout.X_AXIS));
        pnTitle.setBackground(SystemColor.CONTAINER_BACKGROUND_TITLE);
        pnRight.add(pnTitle, BorderLayout.NORTH);

        /*
         * ======================= CONTENT =======================
         */
        pnContent = new JPanel(cardMenuLeftGroup);
        pnRight.add(pnContent);

        pnPatient = new JPanel();
        pnPrPrescription = new JPanel();
        pnMedicine = new JPanel();

        pnContent.add(pnPatient, "1");
        pnContent.add(pnPrPrescription, "2");
        pnContent.add(pnMedicine, "3");

        patientPanel = new PnPatient();
        pnPatient.setLayout(new BorderLayout());
        pnPatient.add(patientPanel, BorderLayout.CENTER);

        prescriptionPanel = new PnPrescription();
        pnPrPrescription.setLayout(new BorderLayout());
        pnPrPrescription.add(prescriptionPanel, BorderLayout.CENTER);

        medicinePanel = new PnMedicine();
        pnMedicine.setLayout(new BorderLayout());
        pnMedicine.add(medicinePanel, BorderLayout.CENTER);

    }

    public void addEvent() {
        for (final JLabel jLabel : listMenu) {
            jLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel jLabelDisable : listMenu) {
                        jLabelDisable.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU);
                    }
                    jLabel.setBackground(SystemColor.CONTAINER_BACKGROUND_ITEM_MENU_SELECTED);

                    String card = "";
                    if (jLabel == lbPatient) {
                        card = "1";
                    } else if (jLabel == lbPrescription) {
                        card = "2";
                    } else {
                        card = "3";
                    }
                    cardMenuLeftGroup.show(pnContent, card);
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
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }
            });
        }
    }

    public void changeScreen(String index) {
        patientPanel.getCardPanelGroup().show(patientPanel.getPnCard(), index);
        switch (index) {
            case "1":
                patientPanel.getLbCard1().setBackground(new Color(240, 240, 240));
                patientPanel.getLbCard1().setFont(FontConstant.setFontPlain(16));
                patientPanel.getLbCard2().setBackground(Color.WHITE);
                patientPanel.getLbCard2().setFont(FontConstant.setFontPlain(14));
                patientPanel.getLbCard3().setBackground(Color.WHITE);
                patientPanel.getLbCard3().setFont(FontConstant.setFontPlain(14));
                break;
            case "2":
                patientPanel.getLbCard2().setBackground(new Color(240, 240, 240));
                patientPanel.getLbCard2().setFont(FontConstant.setFontPlain(16));
                patientPanel.getLbCard1().setBackground(Color.WHITE);
                patientPanel.getLbCard1().setFont(FontConstant.setFontPlain(14));
                patientPanel.getLbCard3().setBackground(Color.WHITE);
                patientPanel.getLbCard3().setFont(FontConstant.setFontPlain(14));
                break;
            case "3":
                patientPanel.getLbCard3().setBackground(new Color(240, 240, 240));
                patientPanel.getLbCard3().setFont(FontConstant.setFontPlain(16));
                patientPanel.getLbCard2().setBackground(Color.WHITE);
                patientPanel.getLbCard2().setFont(FontConstant.setFontPlain(14));
                patientPanel.getLbCard1().setBackground(Color.WHITE);
                patientPanel.getLbCard1().setFont(FontConstant.setFontPlain(14));
                break;
            default:
                System.out.println("Error change screen");
                break;
        }
    }
}
