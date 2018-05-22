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
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Issue extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
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
	public Issue() {
		super("Issue Book");
		setResizable(false);
		conn=JavaConnect.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(" Book ID");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(10, 22, 82, 20);
		contentPane.add(lblName);
		
		JLabel lblName_1 = new JLabel("  Name");
		lblName_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName_1.setBounds(10, 51, 82, 20);
		contentPane.add(lblName_1);
		
		JLabel lblEdition = new JLabel("  Edition");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdition.setBounds(10, 82, 82, 20);
		contentPane.add(lblEdition);
		
		JLabel lblPages = new JLabel("  Pages");
		lblPages.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPages.setBounds(10, 171, 82, 20);
		contentPane.add(lblPages);
		
		JLabel lblPublisher = new JLabel("  Publisher");
		lblPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPublisher.setBounds(10, 111, 82, 20);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("  Price");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(10, 140, 82, 20);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setBounds(98, 23, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(98, 52, 101, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(98, 82, 101, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(98, 111, 101, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(98, 140, 101, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(98, 171, 101, 20);
		contentPane.add(textField_5);
		/*Book details search
		 * 
		 */
		JButton btnSearch = new JButton("  Search");
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setIcon(new ImageIcon(Issue.class.getResource("/image/search.gif")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookdtl="select * from Book where Book_ID=?";
				try {
					pst=conn.prepareStatement(bookdtl);
					pst.setString(1, textField.getText());
					
					rs=pst.executeQuery();
					if(rs.next()) {
						String add1=rs.getString("Name");
						textField_1.setText(add1);
						String add2=rs.getString("Edition");
						textField_2.setText(add2);
						String add3=rs.getString("Publisher");
						textField_1.setText(add3); 
						String add4=rs.getString("Price");
						textField_4.setText(add4);
						String add5=rs.getString("Pages");
						textField_5.setText(add5);
						
						
						rs.close();
						pst.close();
					}
						
						else {
							JOptionPane.showMessageDialog(null, "BOOK is not found");
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
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearch.setBounds(55, 243, 110, 23);
		contentPane.add(btnSearch);
		
		JLabel lblStudentId = new JLabel(" Student ID");
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStudentId.setBounds(243, 22, 82, 20);
		contentPane.add(lblStudentId);
		
		JLabel label_1 = new JLabel("  Name");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(243, 51, 82, 20);
		contentPane.add(label_1);
		
		JLabel lblFatherName = new JLabel("  Father name");
		lblFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFatherName.setBounds(243, 82, 82, 20);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("  Course");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCourse.setBounds(243, 111, 82, 20);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("  Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBranch.setBounds(243, 140, 82, 20);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("  Year");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblYear.setBounds(243, 171, 82, 20);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("  Semester");
		lblSemester.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSemester.setBounds(243, 202, 82, 20);
		contentPane.add(lblSemester);
		
		JButton button = new JButton("  Search");
		button.setIcon(new ImageIcon(Issue.class.getResource("/image/search.gif")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				String studentdtl="select * from Student where Student_ID=?";
				try {
					pst=conn.prepareStatement(studentdtl);
					pst.setString(1, textField_6.getText());
					
					rs=pst.executeQuery();
					if(rs.next()){
						String add7=rs.getString("Name");
						textField_7.setText(add7);
						
						String add8=rs.getString("Father");
						textField_8.setText(add8);
						
						String add9=rs.getString("Course");
						textField_9.setText(add9); 
						
						String add10=rs.getString("Branch");
						textField_10.setText(add10);
						
						String add11=rs.getString("Year");
						textField_11.setText(add11);
						
						String add12=rs.getString("Semester");
						textField_12.setText(add12); 
						
						rs.close();
						pst.close();
						
			
		           }
					else {
						JOptionPane.showMessageDialog(null, "BOOK is not found");
				}
					
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null,e1);
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
		button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button.setBounds(461, 50, 110, 23);
		contentPane.add(button);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(350, 22, 101, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(350, 51, 101, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(350, 81, 101, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(350, 110, 101, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(350, 139, 101, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(350, 170, 101, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_12.setBounds(350, 203, 101, 19);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblDateOfIssue = new JLabel(" Date of Issue");
		lblDateOfIssue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDateOfIssue.setBounds(243, 233, 89, 20);
		contentPane.add(lblDateOfIssue);
		
		JButton btnIssue = new JButton(" Issue");
		btnIssue.setIcon(new ImageIcon(Issue.class.getResource("/image/issue.png")));
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iss="insert into Issue (Book_ID,Name,Edition,Price,Pages,Student_ID,SName,FName,Course,Branch,Year,Semester,DateOfIssue) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				try {
					pst=conn.prepareStatement(iss);
					
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					pst.setString(9, textField_8.getText());
					pst.setString(10, textField_9.getText());
					pst.setString(11, textField_10.getText());
					pst.setString(12, textField_11.getText());
					pst.setString(13, textField_12.getText());
					pst.setString(14, textField_13.getText());
					//pst.setString(14,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());

					pst.executeQuery();
					JOptionPane.showMessageDialog(null, "Book Issued Sucessfully");
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnIssue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnIssue.setBounds(243, 276, 103, 23);
		contentPane.add(btnIssue);
		
		JButton btnNewButton = new JButton(" Back");
		btnNewButton.setIcon(new ImageIcon(Issue.class.getResource("/image/back.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home hm=new Home();
				hm.setVisible(true);
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(395, 276, 101, 23);
		contentPane.add(btnNewButton);
		
		textField_13 = new JTextField();
		textField_13.setBounds(350, 233, 101, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
	}
}
