import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Student extends JFrame {

	private JPanel contentPane;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Student() {
		super("New Student");
		setResizable(false);
		conn=JavaConnect.ConnecrDb();
		Random();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Student ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 22, 167, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("  Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(58, 57, 167, 24);
		contentPane.add(lblName);
		
		JLabel lblBranch = new JLabel("  Branch");
		lblBranch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBranch.setBounds(58, 149, 167, 24);
		contentPane.add(lblBranch);
		
		JLabel lblCourse = new JLabel("  Course");
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCourse.setBounds(58, 121, 167, 24);
		contentPane.add(lblCourse);
		
		JLabel lblFatherName = new JLabel("  Father Name");
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFatherName.setBounds(58, 91, 167, 24);
		contentPane.add(lblFatherName);
		
		JLabel lblYear = new JLabel("  Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYear.setBounds(58, 184, 167, 24);
		contentPane.add(lblYear);
		
		JLabel lblSeme = new JLabel("  Semester");
		lblSeme.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeme.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSeme.setBounds(58, 219, 167, 24);
		contentPane.add(lblSeme);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(270, 22, 216, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(270, 57, 216, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 91, 216, 20);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MCA", "BCA", "MBA", "BBA", "B TECH", "B.Sc", "Others"}));
		comboBox.setBounds(270, 121, 216, 20);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(270, 149, 216, 20);
		contentPane.add(textField_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_1.setBounds(270, 181, 216, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox_2.setBounds(270, 219, 216, 20);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("  Register");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(Student.class.getResource("/image/login.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql="insert into Student(Student_ID,Name,Father,Course,Branch,Year,Semester) values (?,?,?,?,?,?,?)";
				 
				try {
					pst=conn.prepareStatement(sql);
					
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4,(String)comboBox.getSelectedItem());
					pst.setString(5, textField_3.getText());
					pst.setString(6, (String)comboBox_1.getSelectedItem());
					pst.setString(7,(String)comboBox_2.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Student Register ");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			
				
			}
		});
		btnNewButton.setBounds(172, 267, 113, 28);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(Student.class.getResource("/image/back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Home hm =new Home();
				hm.setVisible(true);
			}
		});
		btnBack.setBounds(334, 267, 113, 28);
		contentPane.add(btnBack);
	}

	public void Random() {
		Random rd=new Random();
		textField.setText(""+rd.nextInt(1000+1));
	}
}
