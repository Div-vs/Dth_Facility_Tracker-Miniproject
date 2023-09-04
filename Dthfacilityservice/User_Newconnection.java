package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Newconnection extends JFrame {

	private JPanel contentPane;
	JTextField txtYourMobileNumber;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Newconnection frame = new User_Newconnection();
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
	public User_Newconnection() {
		setTitle("Telitron D2H-New Connection");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1275, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrMinOff = new JTextArea();
		txtrMinOff.setText("Min. 20% off on 6 months\r\n(only in selected areas)");
		txtrMinOff.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		txtrMinOff.setBounds(405, 337, 350, 68);
		contentPane.add(txtrMinOff);
		
		txtYourMobileNumber = new JTextField();
		txtYourMobileNumber.setEditable(false);
		txtYourMobileNumber.setBackground(Color.white);
		txtYourMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtYourMobileNumber.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		txtYourMobileNumber.setBounds(409, 74, 346, 40);
		contentPane.add(txtYourMobileNumber);
		txtYourMobileNumber.setColumns(10);
		String city[]= {"Select area","Poonamallee","Porur"
				, "manapakkam\r\n"
				, "Anna Nagar\r\n"
				, "Aminjikarai\r\n"
				, "Ayanavaram\r\n"
				, "Ambattur\r\n"
				, "Kundrathur\r\n"
				, "Defence Colony\r\n"
				, "Mannurpet\r\n"
				, "Padi\r\n"
				, "Ayappakkam\r\n"
				, "Korattur\r\n"
				, "Mogappair\r\n"
				, "Arumbakkam\r\n"
				, "Avadi\r\n"
				, "Pudur\r\n"
				, "Maduravoyal\r\n"
				, "Koyambedu\r\n"
				, "Ashok Nagar\r\n"
				, "K.K. Nagar\r\n"
				, "Karambakkam\r\n"
				, "Vadapalani\r\n"
				, "Saligramam\r\n"
				, "Virugambakkam\r\n"
				, "Alwarthirunagar\r\n"
				, "Valasaravakkam"};
		JComboBox comboBox = new JComboBox(city);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
		comboBox.setBounds(405, 137, 350, 40);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron", "root", "root");
                    String query = "INSERT INTO new_connection values("+txtYourMobileNumber.getText()+ ",'" + comboBox.getSelectedItem() + "','"+textField.getText().toString()+"')";

                    Statement sta = c1.createStatement();
                    int x = sta.executeUpdate(query);  
                    c1.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
				JOptionPane.showMessageDialog(btnNewButton, "Request Submitted!");
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(522, 212, 120, 33);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Unlock savings with \r\nour exclusive offers");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(370, 282, 415, 33);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrMinOff_1 = new JTextArea();
		txtrMinOff_1.setWrapStyleWord(true);
		txtrMinOff_1.setLineWrap(true);
		txtrMinOff_1.setText("Flat Rs.150 off if you already have any dish antenna");
		txtrMinOff_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		txtrMinOff_1.setBounds(405, 417, 350, 68);
		contentPane.add(txtrMinOff_1);
		
		JTextArea txtrMinOff_1_1 = new JTextArea();
		txtrMinOff_1_1.setWrapStyleWord(true);
		txtrMinOff_1_1.setText("DTH HD Box + antenna starting at Rs.329");
		txtrMinOff_1_1.setLineWrap(true);
		txtrMinOff_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		txtrMinOff_1_1.setBounds(405, 496, 350, 68);
		contentPane.add(txtrMinOff_1_1);
		
		JTextArea txtrMinOff_1_2 = new JTextArea();
		txtrMinOff_1_2.setWrapStyleWord(true);
		txtrMinOff_1_2.setText("Add a 2nd DTH connection at a special price of Rs.600");
		txtrMinOff_1_2.setLineWrap(true);
		txtrMinOff_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		txtrMinOff_1_2.setBounds(405, 575, 350, 68);
		contentPane.add(txtrMinOff_1_2);
		
		JButton btnNewButton_2 = new JButton("Homepage");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MyAccount um=new User_MyAccount();
				um.setVisible(true);			}
			});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(72, 27, 121, 30);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.white);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		textField.setText(dateFormat.format(cal.getTime()));
		contentPane.add(textField);
		textField.setBounds(710, 27, 75, 27);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\One Step to witness the HD~ (2).png"));
		lblNewLabel.setBounds(0, 0, 1206, 659);
		contentPane.add(lblNewLabel);
		
		
	}
}
