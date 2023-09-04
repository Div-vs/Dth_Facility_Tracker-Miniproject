package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.TextArea;
import javax.swing.JComboBox;

public class User_registrations extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_registrations frame = new User_registrations();
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
	public User_registrations() {
		setTitle("Telitron D2H-Registration Portal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1284, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(455, 49, 123, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(657, 51, 184, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAstName = new JLabel("Last Name");
		lblAstName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAstName.setBounds(455, 101, 123, 31);
		contentPane.add(lblAstName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(657, 103, 184, 31);
		contentPane.add(textField_1);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMobile.setBounds(455, 155, 123, 31);
		contentPane.add(lblMobile);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(657, 157, 184, 31);
		contentPane.add(textField_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(455, 208, 123, 31);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(657, 210, 184, 31);
		contentPane.add(textField_3);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsername.setBounds(455, 315, 123, 31);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(455, 367, 123, 31);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblConfirmPassword.setBounds(453, 409, 169, 31);
		contentPane.add(lblConfirmPassword);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(657, 317, 184, 31);
		contentPane.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(657, 371, 184, 27);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(657, 413, 184, 27);
		contentPane.add(passwordField_1);
		
		String[] cus= {"-Select-","Tata Play","Airtel DTH","Dish TV"};
		JComboBox comboBox = new JComboBox(cus);
		comboBox.setBounds(658, 266, 183, 31);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sign_Up");
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = textField.getText();
                String lastName = textField_1.getText();
                String mobile = textField_2.getText();
                String address = textField_3.getText();
                String username = textField_4.getText();
                String pass = passwordField.getText();
                String pass1 = passwordField_1.getText();
                String sub1=(String) comboBox.getSelectedItem();
                String strPattern = "^[0-9]{10}$";

                String msg = "" + firstName;
                msg += " \n";
                if(firstName.equals("")||lastName.equals(""))
                {
                	 JOptionPane.showMessageDialog(btnNewButton, "Enter a valid name");
                }
                else if(!mobile.matches(strPattern))
                {
                	JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
                else if(pass.equals(""))
                {
                	JOptionPane.showMessageDialog(btnNewButton, "Check your password");
                }
                else 
                {
                	JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                	try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron", "root", "root");
                        String query = "INSERT INTO registrations values('" + firstName + "','" + lastName + "','" + mobile + "','" +
                            address + "','" + username + "','" + pass + "','" + pass1 + "','" + sub1 + "')";

                        Statement sta = connection.createStatement();
                        int x = sta.executeUpdate(query);  
                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
        
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton.setBounds(554, 462, 123, 31);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("Already have an account?");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(540, 517, 169, 31);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSignin = new JButton("Sign-in");	
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MainLogin um2=new User_MainLogin();
				um2.setVisible(true);
				dispose();
			}
		});
		
		btnSignin.setFocusable(false);
		btnSignin.setForeground(new Color(255, 255, 255));
		btnSignin.setBackground(new Color(0, 0, 0));
		btnSignin.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnSignin.setBounds(556, 588, 108, 39);
		contentPane.add(btnSignin);
		
		JLabel lblSubscriber = new JLabel("Subscriber");
		lblSubscriber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSubscriber.setBounds(455, 266, 123, 31);
		contentPane.add(lblSubscriber);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Untitled design (2).png"));
		lblNewLabel_1.setBounds(0, 0, 1206, 652);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
