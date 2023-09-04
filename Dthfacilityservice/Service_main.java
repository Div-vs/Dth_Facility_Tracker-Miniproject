package Dthfacilityservice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Service_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service_main frame = new Service_main();
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
	public Service_main() {
		setTitle("Telitron D2H - Customer Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1321, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<HTML> \r\n----------------------------\r\n<br>\r\nCustomer Registrations\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_customerdeets sc=new Service_customerdeets();
				sc.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(525, 106, 287, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblPurchases = new JLabel("<HTML> \r\n----------------------------\r\n<br>\r\nPurchases\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblPurchases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_viewPurchase svp=new Service_viewPurchase();
				svp.setVisible(true);
				dispose();
			}
		});
		lblPurchases.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchases.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPurchases.setBounds(525, 420, 277, 62);
		contentPane.add(lblPurchases);
		
		JLabel lblNewConnections = new JLabel("<HTML>\r\n----------------------------\r\n<br>\r\nNew Connections\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblNewConnections.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_newconnects sn=new Service_newconnects();
				sn.setVisible(true);
				dispose();
			}
		});
		lblNewConnections.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewConnections.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewConnections.setBounds(525, 189, 277, 62);
		contentPane.add(lblNewConnections);
		
		JLabel lblViewPlans = new JLabel("<HTML> \r\n----------------------------\r\n<br>\r\nView Plans\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblViewPlans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_Plans sp=new Service_Plans();
				sp.setVisible(true);
				dispose();
			}
		});
		lblViewPlans.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPlans.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblViewPlans.setBounds(525, 337, 277, 72);
		contentPane.add(lblViewPlans);
		
		JLabel lblLogout = new JLabel("<HTML> \r\n----------------------------\r\n<br>\r\nLogout\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service_Login sl=new Service_Login();
				sl.setVisible(true);			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLogout.setBounds(525, 493, 277, 72);
		contentPane.add(lblLogout);
		
		JLabel lblContactUs = new JLabel("<HTML> \r\n----------------------------\r\n<br>\r\nContact Us\r\n<br>\r\n ----------------------------\r\n</HTML>\"");
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContactUs.setBounds(525, 262, 277, 72);
		contentPane.add(lblContactUs);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Telitron. (6).png"));
		lblNewLabel_1.setBounds(0, 0, 1252, 649);
		contentPane.add(lblNewLabel_1);
	}
}
