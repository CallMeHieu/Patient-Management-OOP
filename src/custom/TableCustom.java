package custom;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import utils.SystemColor;

public class TableCustom extends JTable {

	private static final long serialVersionUID = 1L;

	public TableCustom(DefaultTableModel defaultTableModel) {

		this.setFocusable(false);
		this.setIntercellSpacing(new Dimension(0, 0));
		this.setRowHeight(25);
		this.setSelectionBackground(SystemColor.TABLE_BACKGROUND_CONTENT_SELECTED);
		this.setSelectionForeground(SystemColor.TABLE_TEXT_CONTENT_SELECTED);
		this.setFont(new Font("Arial", Font.PLAIN, 16));

		JTableHeader header = this.getTableHeader();
		header.setBackground(SystemColor.TABLE_BACKGROUND_HEADER);
		header.setFont(new Font("Arial", Font.BOLD, 16));
		header.setOpaque(false);
		header.setForeground(SystemColor.TABLE_TEXT_HEADER);
		header.setReorderingAllowed(false);
		((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		this.setModel(defaultTableModel);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(defaultTableModel);
		this.setRowSorter(sorter);
	}
}
