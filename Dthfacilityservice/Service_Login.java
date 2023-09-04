package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Service_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdminUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service_Login frame = new Service_Login();
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
	public Service_Login() {
		setBackground(new Color(255, 255, 255));
		setTitle("Telitron D2H - Service Provider Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1240, 710);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAdminUsername = new JTextField("Admin");
		txtAdminUsername.setBorder(null);
		txtAdminUsername.setBounds(873, 279, 172, 32);
		contentPane.add(txtAdminUsername);
		txtAdminUsername.setBackground(new Color(255, 255, 255));
		txtAdminUsername.setForeground(new Color(0, 0, 0));
		txtAdminUsername.addKeyListener(new KeyAdapter() {
			int l=1;
			@Override
			public void keyPressed(KeyEvent e) {
				if (l==1)
				  {
					  txtAdminUsername.setText(null);
					  l=l+1;
				  }
			}
		});
		txtAdminUsername.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtAdminUsername.setColumns(10);
		
		passwordField = new JPasswordField("");
		passwordField.setBorder(null);
		passwordField.setBounds(873, 382, 172, 32);
		contentPane.add(passwordField);
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBackground(new Color(255, 255, 255));
		
		JLabel l2_1 = new JLabel("");
		l2_1.setBounds(931, 332, 44, 50);
		contentPane.add(l2_1);
		l2_1.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\pass.jpg"));
		
		JLabel l2 = new JLabel("");
		l2.setBounds(931, 218, 44, 50);
		contentPane.add(l2);
		l2.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\resize-16930348781779698801user.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel("Welcome back!\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(775, 139, 329, 68);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(913, 457, 100, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = txtAdminUsername.getText();
                String p = passwordField.getText();
                
                    if(u.equals("Dora")&&p.equals("123")) 
                    {
                    	Service_main sm=new Service_main();
                        sm.setVisible(true);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(btnNewButton ,"Wrong Username & Password");
                        
                    }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Telitron. (4).png"));
		lblNewLabel.setBounds(0, 0, 1273, 659);
		contentPane.add(lblNewLabel);
	}
}
