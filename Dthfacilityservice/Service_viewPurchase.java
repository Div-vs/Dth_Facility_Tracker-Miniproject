package Dthfacilityservice;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Service_viewPurchase extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service_viewPurchase frame = new Service_viewPurchase();
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
	public Service_viewPurchase() {
		setTitle("Telitron D2H-View_Purchases");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1387, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String subsc[]= {"-Select-","Tata Play","Airtel DTH","Dish TV"};
		JComboBox comboBox = new JComboBox(subsc);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(316, 63, 261, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

                { 
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					Class.forName("com.mysql.jdbc.Driver");  
					Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron","root","root");  
					String query="select * from purchases";
				    PreparedStatement pst = c1.prepareStatement(query);
                    ResultSet rs = pst.executeQuery(query);
                    while(rs.next())

                    {
                    dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
                    }                     		
                }
				
                catch(Exception e1)

                {
                    System.out.println(e1);

                }
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(643, 63, 108, 33);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBackground(Color.white);
		table.setColumnSelectionAllowed(true);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name ", "Last Name", "Mobile", "Address", "Plan Amount", "Plan Name", "Subscriber"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setPreferredWidth(46);
		table.getColumnModel().getColumn(2).setPreferredWidth(66);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(327);
		table.getColumnModel().getColumn(6).setPreferredWidth(15);
		table.setBounds(44, 161, 1158, 405);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(54, 130, 944, 451);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Homepage");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_main sm2=new Service_main();
				sm2.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(1121, 30, 126, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Telitron. (11).png"));
		lblNewLabel.setBounds(0, 0, 1273, 659);
		contentPane.add(lblNewLabel);
	}
}
