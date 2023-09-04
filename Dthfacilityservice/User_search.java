package Dthfacilityservice;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User_search extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	 JTable table;
	 String custom;
	 int total_price = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_search frame = new User_search();
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
	public User_search() {
		
		setTitle("Telitron D2H-User_Channels");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1217, 725);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox_1 = new JComboBox();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
			 String query="select distinct channelCategoryId from mytable";
		        PreparedStatement pst = c1.prepareStatement(query);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		
		        	comboBox_1.addItem(rs.getString("channelCategoryId"));
		        	
		        }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}	
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox_1.setBounds(652, 141, 110, 33);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
			 String query="select distinct channelLanguageId from mytable";
		        PreparedStatement pst = c1.prepareStatement(query);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		 
		        	comboBox_1_1.addItem(rs.getString("channelLanguageId"));
		        	
		        }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}	
		
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		comboBox_1_1.setBounds(433, 141, 114, 33);
		contentPane.add(comboBox_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customize channels with your plan!");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(391, 21, 568, 74);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Channels");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_2.setBounds(297, 221, 104, 22);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Price");
		lblNewLabel_3_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_1_1.setBounds(577, 221, 86, 22);
		contentPane.add(lblNewLabel_3_1_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=comboBox.getSelectedItem().toString();

				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					 String query="select price from mytable where channel_name='"+a+"'";
				        PreparedStatement pst = c1.prepareStatement(query);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				            String toggle=rs.getString("price");  
				        	textField_2.setText(toggle);
				        	
				        }
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		comboBox.setBounds(433, 220, 114, 33);
		contentPane.add(comboBox);
		

		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

                { 
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					String query="select price from mytable where channel_name='"+comboBox.getSelectedItem().toString()+"'";
				    PreparedStatement pst = c1.prepareStatement(query);
                    ResultSet rs = pst.executeQuery(query);

                    while(rs.next())

                    {

                    dt.addRow(new Object[] {comboBox.getSelectedItem().toString(),rs.getString("price")});
     
                    }                     		
                    for(int i = 0;i<table.getRowCount();i++)

                    {

                        custom=table.getValueAt(i, 0).toString();
                }
                }
				
                catch(Exception e1)

                {
                    System.out.println(e1);

                }}
			});
		
		JButton btnNewButton_4 = new JButton("Done");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        		JLabel total_amount = new JLabel();
        		total_amount.setBounds(692, 603, 90, 20);
        		contentPane.add(total_amount);   
				for(int i = 0; i < table.getRowCount(); i++){
        	        
        	        int Amount = Integer.parseInt(table.getValueAt(i, 1)+"");
        	        total_price = Amount+total_price;   
        	        }       		
        		 total_amount.setText("Rs."+String.valueOf(total_price));
				}
			
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_4.setBounds(577, 604, 86, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(788, 218, 104, 33);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(652, 220, 114, 33);
		contentPane.add(textField_2);	
		
		JLabel lblNewLabel_3 = new JLabel("Language");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(297, 133, 165, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Genre");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(577, 142, 86, 22);
		contentPane.add(lblNewLabel_3_1);
				
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(778, 139, 114, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("PAY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Payment up1=new User_Payment();
				String c = "";
				for(int i = 0;i<table.getRowCount();i++)

                {

                   custom=table.getValueAt(i, 0).toString();
                    c+=custom+"\n";
                }
				
				up1.textArea.setText(c);
				up1.textField_8.setText(String.valueOf(total_price));
				up1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_2.setBounds(770, 541, 89, 46);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Channel Name", "Price"
			}
		));
		table.setBounds(440, 353, 287, 238);
		contentPane.add(table);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
                { 
					DefaultTableModel dt1 = (DefaultTableModel) table.getModel();
					if(table.getSelectedRowCount()==1)
					{
						dt1.removeRow(table.getSelectedRow());
					}
					else {
						JOptionPane.showMessageDialog(null, "Please choose a channel to delete!");
					}
				
                }
                catch(Exception e1)

                {
                    System.out.println(e1);

                }
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
                }
		});
		btnNewButton_3.setBounds(478, 604, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Selected Channel List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(478, 306, 212, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Channels");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(478, 335, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(653, 335, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Untitled design (3).png"));
		lblNewLabel_4.setBounds(0, 0, 1216, 598);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2_1 = new JButton("Homepage");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MyAccount umy=new User_MyAccount();
				umy.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2_1.setFocusable(false);
		btnNewButton_2_1.setBackground(Color.BLACK);
		btnNewButton_2_1.setBounds(23, 605, 121, 30);
		contentPane.add(btnNewButton_2_1);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					 String query="select distinct channel_name from mytable where channelLanguageId='"+comboBox_1_1.getSelectedItem().toString()+
							 "'"+"and channelCategoryId='"+comboBox_1.getSelectedItem().toString()+"'";
				        PreparedStatement pst = c1.prepareStatement(query);
				        ResultSet rs = pst.executeQuery();
				        comboBox.removeAllItems();
				        while(rs.next()){
				           
				        	comboBox.addItem(rs.getString("channel_name"));       	
				        }
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}	
			}
		});
		
		
	}
}
