package pharma;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField pass;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy_management", "root","0909");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }

	    }

	/**
	 * Create the frame.
	 */
	 
	 public login() {
			initialize();
			Connect();
			
			
		}
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 621, 406);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 241, 367);
		panel.setBackground(new Color(0, 102, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pharma center");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 101, 160, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_1.setBounds(385, 11, 100, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(251, 108, 121, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PASS\r\n");
		lblNewLabel_1_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(251, 170, 100, 51);
		contentPane.add(lblNewLabel_1_2);
		
		id = new JTextField();
		id.setFont(new Font("Segoe UI", Font.BOLD, 18));
		id.setBounds(340, 129, 241, 30);
		id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 102, 0)));
		contentPane.add(id);
		id.setColumns(10);
		
		 pass = new JPasswordField();
		pass.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pass.setColumns(10);
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 102, 0)));
		pass.setBounds(340, 191, 241, 30);
		contentPane.add(pass);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email_s = id.getText();
				String password_p = pass.getText();
				 Statement stm;
				
				
				/*if(email_s.equals(""))
				{
					JOptionPane.showMessageDialog(null, "email name can't be empty");
				}
				else if(password_p.equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter password");
				}
				//else if()*/
				
					try
					{
					String q = "select * from user_login where id='"+email_s+"' and pass='"+password_p+"'";
		            pst = con.prepareStatement(q);
		            
		            ResultSet rs =pst.executeQuery();
		            if(rs.next()){
		            	
		            	setVisible(false);
		            	homepage hn=new homepage();
		            	hn.setVisible(true);
		            	
		            	
		              
		               
		            	
		               //setVisible(false);
		               
		               
		               
		               
		            }else{
		                JOptionPane.showMessageDialog(null, "Invalid login");
		               
		            }
		        }
				catch (SQLException e1) 
		        {
								
					e1.printStackTrace();
					
			
			
		        }
				
				
				
			}
		});
		login.setBackground(new Color(0, 102, 0));
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		login.setBounds(286, 290, 100, 30);
		contentPane.add(login);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText(null);
				pass.setText(null);
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clear.setBackground(new Color(0, 102, 0));
		clear.setBounds(458, 290, 100, 30);
		contentPane.add(clear);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(576, 0, 19, 29);
		contentPane.add(lblNewLabel_2);
	}
}
