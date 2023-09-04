package Dthfacilityservice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Service_customerdeets extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service_customerdeets frame = new Service_customerdeets();
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
	public Service_customerdeets() {
		setTitle("Telitron D2H - Customer Database");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1347, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Mobile", "Address", "User_Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(138, 147, 777, 425);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		contentPane.add(table);
		

		String[] cus1= {"-Select-","Tata Play","Airtel DTH","Dish TV"};
		JComboBox comboBox = new JComboBox(cus1);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(485, 66, 261, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

                { 
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					String query="select First_name,Last_name,Mobile,Address,User_name from registrations where subcriber="+"'"+comboBox.getSelectedItem()+"'";
				    PreparedStatement pst = c1.prepareStatement(query);
                    ResultSet rs = pst.executeQuery(query);
                    while(rs.next())

                    {
                    dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
                    }                     		
                }
				
                catch(Exception e1)

                {
                    System.out.println(e1);

                }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(806, 65, 108, 33);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(283, 133, 650, 416);
		contentPane.add(scrollPane,BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Homepage");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_main sm1=new Service_main();
				sm1.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 32, 126, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Telitron. (7).png"));
		lblNewLabel.setBounds(0, 0, 1273, 659);
		contentPane.add(lblNewLabel);
		

	}
}
