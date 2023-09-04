package Dthfacilityservice;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_Bill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Bill frame = new User_Bill();
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
	public User_Bill() {
		setTitle("Telitron D2H-Purchase_Bill");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1310, 705);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(237, 128, 650, 200);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(textArea);
		
		JSlider slider = new JSlider();
		slider.setBackground(new Color(0, 0, 0));
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Final_Splash();
			}
		});
		
		slider.setBounds(259, 511, 368, 19);
		contentPane.add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Your valuable feedback");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(259, 410, 269, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MainLogin uml=new User_MainLogin();
				uml.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(833, 585, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHomepage = new JButton("Homepage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_MyAccount mp=new User_MyAccount();
				mp.setVisible(true);
			}
		});
		
		btnHomepage.setForeground(new Color(255, 255, 255));
		btnHomepage.setBackground(new Color(0, 0, 0));
		btnHomepage.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnHomepage.setBounds(56, 587, 97, 23);
		contentPane.add(btnHomepage);
		
		JLabel lblNewLabel_2 = new JLabel("1    2    3   4   5   6   7   8   9   10   11   12   13");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(269, 466, 368, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Untitled design (8).png"));
		lblNewLabel.setBounds(0, 0, 1206, 659);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		
		textArea_1.setBounds(755, 34, 132, 37);
		contentPane.add(textArea_1);
		
		try {
            Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/telitron", "root", "root");
            String query = "select * from purchases";
            PreparedStatement ps = co.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while(rs.next())
            {          	
            String s1= "Thank you for the purchase!\nYour Bill Receipt:-\n\n\n";
            String s2= "Name: "+rs.getString(1)+" "+rs.getString(2)+"\nMobile: "+rs.getString(3)+"\nPlan Name: "+rs.getString(6)+"\nSubscriber: "+rs.getString(7)+"\nPlan Amount: "+rs.getString(5);
            String disp=s1+s2;    
            textArea.setText(disp);
            textArea_1.setText(rs.getString(8));
//            co.close();
            }
         }catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
