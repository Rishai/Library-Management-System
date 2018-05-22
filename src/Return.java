import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Return extends JFrame {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JButton btnReturn;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return frame = new Return();
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
	public Return() {
		super("Return Book ");
		setResizable(false);
		conn=JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudent = new JLabel("  Student ID");
		lblStudent.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStudent.setBounds(10, 22, 96, 19);
		contentPane.add(lblStudent);
		
		JLabel lblNewLabel = new JLabel("  Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 57, 96, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourse = new JLabel("  Course");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCourse.setBounds(10, 116, 96, 19);
		contentPane.add(lblCourse);
		
		JLabel lblFatherName = new JLabel("  Father Name\r\n");
		lblFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFatherName.setBounds(10, 84, 96, 19);
		contentPane.add(lblFatherName);
		
		JLabel lblBranch = new JLabel("   Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBranch.setBounds(10, 146, 96, 19);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("  Year");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYear.setBounds(10, 178, 96, 19);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("  Semester");
		lblSemester.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSemester.setBounds(10, 208, 96, 19);
		contentPane.add(lblSemester);
		
		textField = new JTextField();
		textField.setBounds(110, 22, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(110, 56, 101, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(110, 83, 101, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(110, 115, 101, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(110, 144, 101, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(110, 175, 101, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(110, 208, 101, 19);
		contentPane.add(textField_6);
		
		JLabel label = new JLabel(" Book ID");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setBounds(329, 22, 82, 20);
		contentPane.add(label);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(436, 22, 101, 20);
		contentPane.add(textField_7);
		
		JLabel label_1 = new JLabel("  Name");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(329, 51, 82, 20);
		contentPane.add(label_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(436, 51, 101, 20);
		contentPane.add(textField_8);
		
		JLabel label_2 = new JLabel("  Edition");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_2.setBounds(329, 82, 82, 20);
		contentPane.add(label_2);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(436, 81, 101, 20);
		contentPane.add(textField_9);
		
		JLabel label_3 = new JLabel("  Publisher");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_3.setBounds(329, 111, 82, 20);
		contentPane.add(label_3);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(436, 110, 101, 20);
		contentPane.add(textField_10);
		
		JLabel label_4 = new JLabel("  Price");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_4.setBounds(329, 140, 82, 20);
		contentPane.add(label_4);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(436, 139, 101, 20);
		contentPane.add(textField_11);
		
		JLabel label_5 = new JLabel("  Pages");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_5.setBounds(329, 171, 82, 20);
		contentPane.add(label_5);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_12.setColumns(10);
		textField_12.setBounds(436, 170, 101, 20);
		contentPane.add(textField_12);
		
		JLabel label_6 = new JLabel(" Date of Issue");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_6.setBounds(329, 202, 89, 20);
		contentPane.add(label_6);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(436, 202, 101, 20);
		contentPane.add(textField_13);
		
		JLabel lblDateOfReturn = new JLabel(" Date of Return");
		lblDateOfReturn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateOfReturn.setBounds(329, 236, 89, 20);
		contentPane.add(lblDateOfReturn);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(436, 236, 101, 20);
		contentPane.add(textField_14);
		
		JButton btnNewButton = new JButton(" Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String search="select * from Issue where Student_ID=?";
				try {
					pst=conn.prepareStatement(search);
					pst.setString(1,textField.getText() );
					rs=pst.executeQuery();
					if(rs.next()) {
						String add1=rs.getString("SName");
						textField_1.setText(add1);
						
					String add2=rs.getString("FName");
						textField_2.setText(add2);
						
						String add3=rs.getString("Course");
						textField_3.setText(add3);
						
						String add4=rs.getString("Branch");
						textField_4.setText(add4);
						
						String add5=rs.getString("Year");
						textField_5.setText(add5);
						
						String add6=rs.getString("Semester");
						textField_6.setText(add6);
						
						String add7=rs.getString("Book_ID");
						textField_7.setText(add7);
						
						String add8=rs.getString("Name");
						textField_8.setText(add8);
						
					String add9=rs.getString("Edition");
						textField_9.setText(add9);
						
						String add10=rs.getString("Price");
						textField_10.setText(add10);
						
						String add11=rs.getString("Pages");
						textField_11.setText(add11);
						
						String add12=rs.getString("DOI");
						textField_12.setText(add12);
						
						rs.close();
						pst.close();
					}
					else{
					JOptionPane.showMessageDialog(null, "Book is not issuedwith this student");	
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				finally {
					try {
						rs.close();
						pst.close();
					} catch (SQLException e1) {
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(221, 21, 82, 23);
		contentPane.add(btnNewButton);
		
		btnReturn = new JButton(" Return");
		btnReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnReturn.setIcon(new ImageIcon(Return.class.getResource("/image/returning-down-curved-arrow-from-one-point.png")));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				delete();
				returnUpdate();
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReturn.setBounds(338, 283, 111, 23);
		contentPane.add(btnReturn);
		
		btnBack = new JButton(" Back");
		btnBack.setIcon(new ImageIcon(Return.class.getResource("/image/icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Home hm=new Home();
				hm.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBack.setBounds(459, 283, 89, 23);
		contentPane.add(btnBack);
	}
	public void delete() {
		String del="delete from Issue Where Student_ID=? ";
		try {
			pst=conn.prepareStatement(del);
			pst.setString(1, textField.getText());
			pst.executeQuery();
		} catch (SQLException e) {
		
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public void returnUpdate() {
		String update="insert into Return (Student_ID,Name,FName,Course,Branch,Year,Semester,Book_ID,BName,Edition,Publisher,Price,Pages,DOI,DOR)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try {
			pst=conn.prepareStatement(update);
			pst.setString(1, textField.getText());
			pst.setString(2, textField_1.getText());
			pst.setString(3, textField_2.getText());
			pst.setString(4, textField_3.getText());
			pst.setString(5, textField_4.getText());
			pst.setString(6, textField_5.getText());
			pst.setString(7, textField_6.getText());
			pst.setString(8, textField_9.getText());
			pst.setString(9, textField_8.getText());
			pst.setString(10, textField_9.getText());
			pst.setString(11, textField_10.getText());
			pst.setString(12, textField_11.getText());
			pst.setString(13, textField_12.getText());
			pst.setString(14, textField_13.getText());
			pst.setString(15, textField_14.getText());
			
			
      pst.executeQuery();
      
      JOptionPane.showMessageDialog(null, "BOOK RETURNED");
      
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
		}
         
	}
	
}
