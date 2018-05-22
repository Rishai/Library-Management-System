import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Forgot extends JFrame {
	
	@SuppressWarnings("unused")
	private static final String Exception = null;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
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
	@SuppressWarnings("unused")
	public void Search() {
		String a1=textField.getText();
		String sql="select * from Account where Username ='"+a1+"'  ";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(4));
				
				rs.close();
				pst.close();
			}
			else{
				JOptionPane.showMessageDialog(null, "Usrer name is not valid");
				
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
	}
	@SuppressWarnings("unused")
	public void Retrive() {
		
		String s1=textField_1.getText();
		String s2=textField_3.getText();
           String sql="select * from Account where Answer='"+s2+"' ";
		
		
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()) {
				textField_4.setText(rs.getString(3));
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Answer  is not valid");
				
			}
		} catch (SQLException e) {
		
			JOptionPane.showConfirmDialog(null, e);
		}
		
	}
	public Forgot() {
		super("Forgot Password");
		setResizable(false);
		conn= JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("  Username");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(22, 35, 137, 22);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("  Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 68, 137, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblYourPasswordQuestion = new JLabel("  Your Security Question");
		lblYourPasswordQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblYourPasswordQuestion.setBounds(22, 108, 137, 22);
		contentPane.add(lblYourPasswordQuestion);
		
		JLabel lblAnswar = new JLabel("  Answer");
		lblAnswar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAnswar.setBounds(22, 151, 137, 22);
		contentPane.add(lblAnswar);
		
		JLabel lblNewLabel_1 = new JLabel("  Your Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 190, 137, 22);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(190, 36, 201, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(190, 68, 201, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(190, 108, 201, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(190, 152, 201, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(190, 191, 201, 22);
		contentPane.add(textField_4);
		/*Search
		 * 
		 */
		JButton btnSearch = new JButton("Search");
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setIcon(new ImageIcon(Forgot.class.getResource("/image/search.gif")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Search();
				
			}
		});
		btnSearch.setBounds(432, 35, 112, 23);
		contentPane.add(btnSearch);
	/*	Retrive
	 * 
	 */
		JButton btnRetrive = new JButton("Recovery");
		btnRetrive.setHorizontalAlignment(SwingConstants.LEFT);
		btnRetrive.setIcon(new ImageIcon(Forgot.class.getResource("/image/download.png")));
		btnRetrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Retrive();
			}
		});
		btnRetrive.setBounds(432, 95, 112, 23);
		contentPane.add(btnRetrive);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Forgot.class.getResource("/image/undo-arrow.png")));
		btnBack.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login obj=new Login();
				obj.setVisible(true);
				
			}
		});
		btnBack.setBounds(432, 161, 112, 23);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 592, 307);
		contentPane.add(panel);
	}
}
