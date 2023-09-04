package Dthfacilityservice;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class User_MyAccount extends JFrame{
	
	public User_MyAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1327, 707);
		contentPane = new JPanel();
		setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setBackground(new Color(0, 0, 0));
		setTitle("Telitron D2H-My Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(539, 534, 286, 70);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MainLogin um2=new User_MainLogin();
				um2.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnCustomisePlans = new JButton("Customise Plans");
		btnCustomisePlans.setBorderPainted(false);
		btnCustomisePlans.setFocusable(false);
		btnCustomisePlans.setForeground(new Color(0, 0, 0));
		btnCustomisePlans.setBounds(539, 284, 286, 70);
		btnCustomisePlans.setBackground(new Color(255, 255, 255));
		btnCustomisePlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_search us1=new User_search();
				us1.setVisible(true);
				dispose();
			}
		});
		btnCustomisePlans.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnCustomisePlans);
		
		JButton btnNewButton_1 = new JButton("New Connection - 24/7\r\n");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(539, 365, 286, 74);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MainLogin ul=new User_MainLogin();
				User_Newconnection unc=new User_Newconnection();
				  try {
					  
	                    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron",
	                        "root", "root");
	                    PreparedStatement st1 = (PreparedStatement) con
	                        .prepareStatement("Select Mobile from registrations where User_name=?");

	                    st1.setString(1, ul.userName);
	                    ResultSet rs1 = st1.executeQuery();
	                    while (rs1.next()) {
	                    	
	                    	unc.txtYourMobileNumber.setText(rs1.getString(1));
	                    
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				unc.setVisible(true);
				dispose();
									
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(63, 109, 70, 70);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\R.png"));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Explore Blog");
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Blog uc1=new User_Blog();
				uc1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setBounds(539, 450, 286, 73);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Buy Plans");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(539, 203, 286, 70);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Plans ui1=new User_Plans();
				ui1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Explore (3).png"));
		lblNewLabel.setBounds(0, 0, 1273, 659);
		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(531, 193, 186, 14);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		textPane.setBackground(new Color(0, 0, 0));
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setBounds(284, 27, 244, 247);
//		lblNewLabel.add(lblNewLabel_2);
	}
	private JPanel contentPane;
	

	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_MyAccount frame = new User_MyAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
