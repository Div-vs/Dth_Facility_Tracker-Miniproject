package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Service_Plans extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service_Plans frame = new Service_Plans();
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
	public Service_Plans() {
		setTitle("Telitron D2H-Plans update");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1365, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Subscriber", "Plan ID", "Plan Name", "Plan Amount", "Plan Validity"
			}
		));
		table.setBounds(214, 150, 702, 437);
		contentPane.add(table);
		
		String subs[]= {"-Select-","Tata Play","Airtel DTH","Dish TV"};
		JComboBox comboBox = new JComboBox(subs);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(431, 66, 261, 44);
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
					String query="select * from plans";
				    PreparedStatement pst = c1.prepareStatement(query);
                    ResultSet rs = pst.executeQuery(query);
                    while(rs.next())
                    {
                    dt.addRow(new Object[] {rs.getString(1),rs.getString(5),rs.getString(2),rs.getString(3),rs.getString(4)});
                    }                     		
                }
				
                catch(Exception e1)

                {
                    System.out.println(e1);

                }
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(809, 70, 126, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Homepage");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_main sm=new Service_main();
				sm.setVisible(true);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 38, 126, 24);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(295, 140, 703, 466);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Telitron. (8).png"));
		lblNewLabel.setBounds(0, 0, 1206, 649);
		contentPane.add(lblNewLabel);
	}
}
