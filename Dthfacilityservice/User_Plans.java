package Dthfacilityservice;

import java.sql.*;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;  
public class User_Plans extends JFrame{
	private JTable table;
	private JTextField textField;
	public User_Plans() {
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1266, 694);
		setTitle("Telitron D2H-User Plan Activation Portal");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(358, 204, -299, 279);
		getContentPane().add(table);
		
		
		
		JButton btnNewButton = new JButton("BUY @ 499");
		JTextArea txtrTamilhindiEntertainment = new JTextArea("Tamil/Hindi Entertainment + \r\nKids Combo(220 SD channels + 5 HD)\r\nValidity: 30 days");
		txtrTamilhindiEntertainment.setWrapStyleWord(true);
		txtrTamilhindiEntertainment.setLineWrap(true);
	    txtrTamilhindiEntertainment.setEditable(false);
	    txtrTamilhindiEntertainment.setFocusable(false);
		txtrTamilhindiEntertainment.setBounds(218, 160, 213, 74);
		getContentPane().add(txtrTamilhindiEntertainment);
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			        Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");
			        String query="select Plan_name,Plan_amount from plans where plan_amount=499";
			        PreparedStatement pst = c1.prepareStatement(query);
			        ResultSet rs = pst.executeQuery(query);
			        while(rs.next())
			        {   
			        	User_Payment up1=new User_Payment();
						up1.setVisible(true);
						up1.textArea.setText(rs.getString("Plan_name"));
						up1.textField_8.setText(rs.getString("Plan_amount"));
						dispose();
			        }
			        
			    }
			    catch(Exception e1)
			    {
			        JOptionPane.showMessageDialog(null, e1);
			    }
			}
		});
		btnNewButton.setBounds(56, 183, 131, 37);
		getContentPane().add(btnNewButton);
		
		JButton btnBuy = new JButton("BUY @ 2099");
		btnBuy.setForeground(new Color(255, 255, 255));
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
			    {
			        Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");
			        String query="select Plan_name,Plan_amount from plans where plan_amount=2099";
			        PreparedStatement pst = c1.prepareStatement(query);
			        ResultSet rs = pst.executeQuery(query);
			        while(rs.next())
			        {   
			        	User_Payment up1=new User_Payment();
						up1.setVisible(true);
						up1.textArea.setText(rs.getString("Plan_name"));
						up1.textField_8.setText(rs.getString("Plan_amount"));
						dispose();
			        }
			        
			    }
			    catch(Exception e1)
			    {
			        JOptionPane.showMessageDialog(null, e1);
			    }
				
			}
		});
		btnBuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuy.setBackground(new Color(0, 0, 0));
		btnBuy.setBounds(56, 276, 131, 37);
		getContentPane().add(btnBuy);
		
		JButton btnBuy_1 = new JButton("BUY @ 1099");
		btnBuy_1.setForeground(new Color(255, 255, 255));
		btnBuy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
			    {
			        Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");
			        String query="select Plan_name,Plan_amount from plans where plan_amount=1099";
			        PreparedStatement pst = c1.prepareStatement(query);
			        ResultSet rs = pst.executeQuery(query);
			        while(rs.next())
			        {   
			        	User_Payment up1=new User_Payment();
						up1.setVisible(true);
						up1.textArea.setText(rs.getString("Plan_name"));
						up1.textField_8.setText(rs.getString("Plan_amount"));
						dispose();
			        }
			    }
			    catch(Exception e1)
			    {
			        JOptionPane.showMessageDialog(null, e1);
			    }
				User_Payment up1=new User_Payment();
				up1.setVisible(true);
			}
		});
		btnBuy_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuy_1.setBackground(new Color(0, 0, 0));
		btnBuy_1.setBounds(56, 371, 131, 37);
		getContentPane().add(btnBuy_1);
		
		JButton btnBuy_2 = new JButton("BUY @ 199");
		btnBuy_2.setForeground(new Color(255, 255, 255));
		btnBuy_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try
			    {
			        Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");
			        String query="select Plan_name,Plan_amount from plans where plan_amount=199";
			        PreparedStatement pst = c1.prepareStatement(query);
			        ResultSet rs = pst.executeQuery(query);
			        while(rs.next())
			        {   
			        	User_Payment up1=new User_Payment();
						up1.setVisible(true);
						up1.textArea.setText(rs.getString("Plan_name"));
						up1.textField_8.setText(rs.getString("Plan_amount"));
						dispose();
			        }
			    }
			    catch(Exception e1)
			    {
			        JOptionPane.showMessageDialog(null, e1);
			    }
			}
		});
		btnBuy_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBuy_2.setBackground(new Color(0, 0, 0));
		btnBuy_2.setBounds(56, 480, 131, 37);
		getContentPane().add(btnBuy_2);
		
		JButton btnNewButton_2 = new JButton("Homepage");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MyAccount ua_1=new User_MyAccount();
				ua_1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(21, 11, 121, 30);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Untitled design (1).gif"));
		lblNewLabel.setBounds(452, 11, 790, 635);
		getContentPane().add(lblNewLabel);
		
		JTextArea txtrTamilhindiEntertainment_4 = new JTextArea(" Tamil/Hindi Entertainment +\r\n Kids + Sports Combo(350 SD channels + 25 HD)\r\nValidity: 360 days");
		txtrTamilhindiEntertainment_4.setWrapStyleWord(true);
		txtrTamilhindiEntertainment_4.setLineWrap(true);
		txtrTamilhindiEntertainment_4.setFocusable(false);
		txtrTamilhindiEntertainment_4.setEditable(false);
		txtrTamilhindiEntertainment_4.setBounds(218, 266, 213, 74);
		getContentPane().add(txtrTamilhindiEntertainment_4);
		
		JTextArea txtrTamilhindiEntertainment_1 = new JTextArea("Tamil/Hindi Entertainment +\r\nSports Combo(290 SD channels + 11 HD)\r\nValidity: 90 days");
		txtrTamilhindiEntertainment_1.setWrapStyleWord(true);
		txtrTamilhindiEntertainment_1.setLineWrap(true);
		txtrTamilhindiEntertainment_1.setFocusable(false);
		txtrTamilhindiEntertainment_1.setEditable(false);
		txtrTamilhindiEntertainment_1.setBounds(218, 371, 213, 74);
		getContentPane().add(txtrTamilhindiEntertainment_1);
		
		JTextArea txtrTamilhindiEntertainment_2 = new JTextArea("Tamil/Hindi Entertainment + \r\nSports Combo(220 SD channels + 6 HD)\r\nValidity: 30 days");
		txtrTamilhindiEntertainment_2.setWrapStyleWord(true);
		txtrTamilhindiEntertainment_2.setLineWrap(true);
		txtrTamilhindiEntertainment_2.setFocusable(false);
		txtrTamilhindiEntertainment_2.setEditable(false);
		txtrTamilhindiEntertainment_2.setBounds(218, 475, 213, 74);
		getContentPane().add(txtrTamilhindiEntertainment_2);
		
		JButton btnNewButton_2_1 = new JButton("Customize your plan");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_search us1=new User_search();
				us1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2_1.setFocusable(false);
		btnNewButton_2_1.setBackground(Color.BLACK);
		btnNewButton_2_1.setBounds(33, 588, 194, 30);
		getContentPane().add(btnNewButton_2_1);
		
		
	}  
public static void main(String args[]){  
	User_Plans ui1=new User_Plans();
	ui1.setVisible(true);
	
}
}  