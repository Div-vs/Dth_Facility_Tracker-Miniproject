package Dthfacilityservice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Flashscreen_Payment extends JWindow {

    public static void main(String[] args) {
        new Flashscreen_Payment();
    }

    public Flashscreen_Payment() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                showSplash();

            }
        });
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);

        // Set the window's bounds, centering the window
        int width = 400;
        int height = 200;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel label = new JLabel("");
        JLabel copyrt = new JLabel("Payment sucessful!", JLabel.CENTER);

        content.add(label, BorderLayout.CENTER);

        label.setLayout(new GridBagLayout());
        copyrt.setFont(new Font("Times New Roman",Font.BOLD, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        label.add(copyrt, gbc);

        ImageIcon wait = new ImageIcon("C:\\Users\\divya.vs\\Downloads\\last.gif");
        label.add(new JLabel(wait), gbc);

        Color oraRed = new Color(0,0,0);
        content.setBorder(BorderFactory.createLineBorder(oraRed,6));

        // Display it
        setVisible(true);
        toFront();

        new ResourceLoader().execute();
    }

    public class ResourceLoader extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {

       
            try {
                Thread.sleep(3700);
            } catch (Exception e) {
            }

            return null;

        }

        @Override
        protected void done() {
            setVisible(false);
        }


    }

}
