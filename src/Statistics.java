import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import java.awt.Color;

public class Statistics extends JFrame {
    
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Statistics() {
		super("Statistics");
		setResizable(false);
		conn=JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.CYAN);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Issuse Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel.setBounds(14, 7, 551, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 539, 113);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.CYAN);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Return Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel_1.setBounds(19, 146, 551, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 539, 132);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table1();
		table2();
	}
	public void table1() {
		String st="select Book_ID,Name,Edition,Publisher,Price,Pages from Issue";
		try {
			pst=conn.prepareStatement(st);
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void table2() {
		String st="select Student_ID,Name,FName,Course from Return";
		try {
			pst=conn.prepareStatement(st);
			rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
