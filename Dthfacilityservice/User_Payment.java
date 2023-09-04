package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class User_Payment extends JFrame {

	private JPanel contentPane;
	private JTextField txtXxxxXxxxXxxx;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 JTextField textField_3;
	 JTextField textField_4;
	 JTextField textField_5;
	 JTextField textField_6;
	 JTextField textField_8;
	 JTextArea textArea;
	 JTextField textField_7;
	 private JTextField textField_9;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Payment frame = new User_Payment();
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
	public User_Payment() {
		setTitle("Telitron D2H-User_Payment Page");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1255, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\card.jpg"));
		lblNewLabel_1.setBounds(524, 62, 284, 214);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Untitled design (6).png"));
		lblNewLabel.setBounds(0, 0, 451, 667);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CARD NUMBER");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(512, 287, 147, 25);
		contentPane.add(lblNewLabel_2);
		
		txtXxxxXxxxXxxx = new JTextField();
		txtXxxxXxxxXxxx.setBounds(512, 313, 284, 43);
		contentPane.add(txtXxxxXxxxXxxx);
		txtXxxxXxxxXxxx.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("CARD HOLDER NAME");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(512, 367, 147, 25);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(512, 391, 284, 33);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("EXPIRY DATE");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(512, 435, 147, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		String month[]={"Month","Jan","Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"};
		JComboBox comboBox = new JComboBox(month);
		comboBox.setBounds(512, 465, 96, 33);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(comboBox);
		String year[]= {"Year","2023","2024","2025","2026","2027","2028","2029","2030"};
		JComboBox comboBox_1 = new JComboBox(year);
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBox_1.setBounds(618, 465, 96, 33);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CVV");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(726, 435, 36, 25);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(724, 465, 61, 33);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("MAKE PAYMENT");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cn=textField_1.getText();
				String cv=txtXxxxXxxxXxxx.getText();
				if(cn.equals("") || cv.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Payment failed, Please re-try again!","Payment Failed",1);
				}
				else
				{
					new Flashscreen_Payment();
					User_Bill ub=new User_Bill();
    				ub.setVisible(true);
					
					String a=textField_3.getText();
					String b=textField_4.getText();
					String c=textField_5.getText();
					String d=textField_6.getText();
					String h=textField_8.getText();
					String f=textArea.getText();
					String m=textField_7.getText();
					String z=textField_9.getText();
					
					try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron", "root", "root");
	                    String query = "INSERT INTO purchases values('"+a+"','"+b+"','"+c+"','"+d+"','"+h+ "','"+f+"','"+m+"','"+z+"')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    connection.close();
	                    
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }				
				}
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(593, 561, 203, 43);
		contentPane.add(btnNewButton);		
		textField_2 = new JTextField();
		User_MainLogin ul=new User_MainLogin();
		textField_2.setText(ul.userName);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				try

                { 
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					String query=" select First_name,Last_name,Mobile,Address,subcriber from registrations where User_name='"+textField_2.getText()+"'";
				    PreparedStatement pst = c1.prepareStatement(query);
                    ResultSet rs = pst.executeQuery(query);
                    while(rs.next())

                    {
                    	textField_3.setText(rs.getString(1));
                    	textField_4.setText(rs.getString(2));
                    	textField_5.setText(rs.getString(3));
                    	textField_6.setText(rs.getString(4));
                    	textField_7.setText(rs.getString(5));
                    }                     		
                }
				
                catch(Exception e1)

                {
                    System.out.println(e1);

                }
				
			}
		});
		textField_2.setBounds(652, 45, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome,");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(556, 45, 82, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("First name");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(942, 45, 130, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_3.setBounds(942, 70, 197, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Last name");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(942, 108, 116, 14);
		contentPane.add(lblNewLabel_4_1);
		
		
		textField_4.setColumns(10);
		
		textField_4.setBounds(942, 133, 197, 25);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Mobile");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1_1.setBounds(942, 229, 116, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		
		textField_5.setColumns(10);
		textField_5.setBounds(942, 254, 197, 25);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Address");
		lblNewLabel_4_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1.setBounds(942, 291, 116, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		
		textField_6.setColumns(10);
		textField_6.setBounds(942, 313, 197, 72);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Plan Name");
		lblNewLabel_4_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1_1_2.setBounds(942, 461, 116, 14);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Payable Amount");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1_1.setBounds(512, 522, 147, 14);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_8.setColumns(10);
		textField_8.setBounds(650, 519, 135, 25);
		contentPane.add(textField_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(942, 486, 197, 92);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		
		JLabel lblNewLabel_4_2 = new JLabel("Subscriber");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_2.setBounds(942, 170, 130, 14);
		contentPane.add(lblNewLabel_4_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(942, 193, 197, 25);
		contentPane.add(textField_7);
		
		JButton btnNewButton_2 = new JButton("<< back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Plans upl=new User_Plans();
				upl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(1107, 616, 96, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel(" Date of purchase");
		lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_2_1.setBounds(942, 395, 147, 20);
		contentPane.add(lblNewLabel_4_2_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		textField_9.setText(dateFormat.format(cal.getTime()));
		textField_9.setColumns(10);
		textField_9.setBounds(942, 417, 197, 33);
		contentPane.add(textField_9);

	
	}
}
