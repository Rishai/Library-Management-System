import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Signup extends JFrame {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
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
					Signup frame = new Signup();
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
	public Signup() { 
		super("Login");
		setResizable(false);
		conn= JavaConnect.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("  Username");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(59, 44, 172, 22);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("  Name");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblUsername.setBounds(59, 77, 172, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("  Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPassword.setBounds(59, 115, 172, 22);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("  Security Question");
		lblSecurityQuestion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSecurityQuestion.setBounds(62, 148, 169, 22);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("  Answer");
		lblAnswer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAnswer.setBounds(59, 182, 172, 22);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(258, 45, 214, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(258, 78, 214, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(258, 116, 214, 21);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your mother tungue ?", "What is your nick name ?", "What is your first childhood friend ?", "What is your school name ?"}));
		comboBox.setBounds(258, 149, 214, 20);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(258, 183, 214, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreate = new JButton("  Create");
		btnCreate.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreate.setIcon(new ImageIcon(Signup.class.getResource("/image/create-group-button.png")));
		/*Create btn
		 * 
		 */
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql="insert into Account(Username,Name,Password,Sec_Q,Answer)values(?,?,?,?,?)";
				pst=conn. prepareStatement(sql);
				
				
				pst.setString(1, textField.getText());
				pst.setString(2, textField_1.getText());
			    pst.setString(3, textField_2.getText());
				pst.setString(4,(String)comboBox.getSelectedItem());
				pst.setString(5, textField_3.getText());
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null, "NEW ACCOUNT CREATED");
//				rs.close();
//				pst.close();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
			
		});
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCreate.setBounds(144, 254, 112, 33);
		contentPane.add(btnCreate);
		/*back to login
		 * 
		 */
		JButton btnBack = new JButton("  Back");
		btnBack.setIcon(new ImageIcon(Signup.class.getResource("/image/icon.png")));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
				Login obj=new Login();
				obj.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBack.setBounds(286, 254, 112, 33);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "New Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(39, 22, 485, 297);
		contentPane.add(panel);
	}
}
