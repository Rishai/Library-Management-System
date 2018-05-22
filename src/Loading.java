import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.awt.Color;                      
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Loading extends JFrame implements Runnable{
	Connection conn;
	int s=0;
	Thread th;
     JProgressBar progressBar;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
					//frame.update();
					//frame.run();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		super("Loading");
		setResizable(false);
		th=new Thread((Runnable)this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          My Library ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-2, 11, 603, 44);
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseWait = new JLabel("          Please wait ");
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWait.setBounds(72, 98, 476, 14);
		lblPleaseWait.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblPleaseWait);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		progressBar.setBounds(70, 78, 476, 14);
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Loading.class.getResource("/image/BOOK1.gif")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(174, 145, 225, 135);
		contentPane.add(label);
	}
	public void setUpLoading() {
		setVisible(false);
		th.start();
	}
	public void run() {
		try {
			for(int i=0;i<=100;i++)
			{ //s++;
			int m=progressBar.getMaximum();
			int v=progressBar.getValue();
			progressBar.setValue(i);
			if(v<m) {
				progressBar.setValue(progressBar.getValue()+1);
			}
			else {
				i=101;
				setVisible(false);
				@SuppressWarnings("unused")
				Home hm=new Home();
				setVisible(true);
			}Thread.sleep(50);
			}
			
		}
		catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}
	}
}
