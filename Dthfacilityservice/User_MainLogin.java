package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class User_MainLogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	public static JTextField txtUsername;
	private JPasswordField passwordField;
	public static String userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_MainLogin frame = new User_MainLogin();
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
	public User_MainLogin() {
		setBackground(new Color(0, 0, 0));
		setTitle("Telitron-D2H Login Portal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1281, 708);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Login Page (1).gif"));
		lblNewLabel.setBounds(10, 11, 954,648);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(974, 11, 264, 649);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
//		txtUsername.addKeyListener(new KeyAdapter() {
//			int c=1;
//			@Override
//			public void keyPressed(KeyEvent e) {
//				
//				
//					  if (c==1)
//					  {
//						  txtUsername.setText(null);
//						  c=c+1;
//					  }
//			}
//		});
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		txtUsername.setText("Username");
		txtUsername.setBounds(67, 217, 172, 30);
		panel.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(67, 321, 172, 30);
		panel.add(passwordField);
		
		JLabel l2 = new JLabel("");
		l2.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\resize-16930348781779698801user.jpg"));
		l2.setBounds(121, 158, 50, 50);
		panel.add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\pass (1).jpg"));
		l3.setBounds(121, 260, 50, 50);
		panel.add(l3);
		
		JButton btnSignin = new JButton("Sign-in");
		btnSignin.setForeground(new Color(255, 255, 255));
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = txtUsername.getText();
                String password = passwordField.getText();
                
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron",
                        "root", "root");
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select User_name, Password from registrations where User_name=? and Password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {

                        User_MyAccount um1=new User_MyAccount();
                        um1.setVisible(true);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(btnSignin, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                
			}		
		});

		btnSignin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignin.setBackground(new Color(0, 0, 0));
		btnSignin.setBounds(99, 404, 100, 30);
		panel.add(btnSignin);
		
		JLabel lblNewLabel_2 = new JLabel("New consumer?");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setBounds(81, 469, 142, 21);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Register here!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_registrations up3=new User_registrations();
				
					up3.setVisible(true);
					dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(63, 500, 160, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("TELITRON");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 31));
		lblNewLabel_1.setBounds(46, 27, 177, 66);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("<Main");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Page mp=new Main_Page();
				mp.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(99, 569, 89, 23);
		panel.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
