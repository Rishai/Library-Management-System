import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class NewBook extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	JComboBox comboBox;
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
					NewBook frame = new NewBook();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NewBook() {
		super("New Book");
		setResizable(false);
		conn=JavaConnect.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("  Book Id");
		lblBookId.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblBookId.setBounds(72, 48, 164, 19);
		contentPane.add(lblBookId);
		
		JLabel lblNewLabel = new JLabel("  Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 78, 164, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblEdition = new JLabel("  Edition");
		lblEdition.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEdition.setBounds(72, 108, 164, 19);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("  Publisher");
		lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPublisher.setBounds(72, 138, 164, 19);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("  Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(72, 169, 164, 19);
		contentPane.add(lblPrice);
		
		JButton btnNewButton = new JButton("  Add");
		btnNewButton.setIcon(new ImageIcon(NewBook.class.getResource("/image/plus.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="insert into Book(Book_ID,Name,Edition,Publisher,Price,Pages) values (?,?,?,?,?,?)";
				 
				try {
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					//pst.setInt(3, comboBox.getSelectedIndex());
					pst.setString(3,(String)comboBox.getSelectedItem());
				//String x = String.valueOf(comboBox.getSelectedItem());
					pst.setString(4, textField_2.getText());
					pst.setString(5, textField_3.getText());
					pst.setString(6, textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "New book Added ");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(187, 261, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Back");
		btnNewButton_1.setIcon(new ImageIcon(NewBook.class.getResource("/image/icon.png")));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home hm= new Home();
				hm.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(318, 261, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField.setEditable(false);
		textField.setBounds(250, 47, 211, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(250, 77, 211, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_2.setBounds(249, 137, 212, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(250, 168, 211, 20);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(250, 107, 210, 19);
		contentPane.add(comboBox);
		
		JLabel lblPages = new JLabel("  Pages");
		lblPages.setHorizontalAlignment(SwingConstants.CENTER);
		lblPages.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPages.setBounds(72, 199, 164, 19);
		contentPane.add(lblPages);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(250, 199, 211, 20);
		contentPane.add(textField_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(44, 23, 471, 294);
		contentPane.add(panel);
		Random();
	}
	
public void Random() {
	Random rd=new Random();
	textField.setText(""+rd.nextInt(1000+1));
}
}
