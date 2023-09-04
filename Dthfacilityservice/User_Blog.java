package Dthfacilityservice;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class User_Blog extends JFrame {
   private String text = "Tap to learn";
   private JLabel hyperlink = new JLabel(text);

   public User_Blog() throws HeadlessException {
       super();
       setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\divya.vs\\Pictures\\Img.png"));
       setTitle("Telitron D2H - Contact Us");
       hyperlink.setFont(new Font("Times New Roman", Font.ITALIC, 25));
       hyperlink.setBounds(593, 490, 196, 39);

       hyperlink.setForeground(new Color(255, 255, 255));
       hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

       hyperlink.addMouseListener(new MouseAdapter() {

           @Override
           public void mouseClicked(MouseEvent e) {
               try {
                   Desktop.getDesktop().browse(new URI("https://robots.net/tech/how-to-connect-hdmi-cable-to-tv/"));
               } catch (IOException | URISyntaxException e1) {
                   e1.printStackTrace();
               }
           }

           @Override
           public void mouseExited(MouseEvent e) {
               hyperlink.setText(text);
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               hyperlink.setText("<html><a href=''>" + text + "</a></html>");
           }

       });
       getContentPane().setLayout(null);
       getContentPane().add(hyperlink);
       
       JTextArea txtrHowToConnect = new JTextArea();
       txtrHowToConnect.setForeground(new Color(139, 69, 19));
       txtrHowToConnect.setLineWrap(true);
       txtrHowToConnect.setEditable(false);
       txtrHowToConnect.setOpaque(false);
       txtrHowToConnect.setFont(new Font("Tahoma", Font.PLAIN, 26));
       txtrHowToConnect.setWrapStyleWord(true);
       txtrHowToConnect.setText("How to connect HDMI cable to TV?");
       txtrHowToConnect.setBounds(540, 428, 210, 97);
       getContentPane().add(txtrHowToConnect);
       
       JButton btnNewButton_2 = new JButton("Homepage");
       btnNewButton_2.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		User_MyAccount ua=new User_MyAccount();
       		ua.setVisible(true);
       		dispose();
       	}
       });
       btnNewButton_2.setForeground(Color.WHITE);
       btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
       btnNewButton_2.setFocusable(false);
       btnNewButton_2.setBackground(Color.BLACK);
       btnNewButton_2.setBounds(88, 567, 121, 30);
       getContentPane().add(btnNewButton_2);
       
       JLabel lblNewLabel = new JLabel("");
       lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya.vs\\Downloads\\Explore (4).png"));
       lblNewLabel.setBounds(0, 0, 1273, 659);
       getContentPane().add(lblNewLabel);


       setSize(1412, 687);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {

           @Override
           public void run() {
               new User_Blog().setVisible(true);;
           }
       });;
   }
}
