import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 602, 27);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				//dispose();
				System.exit(0);
			}
		});
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		mnFile.add(mntmExit);
		
		JMenuItem mntmLoogout = new JMenuItem("Logout");
		mntmLoogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login log=new Login();
				log.setVisible(true);
			} 
		});
		mnFile.add(mntmLoogout);
		
		JMenu mnNewMenu = new JMenu("Edit");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu.add(mntmAbout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/image/library.png")));
		lblNewLabel.setBounds(456, 38, 89, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("   Welcome");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWelcome.setForeground(SystemColor.textHighlight);
		lblWelcome.setBounds(318, 38, 106, 20);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel_1 = new JLabel("  MY  library");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(318, 73, 106, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTo = new JLabel("   To");
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTo.setForeground(SystemColor.textHighlight);
		lblTo.setBounds(345, 57, 63, 14);
		contentPane.add(lblTo);
		
		JButton btnNewBook = new JButton("New Book");
		btnNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				NewBook nb =new NewBook();
				nb.setVisible(true);
				
			}
		});
		btnNewBook.setBounds(20, 194, 106, 23);
		contentPane.add(btnNewBook);
		
		JButton btnStatistic = new JButton("  Statistics");
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Statistics st=new Statistics();
				st.setVisible(true);
			}
			
		});
		btnStatistic.setBounds(200, 194, 124, 23);
		contentPane.add(btnStatistic);
		
		JButton btnNewButton = new JButton(" New Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student st=new Student();
				st.setVisible(true);
			}
		});
		btnNewButton.setBounds(420, 194, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("  Issue Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Issue is=new Issue();
				is.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(20, 307, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Return Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Return re=new Return();
				re.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(210, 307, 114, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("  About");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				About ab=new About();
				ab.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(420, 307, 125, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/image/book111.png")));
		lblNewLabel_2.setBounds(10, 103, 114, 90);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/image/book_icon.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 217, 125, 90);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/image/statistics-icon.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(199, 103, 125, 90);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/image/student.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(420, 104, 125, 90);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/image/return.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(210, 217, 125, 90);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Home.class.getResource("/image/images.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(420, 217, 125, 90);
		contentPane.add(label_4);
	}
}
