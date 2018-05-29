import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   My Library");
		lblNewLabel.setBounds(303, 46, 215, 28);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Copyright @ 2018");
		lblNewLabel_1.setBounds(303, 77, 216, 28);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Contact-");
		lblNewLabel_2.setBounds(245, 156, 75, 57);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  abdularif.dgp@gmail.com");
		lblNewLabel_3.setBounds(341, 160, 196, 28);
		lblNewLabel_3.setForeground(new Color(106, 90, 205));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   9775551650");
		lblNewLabel_4.setBounds(341, 187, 174, 26);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(36, 46, 191, 225);
		lblNewLabel_5.setIcon(new ImageIcon(About.class.getResource("/image/pp - Copy.jpg")));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblHttpswwwfacebookcomarifabdul = new JLabel("  www.facebook.com/arif.abdul.7330");
		lblHttpswwwfacebookcomarifabdul.setBounds(324, 220, 258, 28);
		lblHttpswwwfacebookcomarifabdul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblHttpswwwfacebookcomarifabdul);
		
		JButton btnHome = new JButton("GO TO HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home hm=new Home();
				hm.setVisible(true);
			}
		});
		btnHome.setBounds(269, 302, 114, 28);
		contentPane.add(btnHome);
	}
}
