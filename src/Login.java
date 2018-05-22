import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
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
	public Login() {
		
		super("Login");
		 conn=JavaConnect.ConnecrDb();
		
		setFont(new Font("Dialog", Font.BOLD, 11));
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("  Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(41, 45, 176, 43);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("  Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(45, 102, 174, 34);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(266, 46, 223, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField.setBounds(267, 102, 223, 34);
		contentPane.add(passwordField);
		/*Login
		 * 
		 */
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unused", "deprecation" })
			public void actionPerformed(ActionEvent e) {
				//System.out.println("start login");

			String sql="select * from Account where Username=? and Password=?";
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					rs=pst.executeQuery();
					if(rs.next())    {
						rs.close();
						pst.close();
						setVisible(false);
						Login obj=new Login();
						Home hm=new Home();
					  //  Loading load=new Loading(); loading page not Working
	///obj.setUpLoading();//////////                    
					   // load.setVisible(true);
						hm.setVisible(true);
							            }
					else {
						JOptionPane.showMessageDialog(null, "Incorrect User and Password");
				        }
					}
			catch(Exception e1){
            JOptionPane.showMessageDialog(null, e1);
			     }
				finally {
					try {
						rs.close();
						pst.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			//	System.out.println("login end");
				}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnNewButton.setBounds(189, 176, 101, 48);
		contentPane.add(btnNewButton);
		
		JButton btnSi = new JButton("Signup");
		btnSi.setFont(new Font("Times New Roman", Font.BOLD, 21));
		/*
		 * signup
		 */
		
		btnSi.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
			setVisible(false);	
			Signup obj=new Signup();
			obj.setVisible(true);
				
				
			}
		});
		btnSi.setBounds(350, 183, 111, 41);
		contentPane.add(btnSi);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);	
				Forgot obj=new Forgot();
				obj.setVisible(true);
					
				
			}
		});
		btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnForgotPassword.setBounds(211, 261, 231, 55);
		contentPane.add(btnForgotPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/user-name (1).png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(499, 45, 34, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/image/Security-Password-2-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(500, 102, 34, 34);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("ToolBar.border"), "Login", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 9, 562, 307);
		contentPane.add(panel);
	}
}
