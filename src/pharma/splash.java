package pharma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import com.sun.tools.javac.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class splash extends JFrame {

	private JPanel contentPane;
	public static JProgressBar p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		splash sp =new splash();
		sp.setVisible(true);
		 try {
             for(int i = 0; i<=50; i++)
            {
            Thread.sleep(100);
            splash.p.setValue(i);
          //  p.txtpin.setText(String.valueOf(i)+ "%");
            if(i==50)
            {
                sp.setVisible(false);
              login lg =new login();
              lg.setVisible(true);
            }
            }
            
        } catch (InterruptedException ex) {
           
        }
       
	}

	/**
	 * Create the frame.
	 */
	public splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 636, 403);
		setUndecorated(true);
		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pharmacy Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel.setBounds(145, 33, 384, 29);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(splash.class.getResource("/pharma/image/pharm.jpg")));
		lblNewLabel_1.setBounds(201, 73, 206, 228);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(601, 0, 19, 29);
		contentPane.add(lblNewLabel_2);
		
		p = new JProgressBar();
		p.setForeground(new Color(0, 153, 0));
		p.setBackground(Color.WHITE);
		p.setBounds(10, 353, 610, 39);
		contentPane.add(p);
		
	}
}
